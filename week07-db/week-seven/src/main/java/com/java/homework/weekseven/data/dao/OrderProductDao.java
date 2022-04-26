package com.java.homework.weekseven.data.dao;

import com.java.homework.weekseven.data.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qiucihang
 */
@Repository
public interface OrderProductDao extends PagingAndSortingRepository<OrderProductEntity, Long>, JpaSpecificationExecutor<OrderProductEntity> {
}
