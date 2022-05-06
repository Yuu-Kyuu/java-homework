+ ## JVM  
>jvm作为底层支撑，需要了解的有：
![JVM.jpg](https://upload-images.jianshu.io/upload_images/12938943-1fa9c9bbef892c2b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
>     
>其中重点为类加载器与内存模型。
类加载器中，主要自定义类加载器，加载自定义类，覆写JAVA原生类
内存模型很重要！！！
从内存管理中派生出GC，GC的重点为分代回收的策略，各种GC的流程，并调参以达到调优的目的

---
+ ## NIO
NIO在JAVA层面主要掌握Netty的使用，主要是底层的实现，是基于操作系统的多路复用机制，在常见的Linux环境下，即epoll机制
各种IO的演进：
![IO演进.jpg](https://upload-images.jianshu.io/upload_images/12938943-28d7cbb5a1e2757e.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


> Netty的关键组件：  
Bootstrap: 启动线程，开启 socket  
EventLoopGroup  
EventLoop  
SocketChannel: 连接  
ChannelInitializer: 初始化  
ChannelPipeline: 处理器链  
ChannelHandler: 处理器  


Netty的典型应用场景-API Gateway

---
+ ##  并发编程
* 线程生命周期
> ![线程生命周期.png](https://upload-images.jianshu.io/upload_images/12938943-7974524ff3fd15ed.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 线程安全
>线程安全的性质
>- 原子性 - Atomic*类
>- 可见性 - volatile关键字
>- 有序性 - happens-before
>
>线程安全的容器 - *java.util.concurrent.*(Map|List|Set|Queue|Deque)
   ***ConcurrentHashMap
>锁 - synchronized关键字，Lock
>信号量 - CountDownLatch等

* 线程池
>ThreadPoolExecutor
int corePoolSize;
核心线程数
int maximumPoolSize;
最大线程数
ThreadFactory threadFactory;
线程创建工厂
BlockingQueue<Runnable> workQueue;
工作队列
RejectedExecutionHandler handler;
拒绝策略处理器
---
+ ## Spring 和 ORM 等框架
>Spring核心
>* BEAN - 生命周期
>* AOP - 动态代理，CGLib
    *Spring的事务管理
>* SpringBoot - 约定大于配置，自动化配置


>ORM  
JDBC  
Hibernate  
JPA  
MyBatis  

---
+ ## MySQL 数据库和 SQL
>MySQL  
集群配置 - 主从复制（BINLOG），读写分离（中间件，代理），高可用（集群）  
存储引擎  
索引原理 - B+树  
SQL执行过程&解析顺序  
事务管理
![事务隔离级别.png](https://upload-images.jianshu.io/upload_images/12938943-0bbc9ec2a0354387.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>SQL优化:  
表结构优化  
写入优化  
更新优化 - GAP LOCK  
查询优化 - 索引失效，连接查询，读放大，数据量&查询次数  

---
+ ##  分库分表
XYZ三向拆分：
* __X：全库复制__
* __Y：业务领域拆分__
单库（单表）变小，便于管理和维护  
对性能和容量有提升作用  
改造后，系统和数据复杂度降低  
可以作为微服务改造的基础  
库变多，管理变复杂  
对业务系统有较强的侵入性  
改造过程复杂，容易出故障  
拆分到一定程度就无法继续拆分  
* __Z：分库分表__  
解决容量问题  
比垂直拆分对系统影响小  
部分提升性能和稳定性  
集群规模大，管理复杂  
复杂 SQL 支持问题（业务侵入性、性能）  
数据迁移问题  
一致性问题  

>分布式事务：  
强一致：XA  
弱一致：柔性事务 - TCC/AT  

---

+ ## RPC 和微服务
>Dubbo
>![一张图说明DUBBO.png](https://upload-images.jianshu.io/upload_images/12938943-f336636abefba268.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
>1. config 配置层:对外配置接口，以 ServiceConfig, ReferenceConfig 为中心，可以直接初始化配置类， 也可以通过 spring 解析配置生成配置类
>2. proxy 服务代理层:服务接口透明代理，生成服务的客户端 Stub 和服务器端 Skeleton, 以 ServiceProxy 为中心，扩展接口为 ProxyFactory
>3.registry 注册中心层:封装服务地址的注册与发现，以服务 URL 为中心，扩展接口为 RegistryFactory, Registry, RegistryService
>4. cluster 路由层:封装多个提供者的路由及负载均衡，并桥接注册中心，以 Invoker 为中心，扩展接口为 Cluster，Directory，Router，LoadBalance
>5. monitor 监控层:RPC 调用次数和调用时间监控，以 Statistics 为中心，扩展接口为 MonitorFactory, Monitor, MonitorService
>6. protocol 远程调用层:封装 RPC 调用，以 Invocation，Result 为中心，扩展接口为 Protocol， Invoker，Exporter
>7. exchange 信息交换层:封装请求响应模式，同步转异步，以 Request，Response 为中心，扩展接口为 Exchanger，ExchangeChannel，ExchangeClient，ExchangeServer
>8. transport 网络传输层:抽象 mina 和 netty 为统一接口，以 Message 为中心，扩展接口为 Channel， Transporter，Client，Server，Codec
>9. serialize 数据序列化层:可复用的一些工具，扩展接口为 Serialization，ObjectInput， ObjectOutput， ThreadPool




>SpringCloud
![全家桶.png](https://upload-images.jianshu.io/upload_images/12938943-7ba90aa9cc8776e0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
引出微服务各主要组件：  
注册中心  
配置中心  
服务网关  
熔错限流  
集群监控  

---

+ ## 分布式缓存
本地缓存->远程缓存  
缓存策略->LRU，错峰过期，容量规划  
缓存问题：穿透->击穿->雪崩  

>Redis - 高性能，单线程，集群（哨兵，Cluster）  
>__常见实用场景：__  
业务数据缓存  
业务数据处理  
全局一致计数  
高效统计数据  
发布/订阅（消息）  
分布式锁  

---

+ ##  分布式消息队列
>消息的作用
异步通信：异步通信，减少线程等待，特别是处理批量等大事务、耗时操作。
系统解耦：系统不直接调用，降低依赖，特别是不在线也能保持通信最终完成。
削峰平谷：压力大的时候，缓冲部分请求消息，类似于背压处理。
可靠通信：提供多种消息模式、服务质量、顺序保障等。


>三种 QoS:  
At most once，至多一次，消息可能丢失但是不会重复发送;  
At least once，至少一次，消息不会丢失，但是可能会重复;  
Exactly once，精确一次，每条消息肯定会被传输一次且仅一次。  

>消息通用结构
![消息通用结构.png](https://upload-images.jianshu.io/upload_images/12938943-1b272b66ee316e38.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


>常用的MQ：
ActiveMQ/RabbitMQ  
Kafka/RocketMQ  
Apache Pulsar  
