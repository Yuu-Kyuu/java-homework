package com.java.homework.weekseven.data.dao;

import com.java.homework.weekseven.data.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author qiucihang
 */
public interface OrderProductDao extends PagingAndSortingRepository<OrderProductEntity, Long>, JpaSpecificationExecutor<OrderProductEntity> {
}
