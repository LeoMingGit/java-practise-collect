/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2022-09-22 13:31:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `test_id` bigint(20) NOT NULL COMMENT '主键ID',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `test_type` int(11) DEFAULT NULL COMMENT '测试下划线字段命名类型',
  `test_date` datetime DEFAULT NULL COMMENT '日期',
  `role` bigint(20) DEFAULT NULL COMMENT '测试',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '1', '雷锋', '1', '1', '2017-01-01 01:01:01', '1', '10010');
INSERT INTO `user` VALUES ('1', '1', '三毛', '2', '1', '2017-02-02 01:01:01', '1', '10086');
INSERT INTO `user` VALUES ('2', '1', '小马', '1', '1', '2017-03-03 01:01:01', '1', '10000');
INSERT INTO `user` VALUES ('3', '2', '麻花藤', '1', '1', '2017-03-03 01:01:01', '1', '10000');
INSERT INTO `user` VALUES ('4', '2', '东狗', '2', '1', '2017-03-03 01:01:01', '1', '10086');
INSERT INTO `user` VALUES ('5', '1', '王五', '2', '1', '2017-03-03 01:01:01', '1', '10010');
