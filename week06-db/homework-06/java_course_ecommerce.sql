-- 导出  表 java_course_ecommerce.c_industry 结构
CREATE TABLE IF NOT EXISTS `c_industry` (
  `industry_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '行业Id',
  `industry_name` varchar(20) NOT NULL DEFAULT '' COMMENT '行业名称',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`industry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通用，行业，关联店铺，限制商品类目';


-- 导出  表 java_course_ecommerce.c_product_category 结构
CREATE TABLE IF NOT EXISTS `c_product_category` (
  `product_cate_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '类目id',
  `industry_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '行业id',
  `cate_name` varchar(20) NOT NULL DEFAULT '' COMMENT '类目名称',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`product_cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通用，商品类目表，筛选用，简单实现（不含类目属性）';


-- 导出  表 java_course_ecommerce.m_merchant 结构
CREATE TABLE IF NOT EXISTS `m_merchant` (
  `merchant_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键，商户id',
  `merchant_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商户名称',
  `merchant_license` varchar(50) NOT NULL DEFAULT '' COMMENT '商户营业执照URL',
  `contact_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人手机号',
  `contact_addr` varchar(20) NOT NULL DEFAULT '' COMMENT '联系地址',
  `account` varchar(50) NOT NULL DEFAULT '' COMMENT '登录账号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码md5',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`merchant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户表，对店铺1对多';


-- 导出  表 java_course_ecommerce.m_store 结构
CREATE TABLE IF NOT EXISTS `m_store` (
  `store_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键，店铺id',
  `store_name` varchar(50) NOT NULL DEFAULT '' COMMENT '店铺名称',
  `store_logo` varchar(50) NOT NULL DEFAULT '' COMMENT '店铺头图',
  `store_intro` varchar(50) NOT NULL DEFAULT '' COMMENT '店铺简介',
  `city_id` mediumint(9) unsigned NOT NULL DEFAULT '0' COMMENT '服务城市区域编码（6位）',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺表';


-- 导出  表 java_course_ecommerce.o_order_mian 结构
CREATE TABLE IF NOT EXISTS `o_order_mian` (
  `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '下单用户',
  `user_address` bigint(20) NOT NULL DEFAULT '0' COMMENT '收货地址信息',
  `store_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '店铺统计用',
  `transfer_no` varchar(50) NOT NULL DEFAULT '' COMMENT '运输单号，商家填，不支持拆单运',
  `order_status` varchar(50) NOT NULL DEFAULT '0' COMMENT '0待支付1已支付2已发货3已收货4已关闭（支付超时）',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';


-- 导出  表 java_course_ecommerce.o_order_pay 结构
CREATE TABLE IF NOT EXISTS `o_order_pay` (
  `order_pay_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pay_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付渠道，1 支付宝，2微信',
  `pay_total` int(11) NOT NULL DEFAULT '0' COMMENT '交易总额，单位：分',
  `pay_serail` varchar(255) NOT NULL DEFAULT '' COMMENT '支付平台支付单号',
  `pay_status` varchar(255) NOT NULL DEFAULT '' COMMENT '支付状态 1待支付，2支付超时，3支付成功',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`order_pay_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单支付信息表，发起三方支付，生成pay_serail 后新建\r\n';


-- 导出  表 java_course_ecommerce.o_order_product 结构
CREATE TABLE IF NOT EXISTS `o_order_product` (
  `order_product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'order_main的order_id',
  `product_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '再次下单时跳转现有商品详情',
  `product_snapshot_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '查看下单时的商品信息',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`order_product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品关联表';


-- 导出  表 java_course_ecommerce.o_order_refund 结构
CREATE TABLE IF NOT EXISTS `o_order_refund` (
  `order_refund_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'order_main的order_id',
  `reason` varchar(255) NOT NULL DEFAULT '' COMMENT '退单理由',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态，0新发起，1确认退货 2不能退货 3已退单',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`order_refund_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退单信息表（简易）';


-- 导出  表 java_course_ecommerce.p_product 结构
CREATE TABLE IF NOT EXISTS `p_product` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `store_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '店铺id',
  `cate_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '类目id',
  `pruduct_name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品头图',
  `product_banner` text NOT NULL COMMENT '轮播图URL，JSON数组',
  `product_detial` text NOT NULL COMMENT '商品介绍（富文本）',
  `product_stock` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `product_price` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '价格，单位：分',
  `product_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 上架，2下架',
  `approval_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0未审核，1 通过，2不通过',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';


-- 导出  表 java_course_ecommerce.p_product_snapshot 结构
CREATE TABLE IF NOT EXISTS `p_product_snapshot` (
  `product_snapshot_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `store_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '店铺id',
  `pruduct_name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品头图',
  `product_banner` text NOT NULL COMMENT '轮播图URL，JSON数组',
  `product_detial` text NOT NULL COMMENT '商品介绍（富文本）',
  `product_price` int(11) NOT NULL DEFAULT '0' COMMENT '价格，单位：分',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`product_snapshot_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';


-- 导出  表 java_course_ecommerce.u_common_user 结构
CREATE TABLE IF NOT EXISTS `u_common_user` (
  `common_user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL DEFAULT '' COMMENT '登录账号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码md5',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`common_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='c端用户';


-- 导出  表 java_course_ecommerce.u_common_user_address 结构
CREATE TABLE IF NOT EXISTS `u_common_user_address` (
  `user_address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'common_uer表id',
  `city_id` mediumint(9) NOT NULL DEFAULT '0' COMMENT '城市区域编码',
  `reciver_name` varchar(20) NOT NULL DEFAULT '' COMMENT '收件人姓名',
  `reciver_phone` varchar(20) NOT NULL DEFAULT '' COMMENT '收件人手机号',
  `address_detail` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`user_address_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='c端用户,收货地址表,修改时，逻辑删再新增';


-- 导出  表 java_course_ecommerce.u_sys_user 结构
CREATE TABLE IF NOT EXISTS `u_sys_user` (
  `sys_user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL DEFAULT '' COMMENT '登录账号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码md5',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `role` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名，简易管控后台authority',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建人UID',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `updated_by` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人UID',
  `delete_flag` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删标志，0未删，1已删',
  PRIMARY KEY (`sys_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表，登录鉴权，访问后台系统所有的用户-平台管理，运营';
