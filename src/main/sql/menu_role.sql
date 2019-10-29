DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(11) NOT NULL,
  `menu_id` int(11) NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);