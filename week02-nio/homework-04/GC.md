# 基于JDK8的GC总结

## 堆内存分布

+ 分代（除G1）  
  把堆内存划分为两个连续的区域，分别为年轻代和老年代
+ 分区块（G1）  
  把堆内存划分为数个大小相同区块，标记其中非连续的一部分为年轻代，另一部分老年代，并开辟一些连续的区块(Humongous)，存储大对象

其中年轻代会划分出eden和Survivor，Survivor会分s0和s1两个区
拷贝时，有from和to区 当eden+s0作为from时，s1为to；下次回收时，eden+s1作为from，s0为to，依次类推
---

## GC算法总结  
+ 引用计数  
把对象被引用的次数保存起来，被引用时增加，引用释放时减少，当引用数为0时，该对象就可被回收了
+ 可达性分析    
解决引用计数的循环引用问题，通过对GC ROOTS的可达性分析（是否有GC ROOTS对某个对象的引用），来标记一个对象到底是否垃圾  
哪些对象可以作为GC ROOTS？ 
  - 虚拟机栈（栈帧中的本地变量表）中引用的对象
  - 方法区中类静态属性引用的对象（由系统类加载器system class loader加载的对象）
  - 活跃的线程
  - 本地方法栈中JNI（即一般说的native方法）中引用的对象
+ 标记-清除  
  首先标记出需要回收的对象，在标记完成后统一回收所有被标记的对象。  
  会产生内存的碎片化
+ 复制  
复制算法为把存活的对象统一拷贝到一整块空闲的内存区域  
防止了内存随便，但总会有空闲的内存区间，内存利用率不高
+ 标记-清除
标记整理算法与标记清理相同，在清理的过程中，让存活对象往一端移动，即为整理  
提高了内存的使用率


---

## 各GC总结说明

+ #### SerialGC
  年轻代采用Serial  
  老年代采用Serial Old  
  单线程进行垃圾收集，会有STW

+ #### ParallelGC
  年轻代采用Parallel Scavenge  
  老年代采用Parallel Old  
  并行地使用多线程进行垃圾收集，依旧有STW

+ #### CMSGC
  年轻代采用ParNew  
  老年代采用ConcMarkSweep；  
  并发（与业务线程同时）进行垃圾收集，年轻代基于标记-复制算法，有STW  
  老年代回收分为6个阶段
    - 阶段 1: Initial Mark（初始标记）
    - 阶段 2: Concurrent Mark（并发标记）
    - 阶段 3: Concurrent Preclean（并发预清理）
    - 阶段 4: Final Remark（最终标记）
    - 阶段 5: Concurrent Sweep（并发清除）
    - 阶段 6: Concurrent Reset（并发重置）  
      其中1、3阶段会产生短暂的STW

  CMS收集器无法处理浮动垃圾，即在CMS收集器收集过程中新产生的垃圾，如果浮动垃圾较大，会导致CMS失败。  
  当CMS失败后，会启动后备预案，临时启用SerialOld收集器来进行老年代收集 可以使用-XX:
  CMSFullGCsBeforeCompaction参数：设置N次不压缩的FGC后跟着来一次带压缩的FGC（默认为0，即每次FGC都进行碎片整理）

+ #### G1GC
  堆内存分区块，分代是逻辑概念  
  分三大阶段
    + 年轻代模式转移暂停（Evacuation Pause）
    + 并发标记（Concurrent Marking）
        - 阶段 1: Initial Mark（初始标记）
        - 阶段 2: Root Region Scan（Root区扫描）
        - 阶段 3: Concurrent Mark（并发标记）
        - 阶段 4: Remark（再次标记）此处STW
        - 阶段 5: Cleanup（清理）
    + 转移暂停: 混合模式（Evacuation Pause (mixed)）  
      同CMS，某些情况下，会触发Full GC，会退化到SerialOld收集器来进行垃圾清理  
      常见的退化情况：
        - 并发模式失败
        - 晋升失败
        - 巨型对象分配失败

---

## 各GC适用场景

+ #### SerialGC

适合在Client模式下；或者单核CPU，小堆内存的机器上使用

+ #### ParallelGC

JDK8默认的垃圾回收策略，适合多核CPU小堆内存的机器；适合少交互的后台任务；充分利用多核特性，能更快地收集垃圾，从而提高吞吐量

+ #### CMS

适合多核CPU，中等大小堆内存的机器，对停顿、吞吐量都有要求的场景，提升服务的响应速度

+ #### G1

适合多核CPU，大堆内存的机器，追求尽量可控的停顿时间，提升服务的响应速度
