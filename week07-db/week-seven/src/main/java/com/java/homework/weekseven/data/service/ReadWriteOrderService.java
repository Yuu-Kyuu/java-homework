package com.java.homework.weekseven.data.service;

import com.java.homework.weekseven.component.RWDataSource;
import com.java.homework.weekseven.component.ReadWriteDataSource;
import com.java.homework.weekseven.data.dao.OrderMainDao;
import com.java.homework.weekseven.data.dao.OrderProductDao;
import com.java.homework.weekseven.data.entity.OrderMainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReadWriteOrderService {

    @Autowired
    OrderMainDao orderMainDao;

    @RWDataSource(name = ReadWriteDataSource.WRITE_DATASOURCE)
    public Long insertNewOrder() {
        OrderMainEntity o = orderMainDao.save(new OrderMainEntity());
        return o.getOrderId();
    }

    @RWDataSource()
    public OrderMainEntity selectById(long orderId) {
        return orderMainDao.findById(orderId).orElse(null);
    }


}

