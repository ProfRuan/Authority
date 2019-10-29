DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL COMMENT '上级菜单',
  `name` varchar(30) COMMENT '菜单名称',
  `url` varchar(200) COMMENT '路径',
  `type` tinyint(1) COMMENT '菜单类型 1:菜单 2:路径',
  `valid` tinyint(1) NULL DEFAULT NULL COMMENT '是否有效 1是 0否',
  `createTime` datetime(0),
  PRIMARY KEY (`id`)
);