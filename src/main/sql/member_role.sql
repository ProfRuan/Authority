DROP TABLE IF EXISTS `member_role`;
CREATE TABLE `member_role`  (
  `id` int(11) NOT NULL,
  `member_id` int(11) NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `member_role` VALUES (1, 1, 1);