package com.java.homework.weekseven.data.service;

import com.java.homework.weekseven.data.dao.OrderMainDao;
import com.java.homework.weekseven.data.dao.OrderProductDao;
import com.java.homework.weekseven.data.entity.OrderMainEntity;
import com.java.homework.weekseven.data.entity.OrderProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMainDao orderMainDao;

    @Autowired
    OrderProductDao orderProductDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    //12086999ms
    public void insertRandomOrderData(int count) {
        for (int i = 0; i < count; i++) {
            orderMainDao.save(new OrderMainEntity());

//            OrderProductEntity op = new OrderProductEntity();
//            op.setOrderId(o.getOrderId());
//            op.setProductId(1L);
//            op.setProductSnapshotId(1L);
//            op.setCreatedBy(0L);
//            op.setUpdatedBy(0L);
//            op.setDeleteFlag(0);
//            orderProductDao.save(op);
        }
    }


    //jpa batch插入226653ms
    public void insertRandomOrderDataBatch(int count) {
        ArrayList<OrderMainEntity> orderMainEntityList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            orderMainEntityList.add(new OrderMainEntity());
        }
        orderMainDao.saveAll(orderMainEntityList);

//        OrderProductEntity op = new OrderProductEntity();
//        op.setOrderId(o.getOrderId());
//        op.setProductId(1L);
//        op.setProductSnapshotId(1L);
//        op.setCreatedBy(0L);
//        op.setUpdatedBy(0L);
//        op.setDeleteFlag(0);
//
//        List<OrderProductEntity> orderProductEntityList = Collections.nCopies(100000, op);
//        orderProductDao.saveAll(orderProductEntityList);
    }

    //  119910 ms
    public void insertSQLBatchs(int count) {
        ArrayList<OrderMainEntity> orderMainEntityList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            orderMainEntityList.add(new OrderMainEntity());
        }

        jdbcTemplate.batchUpdate("INSERT INTO o_order_mian ( `user_id`, `user_address`, `store_id`) VALUES (?,?,?)",
                orderMainEntityList,
                10000,
                (ps, argument) -> {
                    ps.setLong(1, argument.getUserId());
                    ps.setLong(2, argument.getUserAddress());
                    ps.setLong(3, argument.getStoreId());
                });
    }

    //2499ms 特别快
    public void insertSQLValues(int count) {
        StringBuilder sql = new StringBuilder("INSERT INTO o_order_mian ( `user_id`, `user_address`, `store_id`) VALUES (1,1,1)");
        for (int i = 0; i < count; i++) {
            sql.append(",(1,1,1)");
        }
        jdbcTemplate.execute(sql.toString());
    }
}

