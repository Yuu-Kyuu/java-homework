package com.java.homework.weekseven.data.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

/**
 * `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '下单用户',
 * `user_address` bigint(20) NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
 * `store_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '店铺统计用',
 * `transfer_no` varchar(50) NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
 * `order_status` varchar(50) NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
 * `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
 * `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
 * `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
 * `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
 *
 * @author qiucihang
 */
@Entity
@Table(name = "o_order_mian")
public class OrderMainEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_address")
    private Long userAddress;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "transfer_no")
    private String transferNo;

    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 创建时间
     */
    @Column(name = "created_at", columnDefinition = "datetime", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", columnDefinition = "datetime", insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "delete_flag")
    private Integer deleteFlag;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Long userAddress) {
        this.userAddress = userAddress;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}