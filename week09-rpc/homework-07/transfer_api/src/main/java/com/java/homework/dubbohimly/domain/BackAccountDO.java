package com.java.homework.dubbohimly.domain;

import lombok.Data;

/**
 * 银行账号表
 */
@Data
public class BackAccountDO {

    /**
     * 人民币账号金额
     */
    private Double rmbAmount;

    /**
     * 美元账号金额
     */
    private Double dollarAmount;

    /**
     * 用户主键
     */
    private Long userId;
}
