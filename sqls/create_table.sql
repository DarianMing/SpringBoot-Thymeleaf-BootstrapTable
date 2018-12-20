CREATE TABLE `department` (
  `id` varchar(32) NOT NULL,
  `manager_id` varchar(32) NOT NULL COMMENT '负责人id',
  `parent_id` varchar(32) NOT NULL DEFAULT "0" COMMENT '父部门id',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `level` varchar(50) DEFAULT NULL COMMENT '部门层级',
  `remark` varchar(50) NOT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门表';