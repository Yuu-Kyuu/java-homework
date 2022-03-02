package com.java.homework.weekseven.data.dao;

import com.java.homework.weekseven.data.entity.OrderMainEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author qiucihang
 */
public interface OrderMainDao extends PagingAndSortingRepository<OrderMainEntity, Long>, JpaSpecificationExecutor<OrderMainEntity> {
}
