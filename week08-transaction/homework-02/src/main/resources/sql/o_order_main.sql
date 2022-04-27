DROP TABLE IF EXISTS `o_order_main_0`;
CREATE TABLE `o_order_main_0`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_1`;
CREATE TABLE `o_order_main_1`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_2`;
CREATE TABLE `o_order_main_2`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_3`;
CREATE TABLE `o_order_main_3`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_4`;
CREATE TABLE `o_order_main_4`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_5`;
CREATE TABLE `o_order_main_5`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_6`;
CREATE TABLE `o_order_main_6`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_7`;
CREATE TABLE `o_order_main_7`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_8`;
CREATE TABLE `o_order_main_8`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_9`;
CREATE TABLE `o_order_main_9`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_10`;
CREATE TABLE `o_order_main_10`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_11`;
CREATE TABLE `o_order_main_11`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_12`;
CREATE TABLE `o_order_main_12`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_13`;
CREATE TABLE `o_order_main_13`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_14`;
CREATE TABLE `o_order_main_14`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';

DROP TABLE IF EXISTS `o_order_main_15`;
CREATE TABLE `o_order_main_15`
(
    `order_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '订单主键',
    `user_id`      bigint(20)          NOT NULL DEFAULT '0' COMMENT '下单用户',
    `user_address` bigint(20)          NOT NULL DEFAULT '0' COMMENT '收货地址信息ID',
    `store_id`     bigint(20)          NOT NULL DEFAULT '0' COMMENT '店铺统计用',
    `transfer_no`  varchar(50)         NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
    `order_status` tinyint(4)          NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
    `created_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
    `updated_at`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `updated_by`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
    `delete_flag`  tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单主表';