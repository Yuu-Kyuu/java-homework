package com.java.homework.weekseven.data.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

/**
 * `order_product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `order_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'order_main的order_id',
 * `product_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '再次下单时跳转现有商品详情',
 * `product_snapshot_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '查看下单时的商品信息',
 * `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
 * `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
 * `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
 * `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
 *
 * @author qiucihang
 */
@Entity
@Table(name = "o_order_product")
public class OrderProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Long orderProductId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_snapshot_id")
    private Long productSnapshotId;

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

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSnapshotId() {
        return productSnapshotId;
    }

    public void setProductSnapshotId(Long productSnapshotId) {
        this.productSnapshotId = productSnapshotId;
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