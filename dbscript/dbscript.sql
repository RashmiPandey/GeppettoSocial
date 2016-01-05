create database `sociallogin`;
use `sociallogin`;

DROP TABLE IF EXISTS `sociallogin`.`user`;
CREATE TABLE  `sociallogin`.`user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10022 DEFAULT CHARSET=utf8;