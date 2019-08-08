DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL,
  `member_name` varchar(30),
  `password` varchar(255),
  `email` varchar(50),
  `sex` tinyint(1),
  `mobile` varchar(20),
  `birthday` date,
  `createTime` datetime(0),
  PRIMARY KEY (`id`) USING BTREE
);
INSERT INTO `member` VALUES (1, '哈哈', '1', '111', 1, '1111', '2018-12-13', '2018-12-13 14:27:38');