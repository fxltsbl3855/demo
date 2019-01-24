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

INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (1, 'datasource1-test1', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (2, 'datasource1-test2', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (3, 'datasource1-test3', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (4, 'datasource1-test4', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (5, 'datasource1-test5', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (6, 'datasource1-test6', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (7, 'datasource1-test7', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (8, 'datasource1-test8', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (9, 'datasource1-test9', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (10, 'datasource1-test10', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (11, 'datasource1-test11', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (12, 'datasource1-test12', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (13, 'datasource1-test13', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (14, 'datasource1-test14', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (15, 'datasource1-test15', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (16, 'datasource1-test16', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (17, 'datasource1-test17', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (18, 'datasource1-test18', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (19, 'datasource1-test19', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (20, 'datasource1-test20', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (21, 'datasource1-test21', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');
INSERT INTO `user` (`id`, `name`, `age`, `email`,`phone`,`message`,`address`,`city`,`ip`,`login`) VALUES (22, 'datasource1-test22', 31, 'test@yto.email.cn', '1234567890', 'this is message', '授课计划看撒娇大家都会','xian', '0.0.0.0','100');


