package com.java.homework.homework02.service;

import com.java.homework.homework02.domain.OOrderMain;
import com.java.homework.homework02.mapper.OOrderMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * homework-06
 *
 * @author qiucihang
 */
@Service
@EnableTransactionManagement
//(proxyTargetClass=true)
public class OrderTranstractionService {
    @Autowired
    OOrderMainMapper orderMainMapper;

    @Transactional(transactionManager = "xaTransaction", propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, ArithmeticException.class})
    public void xaTest() {

        OOrderMain order = new OOrderMain();
        order.setUserId(1L);
        order.setUserAddress(1L);
        order.setStoreId(16L);
        order.setTransferNo("dfljkghldfgh");
        order.setOrderStatus(0);
        order.setDeleteFlag(0);
        order.setCreatedBy(0L);
        order.setUpdatedBy(0L);
        order.setDeleteFlag(0);
        orderMainMapper.insertSelective(order);

        //此数据在2库，强更transferNo为null会报错
        OOrderMain order2 = orderMainMapper.selectByPrimaryKey(726128946105548801L);
        order2.setStoreId(null);
        order2.setTransferNo("sldkfhjlsdkhj");
        orderMainMapper.updateByPrimaryKeySelective(order2);
        int a = 1 / 0;
    }

}
