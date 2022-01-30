CREATE TABLE `test` (
                        `test_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                        `test_name` varchar(30) NOT NULL COMMENT '名称',
                        `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                        `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                        `update_time` datetime DEFAULT now() COMMENT '更新时间',
                        PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='作业用测试表';