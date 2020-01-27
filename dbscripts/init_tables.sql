### 1.系统管理员表
CREATE TABLE `space_console_admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL COMMENT '电子邮箱',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `name` varchar(128) NOT NULL COMMENT '管理员名称',
  `role_code` varchar(128) NOT NULL COMMENT '角色编码',
  `status` varchar(128) NOT NULL COMMENT '管理员状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注信息',
  `created_by` varchar(128) NOT NULL COMMENT '创建人',
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_changed_by` varchar(128) DEFAULT NULL COMMENT '最后修改人',
  `last_changed_on` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_console_admin_email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='space控制台系统管理员表';

