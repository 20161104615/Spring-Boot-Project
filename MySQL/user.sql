/*
Navicat MySQL Data Transfer

Source Server         : myjavaweb
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : omss

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-11-30 18:53:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `user_phone` int(50) NOT NULL COMMENT '手机号，也是登录账号',
  `user_pwd` varchar(50) NOT NULL,
  `user_avatar` varchar(100) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_introduced` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '123', '123', '1997-07-08', '123@qq.com', '123');
