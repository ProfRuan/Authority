DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL COMMENT '权限id',
  `method` varchar(10) COMMENT '方法类型',
  `zuul_prefix` varchar(30) COMMENT '网关前缀',
  `service_prefix` varchar(30) COMMENT '服务前缀',
  `uri` varchar(100) COMMENT '请求路径',
  `createTime` datetime(0) NULL COMMENT '创建日期',
  `updateTime` datetime(0) NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
);
INSERT INTO `permission` VALUES (1, 'GET', '/api', '/auth', 'exit', '2018-12-14 09:45:35', '2018-12-14 09:45:37');
INSERT INTO `permission` VALUES (2, 'GET', '/api', '/auth', 'member', '2018-12-17 13:23:25', '2018-12-17 13:23:27');
INSERT INTO `permission` VALUES (3, 'GET', '/api', '/member', 'hello', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `permission` VALUES (4, 'GET', '/api', '/member', 'current', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `permission` VALUES (5, 'GET', '/api', '/member', 'query', '2018-12-17 13:23:25', '2018-12-17 13:23:25');