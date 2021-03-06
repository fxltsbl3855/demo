/*
Navicat MySQL Data Transfer

Source Server         : 192.168.207.159
Source Server Version : 50724
Source Host           : 192.168.207.159:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-25 15:59:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (1, 'datasource2-test1', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (2, 'datasource2-test2', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
