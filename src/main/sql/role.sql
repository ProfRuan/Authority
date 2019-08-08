DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `valid` tinyint(1) NULL DEFAULT NULL COMMENT '是否有效 1是 0否',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ;
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN', 1, '2018-12-14 09:46:01', '2018-12-14 09:46:03');
INSERT INTO `role` VALUES (2, 'ROLE_USER', 1, '2018-12-14 09:46:16', '2018-12-14 09:46:18');
