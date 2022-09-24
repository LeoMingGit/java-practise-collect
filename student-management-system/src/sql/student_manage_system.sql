/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : student_manage_system

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2021-10-29 18:56:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `biz_course`
-- ----------------------------
DROP TABLE IF EXISTS `biz_course`;
CREATE TABLE `biz_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseno` varchar(255) DEFAULT NULL,
  `coursename` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `courseid` (`courseno`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_course
-- ----------------------------
INSERT INTO `biz_course` VALUES ('1', 'c001', '高数2', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('3', 'c002', 'java', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('4', 'c003', 'linux', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('6', 'c005', 'android', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('7', 'c007', '数据库', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('8', 'c008', '中国近代史', '2021-10-15 16:10:01');
INSERT INTO `biz_course` VALUES ('9', 'c009', '物理', '2021-10-15 16:10:01');

-- ----------------------------
-- Table structure for `biz_gradeclass`
-- ----------------------------
DROP TABLE IF EXISTS `biz_gradeclass`;
CREATE TABLE `biz_gradeclass` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `clazz` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`code`),
  KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_gradeclass
-- ----------------------------
INSERT INTO `biz_gradeclass` VALUES ('1', '201601', '16级1班', '2016', '1', '2021-07-09 15:41:14');
INSERT INTO `biz_gradeclass` VALUES ('2', '201602', '16级2班', '2016', '2', '2021-07-09 15:43:18');
INSERT INTO `biz_gradeclass` VALUES ('3', '201603', '16级3班', '2016', '3', '2021-07-09 15:43:48');
INSERT INTO `biz_gradeclass` VALUES ('4', '201701', '17级1班', '2017', '1', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('5', '201702', '17级2班', '2017', '2', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('6', '201703', '17级3班', '2017', '3', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('7', '201704', '17级4班', '2017', '4', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('8', '201705', '17级5班', '2017', '5', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('9', '201801', '18级1班', '2018', '1', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('10', '201802', '18级2班', '2018', '2', '2021-07-09 15:47:02');
INSERT INTO `biz_gradeclass` VALUES ('11', '201803', '18级3班', '2018', '3', '2021-07-09 15:47:02');

-- ----------------------------
-- Table structure for `biz_student`
-- ----------------------------
DROP TABLE IF EXISTS `biz_student`;
CREATE TABLE `biz_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuno` varchar(40) DEFAULT '',
  `graclass` varchar(255) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stuno` (`stuno`),
  KEY `fk_gra_class` (`graclass`),
  CONSTRAINT `fk_gra_class` FOREIGN KEY (`graclass`) REFERENCES `biz_gradeclass` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_student
-- ----------------------------
INSERT INTO `biz_student` VALUES ('1', '201601003', '201602', '张三2', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('14', '201602001', '201602', '王五', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('16', '201602003', '201602', 'sadq', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('17', '201602004', '201602', 'qwqws', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('18', '201602005', '201602', 'sasas', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('19', '201602006', '201602', 'esdrw', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('20', '201602007', '201602', 'sasq', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('21', '201602008', '201602', 'sasa', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('22', '201602009', '201602', 'lili', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('23', '201602010', '201602', 'siri', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('26', '201601006', '201601', '赵五', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('27', '201601007', '201601', '露西', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('28', '201601008', '201601', '娜娜', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('29', '201601009', '201601', '王源·', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('30', '201601010', '201601', '欧阳锋', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('31', '201603001', '201603', '莎莎', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('32', '201603002', '201603', '茉莉', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('33', '201603003', '201603', '丽丽', '女 ', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('34', '201603004', '201603', '阿柱', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('35', '201603005', '201603', '阿智', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('36', '201603006', '201603', '阿勇', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('37', '201603007', '201603', '阿华', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('38', '201603008', '201603', '阿木', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('39', '201603009', '201603', '阿月', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('41', '201603010', '201603', '阿紫', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('42', '201701001', '201701', '阿栋', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('43', '201701002', '201701', '阿杜', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('44', '201701003', '201701', '小叶', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('45', '201701004', '201701', '小花', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('46', '201701005', '201701', '小韩', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('47', '201701006', '201701', '小汉', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('48', '201701007', '201701', '小米', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('49', '201701008', '201701', '小西', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('50', '201701009', '201701', '小古', '男', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('204', '201701010', '201701', '小肖', '女', '13971168751', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('205', '201801001', '201801', '小董', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('206', '201801002', '201801', '张飞', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('207', '201801003', '201801', '刘备', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('208', '201801004', '201801', '小美', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('209', '201801005', '201801', '关羽', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('210', '201801006', '201801', '曹超', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('211', '201801007', '201801', '小溪', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('212', '201801008', '201801', '小宋', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('213', '201801009', '201801', '小郑', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('214', '201801010', '201801', '小维', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('215', '201802001', '201802', '小夏', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('216', '201802002', '201802', '小卿', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('217', '201802003', '201802', '小冯', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('218', '201802004', '201802', '小赵', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('219', '201802005', '201802', '小苗', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('220', '201802006', '201802', '小五', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('221', '201802007', '201802', '小关', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('222', '201802008', '201802', '小喜', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('223', '201802009', '201802', '小科', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('224', '201802010', '201802', '阿昌', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('225', '201803001', '201803', '阿善', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('226', '201803002', '201803', '阿亮', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('227', '201803003', '201803', '小刘', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('228', '201803004', '201803', '小丁', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('229', '201803005', '201803', '小高', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('230', '201803006', '201803', '小蔡', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('231', '201803007', '201803', '小邓', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('232', '201803008', '201803', '小熊', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('233', '201803009', '201803', '小情', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('234', '201803010', '201803', '小王', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('235', '201702001', '201702', '小李', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('236', '201702002', '201702', '人王', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('237', '201702003', '201702', '小万', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('238', '201702004', '201702', '小陆', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('239', '201702005', '201702', '小戴', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('240', '201702006', '201702', '郭富城', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('241', '201702007', '201702', '小继', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('242', '201702008', '201702', '阿章', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('243', '201702009', '201702', '李林', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('244', '201702010', '201702', '小七', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('245', '201703001', '201703', '侃侃', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('246', '201703002', '201703', '小泽', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('247', '201703003', '201703', '小达', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('248', '201703004', '201703', '小何', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('249', '201703005', '201703', '阿秀', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('250', '201703006', '201703', '小林', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('251', '201703007', '201703', '小森', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('252', '201703008', '201703', '小嘉', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('253', '201703009', '201703', '老杨', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('254', '201703010', '201703', '阿宝', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('259', '201703001', '201703', '阿亮', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('260', '201703002', '201703', '文忠', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('261', '201703003', '201703', '阿文', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('262', '201703004', '201703', '阿永', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('263', '201703005', '201703', '阿南', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('264', '201703006', '201703', '阿红', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('265', '201703007', '201703', '阿正', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('266', '201703008', '201703', '小侯', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('267', '201703009', '201703', '阿生', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('268', '201703010', '201703', '阿秀', '男', '1234567890', '1234567890', '2020-01-01 11:01:01');
INSERT INTO `biz_student` VALUES ('269', '201601065', '201601', '李伟', '男', '111111', '111111', '2021-10-28 17:40:17');
INSERT INTO `biz_student` VALUES ('272', '222', '201601', '222', '男', '222', '222', '2021-10-29 12:51:05');

-- ----------------------------
-- Table structure for `biz_student_score`
-- ----------------------------
DROP TABLE IF EXISTS `biz_student_score`;
CREATE TABLE `biz_student_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuno` varchar(30) NOT NULL,
  `courseno` varchar(30) NOT NULL,
  `score` float(30,1) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stuno` (`stuno`),
  KEY `fk_cou` (`courseno`)
) ENGINE=InnoDB AUTO_INCREMENT=646 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_student_score
-- ----------------------------
INSERT INTO `biz_student_score` VALUES ('15', '201601001', 'c001', '0.0', '未批改');
INSERT INTO `biz_student_score` VALUES ('16', '201601002', 'c001', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('17', '201601003', 'c001', '75.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('18', '201601004', 'c001', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('19', '201601005', 'c001', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('20', '201601006', 'c001', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('21', '201601007', 'c001', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('22', '201601008', 'c001', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('23', '201601009', 'c001', '43.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('24', '201601010', 'c001', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('25', '201601001', 'c002', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('26', '201601002', 'c002', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('27', '201601003', 'c002', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('28', '201601004', 'c002', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('29', '201601005', 'c002', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('30', '201601006', 'c002', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('31', '201601007', 'c002', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('32', '201601008', 'c002', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('33', '201601009', 'c002', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('34', '201601010', 'c002', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('35', '201601001', 'c003', '0.0', '未批改');
INSERT INTO `biz_student_score` VALUES ('36', '201601002', 'c003', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('37', '201601003', 'c003', '25.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('38', '201601004', 'c003', '45.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('39', '201601005', 'c003', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('40', '201601006', 'c003', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('41', '201601007', 'c003', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('42', '201601008', 'c003', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('43', '201601009', 'c003', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('44', '201601010', 'c003', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('45', '201601001', 'c004', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('46', '201601002', 'c004', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('47', '201601003', 'c004', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('48', '201601004', 'c004', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('49', '201601005', 'c004', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('50', '201601006', 'c004', '44.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('51', '201601007', 'c004', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('52', '201601008', 'c004', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('53', '201601009', 'c004', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('54', '201601010', 'c004', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('55', '201601001', 'c005', '15.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('56', '201601002', 'c005', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('57', '201601003', 'c005', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('58', '201601004', 'c005', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('59', '201601005', 'c005', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('60', '201601006', 'c005', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('61', '201601007', 'c005', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('62', '201601008', 'c005', '15.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('63', '201601009', 'c005', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('64', '201601010', 'c005', '44.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('65', '201601001', 'c006', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('66', '201601002', 'c006', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('67', '201601003', 'c006', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('68', '201601004', 'c006', '46.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('69', '201601005', 'c006', '81.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('70', '201601006', 'c006', '67.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('71', '201601007', 'c006', '93.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('72', '201601008', 'c006', '64.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('73', '201601009', 'c006', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('74', '201601010', 'c006', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('75', '201602001', 'c001', '0.0', '未批改');
INSERT INTO `biz_student_score` VALUES ('76', '201602002', 'c001', '26.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('77', '201602003', 'c001', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('78', '201602004', 'c001', '9.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('79', '201602005', 'c001', '33.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('80', '201602006', 'c001', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('81', '201602007', 'c001', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('82', '201602008', 'c001', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('83', '201602009', 'c001', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('84', '201602010', 'c001', '61.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('85', '201602001', 'c002', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('86', '201602002', 'c002', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('87', '201602003', 'c002', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('88', '201602004', 'c002', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('89', '201602005', 'c002', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('90', '201602006', 'c002', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('91', '201602007', 'c002', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('92', '201602008', 'c002', '49.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('93', '201602009', 'c002', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('94', '201602010', 'c002', '89.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('95', '201602001', 'c003', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('96', '201602002', 'c003', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('97', '201602003', 'c003', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('98', '201602004', 'c003', '45.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('99', '201602005', 'c003', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('100', '201602006', 'c003', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('101', '201602007', 'c003', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('102', '201602008', 'c003', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('103', '201602009', 'c003', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('104', '201602010', 'c003', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('105', '201602001', 'c004', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('106', '201602002', 'c004', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('107', '201602003', 'c004', '30.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('108', '201602004', 'c004', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('109', '201602005', 'c004', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('110', '201602006', 'c004', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('111', '201602007', 'c004', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('112', '201602008', 'c004', '67.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('113', '201602009', 'c004', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('114', '201602010', 'c004', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('115', '201602001', 'c005', '70.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('116', '201602002', 'c005', '36.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('117', '201602003', 'c005', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('118', '201602004', 'c005', '31.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('119', '201602005', 'c005', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('120', '201602006', 'c005', '81.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('121', '201602007', 'c005', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('122', '201602008', 'c005', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('123', '201602009', 'c005', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('124', '201602010', 'c005', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('125', '201602001', 'c006', '67.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('126', '201602002', 'c006', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('127', '201602003', 'c006', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('128', '201602004', 'c006', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('129', '201602005', 'c006', '49.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('130', '201602006', 'c006', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('131', '201602007', 'c006', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('132', '201602008', 'c006', '98.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('133', '201602009', 'c006', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('134', '201602010', 'c006', '33.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('135', '201603001', 'c001', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('136', '201603002', 'c001', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('137', '201603003', 'c001', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('138', '201603004', 'c001', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('139', '201603005', 'c001', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('140', '201603006', 'c001', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('141', '201603007', 'c001', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('142', '201603008', 'c001', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('143', '201603009', 'c001', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('144', '201603010', 'c001', '64.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('145', '201603001', 'c002', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('146', '201603002', 'c002', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('147', '201603003', 'c002', '72.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('148', '201603004', 'c002', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('149', '201603005', 'c002', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('150', '201603006', 'c002', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('151', '201603007', 'c002', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('152', '201603008', 'c002', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('153', '201603009', 'c002', '76.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('154', '201603010', 'c002', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('155', '201603001', 'c003', '56.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('156', '201603002', 'c003', '49.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('157', '201603003', 'c003', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('158', '201603004', 'c003', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('159', '201603005', 'c003', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('160', '201603006', 'c003', '88.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('161', '201603007', 'c003', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('162', '201603008', 'c003', '36.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('163', '201603009', 'c003', '1.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('164', '201603010', 'c003', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('165', '201603001', 'c004', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('166', '201603002', 'c004', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('167', '201603003', 'c004', '71.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('168', '201603004', 'c004', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('169', '201603005', 'c004', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('170', '201603006', 'c004', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('171', '201603007', 'c004', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('172', '201603008', 'c004', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('173', '201603009', 'c004', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('174', '201603010', 'c004', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('175', '201603001', 'c005', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('176', '201603002', 'c005', '1.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('177', '201603003', 'c005', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('178', '201603004', 'c005', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('179', '201603005', 'c005', '89.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('180', '201603006', 'c005', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('181', '201603007', 'c005', '75.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('182', '201603008', 'c005', '31.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('183', '201603009', 'c005', '30.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('184', '201603010', 'c005', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('185', '201603001', 'c006', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('186', '201603002', 'c006', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('187', '201603003', 'c006', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('188', '201603004', 'c006', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('189', '201603005', 'c006', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('190', '201603006', 'c006', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('191', '201603007', 'c006', '1.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('192', '201603008', 'c006', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('193', '201603009', 'c006', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('194', '201603010', 'c006', '81.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('195', '201701001', 'c001', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('196', '201701002', 'c001', '33.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('197', '201701003', 'c001', '80.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('198', '201701004', 'c001', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('199', '201701005', 'c001', '71.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('200', '201701006', 'c001', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('201', '201701007', 'c001', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('202', '201701008', 'c001', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('203', '201701009', 'c001', '26.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('204', '201701010', 'c001', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('205', '201701001', 'c002', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('206', '201701002', 'c002', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('207', '201701003', 'c002', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('208', '201701004', 'c002', '88.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('209', '201701005', 'c002', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('210', '201701006', 'c002', '33.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('211', '201701007', 'c002', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('212', '201701008', 'c002', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('213', '201701009', 'c002', '9.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('214', '201701010', 'c002', '31.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('215', '201701001', 'c003', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('216', '201701002', 'c003', '43.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('217', '201701003', 'c003', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('218', '201701004', 'c003', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('219', '201701005', 'c003', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('220', '201701006', 'c003', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('221', '201701007', 'c003', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('222', '201701008', 'c003', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('223', '201701009', 'c003', '7.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('224', '201701010', 'c003', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('225', '201701001', 'c004', '46.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('226', '201701002', 'c004', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('227', '201701003', 'c004', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('228', '201701004', 'c004', '99.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('229', '201701005', 'c004', '56.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('230', '201701006', 'c004', '80.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('231', '201701007', 'c004', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('232', '201701008', 'c004', '31.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('233', '201701009', 'c004', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('234', '201701010', 'c004', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('235', '201701001', 'c005', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('236', '201701002', 'c005', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('237', '201701003', 'c005', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('238', '201701004', 'c005', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('239', '201701005', 'c005', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('240', '201701006', 'c005', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('241', '201701007', 'c005', '44.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('242', '201701008', 'c005', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('243', '201701009', 'c005', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('244', '201701010', 'c005', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('245', '201701001', 'c006', '56.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('246', '201701002', 'c006', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('247', '201701003', 'c006', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('248', '201701004', 'c006', '67.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('249', '201701005', 'c006', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('250', '201701006', 'c006', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('251', '201701007', 'c006', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('252', '201701008', 'c006', '81.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('253', '201701009', 'c006', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('254', '201701010', 'c006', '25.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('255', '201702001', 'c001', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('256', '201702002', 'c001', '54.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('257', '201702003', 'c001', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('258', '201702004', 'c001', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('259', '201702005', 'c001', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('260', '201702006', 'c001', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('261', '201702007', 'c001', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('262', '201702008', 'c001', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('263', '201702009', 'c001', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('264', '201702010', 'c001', '71.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('265', '201702001', 'c002', '98.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('266', '201702002', 'c002', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('267', '201702003', 'c002', '93.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('268', '201702004', 'c002', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('269', '201702005', 'c002', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('270', '201702006', 'c002', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('271', '201702007', 'c002', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('272', '201702008', 'c002', '70.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('273', '201702009', 'c002', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('274', '201702010', 'c002', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('275', '201702001', 'c003', '7.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('276', '201702002', 'c003', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('277', '201702003', 'c003', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('278', '201702004', 'c003', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('279', '201702005', 'c003', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('280', '201702006', 'c003', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('281', '201702007', 'c003', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('282', '201702008', 'c003', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('283', '201702009', 'c003', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('284', '201702010', 'c003', '17.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('285', '201702001', 'c004', '98.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('286', '201702002', 'c004', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('287', '201702003', 'c004', '93.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('288', '201702004', 'c004', '56.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('289', '201702005', 'c004', '1.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('290', '201702006', 'c004', '36.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('291', '201702007', 'c004', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('292', '201702008', 'c004', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('293', '201702009', 'c004', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('294', '201702010', 'c004', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('295', '201702001', 'c005', '15.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('296', '201702002', 'c005', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('297', '201702003', 'c005', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('298', '201702004', 'c005', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('299', '201702005', 'c005', '35.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('300', '201702006', 'c005', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('301', '201702007', 'c005', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('302', '201702008', 'c005', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('303', '201702009', 'c005', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('304', '201702010', 'c005', '52.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('305', '201702001', 'c006', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('306', '201702002', 'c006', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('307', '201702003', 'c006', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('308', '201702004', 'c006', '17.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('309', '201702005', 'c006', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('310', '201702006', 'c006', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('311', '201702007', 'c006', '9.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('312', '201702008', 'c006', '28.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('313', '201702009', 'c006', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('314', '201702010', 'c006', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('315', '201703001', 'c001', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('316', '201703002', 'c001', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('317', '201703003', 'c001', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('318', '201703004', 'c001', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('319', '201703005', 'c001', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('320', '201703006', 'c001', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('321', '201703007', 'c001', '93.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('322', '201703008', 'c001', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('323', '201703009', 'c001', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('324', '201703010', 'c001', '18.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('325', '201703001', 'c002', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('326', '201703002', 'c002', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('327', '201703003', 'c002', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('328', '201703004', 'c002', '43.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('329', '201703005', 'c002', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('330', '201703006', 'c002', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('331', '201703007', 'c002', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('332', '201703008', 'c002', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('333', '201703009', 'c002', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('334', '201703010', 'c002', '28.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('335', '201703001', 'c003', '70.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('336', '201703002', 'c003', '69.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('337', '201703003', 'c003', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('338', '201703004', 'c003', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('339', '201703005', 'c003', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('340', '201703006', 'c003', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('341', '201703007', 'c003', '28.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('342', '201703008', 'c003', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('343', '201703009', 'c003', '28.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('344', '201703010', 'c003', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('345', '201703001', 'c004', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('346', '201703002', 'c004', '89.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('347', '201703003', 'c004', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('348', '201703004', 'c004', '46.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('349', '201703005', 'c004', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('350', '201703006', 'c004', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('351', '201703007', 'c004', '25.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('352', '201703008', 'c004', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('353', '201703009', 'c004', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('354', '201703010', 'c004', '17.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('355', '201703001', 'c005', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('356', '201703002', 'c005', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('357', '201703003', 'c005', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('358', '201703004', 'c005', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('359', '201703005', 'c005', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('360', '201703006', 'c005', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('361', '201703007', 'c005', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('362', '201703008', 'c005', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('363', '201703009', 'c005', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('364', '201703010', 'c005', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('365', '201703001', 'c006', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('366', '201703002', 'c006', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('367', '201703003', 'c006', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('368', '201703004', 'c006', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('369', '201703005', 'c006', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('370', '201703006', 'c006', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('371', '201703007', 'c006', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('372', '201703008', 'c006', '70.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('373', '201703009', 'c006', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('374', '201703010', 'c006', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('375', '201801001', 'c001', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('376', '201801002', 'c001', '0.0', '未批改');
INSERT INTO `biz_student_score` VALUES ('377', '201801003', 'c001', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('378', '201801004', 'c001', '0.0', '未批改');
INSERT INTO `biz_student_score` VALUES ('379', '201801005', 'c001', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('380', '201801006', 'c001', '52.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('381', '201801007', 'c001', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('382', '201801008', 'c001', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('383', '201801009', 'c001', '30.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('384', '201801010', 'c001', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('385', '201801001', 'c002', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('386', '201801002', 'c002', '61.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('387', '201801003', 'c002', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('388', '201801004', 'c002', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('389', '201801005', 'c002', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('390', '201801006', 'c002', '72.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('391', '201801007', 'c002', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('392', '201801008', 'c002', '22.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('393', '201801009', 'c002', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('394', '201801010', 'c002', '77.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('395', '201801001', 'c003', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('396', '201801002', 'c003', '69.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('397', '201801003', 'c003', '44.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('398', '201801004', 'c003', '15.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('399', '201801005', 'c003', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('400', '201801006', 'c003', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('401', '201801007', 'c003', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('402', '201801008', 'c003', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('403', '201801009', 'c003', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('404', '201801010', 'c003', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('405', '201801001', 'c004', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('406', '201801002', 'c004', '99.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('407', '201801003', 'c004', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('408', '201801004', 'c004', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('409', '201801005', 'c004', '49.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('410', '201801006', 'c004', '71.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('411', '201801007', 'c004', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('412', '201801008', 'c004', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('413', '201801009', 'c004', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('414', '201801010', 'c004', '46.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('415', '201801001', 'c005', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('416', '201801002', 'c005', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('417', '201801003', 'c005', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('418', '201801004', 'c005', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('419', '201801005', 'c005', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('420', '201801006', 'c005', '25.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('421', '201801007', 'c005', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('422', '201801008', 'c005', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('423', '201801009', 'c005', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('424', '201801010', 'c005', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('425', '201801001', 'c006', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('426', '201801002', 'c006', '26.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('427', '201801003', 'c006', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('428', '201801004', 'c006', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('429', '201801005', 'c006', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('430', '201801006', 'c006', '76.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('431', '201801007', 'c006', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('432', '201801008', 'c006', '98.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('433', '201801009', 'c006', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('434', '201801010', 'c006', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('435', '201802001', 'c001', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('436', '201802002', 'c001', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('437', '201802003', 'c001', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('438', '201802004', 'c001', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('439', '201802005', 'c001', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('440', '201802006', 'c001', '69.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('441', '201802007', 'c001', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('442', '201802008', 'c001', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('443', '201802009', 'c001', '46.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('444', '201802010', 'c001', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('445', '201802001', 'c002', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('446', '201802002', 'c002', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('447', '201802003', 'c002', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('448', '201802004', 'c002', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('449', '201802005', 'c002', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('450', '201802006', 'c002', '12.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('451', '201802007', 'c002', '15.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('452', '201802008', 'c002', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('453', '201802009', 'c002', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('454', '201802010', 'c002', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('455', '201802001', 'c003', '59.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('456', '201802002', 'c003', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('457', '201802003', 'c003', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('458', '201802004', 'c003', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('459', '201802005', 'c003', '58.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('460', '201802006', 'c003', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('461', '201802007', 'c003', '75.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('462', '201802008', 'c003', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('463', '201802009', 'c003', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('464', '201802010', 'c003', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('465', '201802001', 'c004', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('466', '201802002', 'c004', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('467', '201802003', 'c004', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('468', '201802004', 'c004', '54.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('469', '201802005', 'c004', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('470', '201802006', 'c004', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('471', '201802007', 'c004', '89.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('472', '201802008', 'c004', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('473', '201802009', 'c004', '99.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('474', '201802010', 'c004', '57.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('475', '201802001', 'c005', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('476', '201802002', 'c005', '67.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('477', '201802003', 'c005', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('478', '201802004', 'c005', '64.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('479', '201802005', 'c005', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('480', '201802006', 'c005', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('481', '201802007', 'c005', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('482', '201802008', 'c005', '36.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('483', '201802009', 'c005', '18.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('484', '201802010', 'c005', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('485', '201802001', 'c006', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('486', '201802002', 'c006', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('487', '201802003', 'c006', '73.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('488', '201802004', 'c006', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('489', '201802005', 'c006', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('490', '201802006', 'c006', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('491', '201802007', 'c006', '54.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('492', '201802008', 'c006', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('493', '201802009', 'c006', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('494', '201802010', 'c006', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('495', '201803001', 'c001', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('496', '201803002', 'c001', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('497', '201803003', 'c001', '24.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('498', '201803004', 'c001', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('499', '201803005', 'c001', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('500', '201803006', 'c001', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('501', '201803007', 'c001', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('502', '201803008', 'c001', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('503', '201803009', 'c001', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('504', '201803010', 'c001', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('505', '201803001', 'c002', '25.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('506', '201803002', 'c002', '85.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('507', '201803003', 'c002', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('508', '201803004', 'c002', '10.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('509', '201803005', 'c002', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('510', '201803006', 'c002', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('511', '201803007', 'c002', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('512', '201803008', 'c002', '18.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('513', '201803009', 'c002', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('514', '201803010', 'c002', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('515', '201803001', 'c003', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('516', '201803002', 'c003', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('517', '201803003', 'c003', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('518', '201803004', 'c003', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('519', '201803005', 'c003', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('520', '201803006', 'c003', '82.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('521', '201803007', 'c003', '99.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('522', '201803008', 'c003', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('523', '201803009', 'c003', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('524', '201803010', 'c003', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('525', '201803001', 'c004', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('526', '201803002', 'c004', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('527', '201803003', 'c004', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('528', '201803004', 'c004', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('529', '201803005', 'c004', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('530', '201803006', 'c004', '43.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('531', '201803007', 'c004', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('532', '201803008', 'c004', '68.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('533', '201803009', 'c004', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('534', '201803010', 'c004', '4.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('535', '201803001', 'c005', '95.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('536', '201803002', 'c005', '65.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('537', '201803003', 'c005', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('538', '201803004', 'c005', '7.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('539', '201803005', 'c005', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('540', '201803006', 'c005', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('541', '201803007', 'c005', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('542', '201803008', 'c005', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('543', '201803009', 'c005', '78.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('544', '201803010', 'c005', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('545', '201803001', 'c006', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('546', '201803002', 'c006', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('547', '201803003', 'c006', '98.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('548', '201803004', 'c006', '42.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('549', '201803005', 'c006', '18.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('550', '201803006', 'c006', '61.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('551', '201803007', 'c006', '53.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('552', '201803008', 'c006', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('553', '201803009', 'c006', '58.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('554', '201803010', 'c006', '38.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('555', '201601001', 'c007', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('556', '201601002', 'c007', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('557', '201601003', 'c007', '63.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('558', '201601004', 'c007', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('559', '201601005', 'c007', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('560', '201601006', 'c007', '16.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('561', '201601007', 'c007', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('562', '201601008', 'c007', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('563', '201601009', 'c007', '97.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('564', '201601010', 'c007', '30.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('565', '201602001', 'c007', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('566', '201602002', 'c007', '21.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('567', '201602003', 'c007', '20.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('568', '201602004', 'c007', '36.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('569', '201602005', 'c007', '23.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('570', '201602006', 'c007', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('571', '201602007', 'c007', '61.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('572', '201602008', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('573', '201602009', 'c007', '55.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('574', '201602010', 'c007', '14.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('575', '201603001', 'c007', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('576', '201603002', 'c007', '74.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('577', '201603003', 'c007', '62.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('578', '201603004', 'c007', '89.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('579', '201603005', 'c007', '60.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('580', '201603006', 'c007', '34.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('581', '201603007', 'c007', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('582', '201603008', 'c007', '49.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('583', '201603009', 'c007', '75.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('584', '201603010', 'c007', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('585', '201701001', 'c007', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('586', '201701002', 'c007', '86.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('587', '201701003', 'c007', '88.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('588', '201701004', 'c007', '83.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('589', '201701005', 'c007', '51.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('590', '201701006', 'c007', '8.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('591', '201701007', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('592', '201701008', 'c007', '13.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('593', '201701009', 'c007', '5.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('594', '201701010', 'c007', '84.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('595', '201702001', 'c007', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('596', '201702002', 'c007', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('597', '201702003', 'c007', '76.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('598', '201702004', 'c007', '43.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('599', '201702005', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('600', '201702006', 'c007', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('601', '201702007', 'c007', '70.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('602', '201702008', 'c007', '31.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('603', '201702009', 'c007', '48.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('604', '201702010', 'c007', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('605', '201703001', 'c007', '90.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('606', '201703002', 'c007', '11.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('607', '201703003', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('608', '201703004', 'c007', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('609', '201703005', 'c007', '39.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('610', '201703006', 'c007', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('611', '201703007', 'c007', '66.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('612', '201703008', 'c007', '40.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('613', '201703009', 'c007', '2.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('614', '201703010', 'c007', '92.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('615', '201801001', 'c007', '52.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('616', '201801002', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('617', '201801003', 'c007', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('618', '201801004', 'c007', '32.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('619', '201801005', 'c007', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('620', '201801006', 'c007', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('621', '201801007', 'c007', '6.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('622', '201801008', 'c007', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('623', '201801009', 'c007', '79.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('624', '201801010', 'c007', '37.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('625', '201802001', 'c007', '47.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('626', '201802002', 'c007', '27.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('627', '201802003', 'c007', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('628', '201802004', 'c007', '96.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('629', '201802005', 'c007', '94.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('630', '201802006', 'c007', '81.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('631', '201802007', 'c007', '26.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('632', '201802008', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('633', '201802009', 'c007', '56.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('634', '201802010', 'c007', '19.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('635', '201803001', 'c007', '29.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('636', '201803002', 'c007', '87.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('637', '201803003', 'c007', '50.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('638', '201803004', 'c007', '91.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('639', '201803005', 'c007', '3.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('640', '201803006', 'c007', '41.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('641', '201803007', 'c007', '0.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('642', '201803008', 'c007', '76.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('643', '201803009', 'c007', '80.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('644', '201803010', 'c007', '72.0', '已批改');
INSERT INTO `biz_student_score` VALUES ('645', '201601010', 'c002', '60.0', '已批改');

-- ----------------------------
-- Table structure for `biz_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `biz_teacher`;
CREATE TABLE `biz_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachno` varchar(30) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `graclass` varchar(255) NOT NULL,
  `courseno` varchar(255) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_teacher
-- ----------------------------
INSERT INTO `biz_teacher` VALUES ('1', 't0001', '郭老师', '201601', 'c001', '女', '555', 'xx', '', '2020-01-01 11:01:01');
INSERT INTO `biz_teacher` VALUES ('7', 't00055', '王老师', '201601,201602,201603', 'c001', '男', 'xxx', 'xxx', '', '2020-01-01 11:01:01');
INSERT INTO `biz_teacher` VALUES ('17', 't0009', '张老师', '201601,201602,201603', '', '女', 'xxx', 'xxx', '', '2020-01-01 11:01:01');
INSERT INTO `biz_teacher` VALUES ('20', 'test_t001', 'morty', '201603', 'c003', '男', 'xx', 'xx', '', '2020-01-01 11:01:01');
INSERT INTO `biz_teacher` VALUES ('21', 't0003', '张三', '201601,201602', 'c001', '男', '', '', null, '2020-01-01 11:01:01');
INSERT INTO `biz_teacher` VALUES ('22', '111', '111', '', '', '男', '111', '111', null, '2021-10-28 18:37:01');
INSERT INTO `biz_teacher` VALUES ('23', 't0005', '章老师', '201701,201702', 'c003', '男', '11111', '111', null, '2021-10-29 15:59:20');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `css` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', null, '/Sys/adminIndex', '/Sys/adminIndex', null, '/Sys/adminIndex');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN', '2021-07-09 10:04:35');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER', 'ROLE_USER', '2021-07-09 10:04:58');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `sys_role_id` bigint(20) NOT NULL,
  `sys_permission_id` bigint(20) NOT NULL,
  KEY `FKmnbc71b4040rgprkv4aeu0h5p` (`sys_permission_id`),
  KEY `FK31whauev046d3rg8ecubxa664` (`sys_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` varchar(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '管理员', '男', null, '2021-07-08 18:51:51');
INSERT INTO `sys_user` VALUES ('2', 'E10ADC3949BA59ABBE56E057F20F883E', 'weiz', '普通用戶', '男', null, '2021-07-08 18:51:57');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `sys_user_id` bigint(20) NOT NULL,
  `sys_role_id` bigint(20) NOT NULL,
  KEY `FK1ef5794xnbirtsnudta6p32on` (`sys_role_id`),
  KEY `FKsbjvgfdwwy5rfbiag1bwh9x2b` (`sys_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
