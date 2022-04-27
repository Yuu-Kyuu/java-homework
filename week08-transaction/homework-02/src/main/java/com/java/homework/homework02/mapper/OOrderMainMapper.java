package com.java.homework.homework02.mapper;

import com.java.homework.homework02.domain.OOrderMain;

/**
 * @author qiucihang
 * @description 针对表【o_order_mian(订单主表)】的数据库操作Mapper
 * @createDate 2022-04-26 17:56:19
 * @Entity com.java.homework.homework02.domain.OOrderMian
 */
public interface OOrderMainMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OOrderMain record);

    int insertSelective(OOrderMain record);

    OOrderMain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OOrderMain record);

    int updateByPrimaryKey(OOrderMain record);

}
