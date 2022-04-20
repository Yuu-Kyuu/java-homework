package com.java.homework.dubbohimly.domain;

import lombok.Data;

/**
 * 冻结表
 */
@Data
public class FreezeDO {

    /**
     * 人民币账号冻结金额
     */
    private Double rmbFreezeAmount;

    /**
     * 美元账号冻结金额
     */
    private Double dollarFreezeAmount;

    /**
     * 用户主键
     */
    private Long userId;
}
