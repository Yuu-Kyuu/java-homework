package com.java.homework.weekseven.data.service;

import com.java.homework.weekseven.data.dao.OrderMainDao;
import com.java.homework.weekseven.data.entity.OrderMainEntity;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShadingSphereOrderService {

    @Autowired
    OrderMainDao orderMainDao;

    public Long insertNewOrder() {
        try (HintManager instance = HintManager.getInstance()) {
            instance.setWriteRouteOnly();
            OrderMainEntity o = orderMainDao.save(new OrderMainEntity());
            return o.getOrderId();
        }
    }

    public Object selectById(long orderId) {
        try (HintManager instance = HintManager.getInstance()) {
            instance.setDataSourceName("readDataSource");
            return orderMainDao.findAll();
        }
    }
}

