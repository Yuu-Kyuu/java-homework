package com.java.homework.weekseven.data.service;

import com.java.homework.weekseven.data.dao.OrderMainDao;
import com.java.homework.weekseven.data.dao.OrderProductDao;
import com.java.homework.weekseven.data.entity.OrderMainEntity;
import com.java.homework.weekseven.data.entity.OrderProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderMainDao orderMainDao;

    @Autowired
    OrderProductDao orderProductDao;

    public void insertRandomOrderData(int count) {
        orderMainDao.deleteAll();
        for (int i = 0; i < count; i++) {
            OrderMainEntity o = new OrderMainEntity();
            o.setUserId(1L);
            o.setUserAddress(1L);
            o.setStoreId(1L);
            o.setTransferNo("");
            o.setOrderStatus(0);
            o.setDeleteFlag(0);
            o.setCreatedBy(0L);
            o.setUpdatedBy(0L);
            o.setDeleteFlag(0);
            orderMainDao.save(o);


            OrderProductEntity op = new OrderProductEntity();
            op.setOrderId(o.getOrderId());
            op.setProductId(1L);
            op.setProductSnapshotId(1L);
            op.setCreatedBy(0L);
            op.setUpdatedBy(0L);
            op.setDeleteFlag(0);
            orderProductDao.save(op);
        }
    }
}
