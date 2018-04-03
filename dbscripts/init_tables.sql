### 1.系统管理员表
CREATE TABLE `space_console_admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL COMMENT '电子邮箱',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `name` varchar(128) NOT NULL COMMENT '管理员名称',
  `role_code` varchar(32) NOT NULL COMMENT '角色代码, 关联space_console_role表code列',
  `avatar` varchar(128) DEFAULT NULL COMMENT '管理员头像, URL地址',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注信息',
  `status` enum('AVAILABLE','UNAVAILABLE') NOT NULL DEFAULT 'AVAILABLE' COMMENT '状态',
  `created_by` varchar(128) NOT NULL COMMENT '创建人',
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_changed_by` varchar(128) DEFAULT NULL COMMENT '最后修改人',
  `last_changed_on` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_console_admin_email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='space控制台系统管理员表';

### 系统管理员角色表
CREATE TABLE `t_console_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL COMMENT '角色名称',
  `code` varchar(32) NOT NULL COMMENT '角色代码',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '角色级别, 值越大, 级别越高',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注信息',
  `status` enum('AVAILABLE','UNAVAILABLE') NOT NULL DEFAULT 'AVAILABLE' COMMENT '状态',
  `created_by` varchar(128) NOT NULL COMMENT '创建人',
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_changed_by` varchar(128) DEFAULT NULL COMMENT '最后修改人',
  `last_changed_on` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_console_role_code` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='space控制台系统角色表';
