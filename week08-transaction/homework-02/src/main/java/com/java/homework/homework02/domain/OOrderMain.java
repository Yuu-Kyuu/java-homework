package com.java.homework.homework02.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单主表
 * @TableName o_order_main
 */
@Data
public class OOrderMain implements Serializable {
    /**
     * 
     */
    private Long orderId;

    /**
     * 下单用户
     */
    private Long userId;

    /**
     * 收货地址信息ID
     */
    private Long userAddress;

    /**
     * 店铺统计用
     */
    private Long storeId;

    /**
     * 运输单号，商家填，不支持拆单运
     */
    private String transferNo;

    /**
     * 0待支付1已支付2已发货3已收货4已关闭（支付超时）
     */
    private Integer orderStatus;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人UID
     */
    private Long createdBy;

    /**
     * 最后修改时间
     */
    private Date updatedAt;

    /**
     * 最后修改人UID
     */
    private Long updatedBy;

    /**
     * 逻辑删标志，0未删，1已删
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;
}