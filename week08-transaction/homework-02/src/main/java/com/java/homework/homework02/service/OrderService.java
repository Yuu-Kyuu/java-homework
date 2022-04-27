package com.java.homework.homework02.service;

import com.java.homework.homework02.domain.OOrderMain;
import com.java.homework.homework02.mapper.OOrderMainMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    @Autowired
    OOrderMainMapper orderMianMapper;

    public void testInsert() {
        for (int i = 0; i < 100; i++) {
            OOrderMain order = new OOrderMain();
            order.setUserId(1L);
            order.setUserAddress(1L);
            order.setStoreId(1L);
            order.setTransferNo(RandomStringUtils.randomAlphanumeric(6));
            order.setOrderStatus(0);
            order.setDeleteFlag(0);
            order.setCreatedBy(0L);
            order.setUpdatedBy(0L);
            order.setDeleteFlag(0);
            orderMianMapper.insertSelective(order);
        }
    }

    public void testDelete(Long orderId) {
        orderMianMapper.deleteByPrimaryKey(orderId);
    }


    public void testUpdate(Long orderId) {
        OOrderMain o = orderMianMapper.selectByPrimaryKey(orderId);
        String transferNo = RandomStringUtils.randomAlphanumeric(6);
        o.setTransferNo(transferNo);
        System.out.println("update id =====>" + orderId + "=====> transfer no:" + transferNo);
        orderMianMapper.updateByPrimaryKey(o);
    }


    public OOrderMain testSelect(Long orderId) {
        return orderMianMapper.selectByPrimaryKey(orderId);
    }


}
