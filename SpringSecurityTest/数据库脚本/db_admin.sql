/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.18-log : Database - db_admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_admin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_admin`;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `order_num` int(11) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`icon`,`parent_id`,`order_num`,`path`,`component`,`menu_type`,`perms`,`create_time`,`update_time`,`remark`) values (1,'系统管理','system',0,1,'/sys','','M','','2022-07-04 14:56:29','2022-07-04 14:56:31','系统管理目录'),(2,'业务管理','monitor',0,2,'/bsns','','M','','2022-07-04 14:59:43','2022-07-04 14:59:45','业务管理目录'),(3,'用户管理','user',1,1,'/sys/user','sys/user/index','C','system:user:list','2022-07-04 15:20:51','2022-07-04 15:20:53','用户管理菜单'),(4,'角色管理','peoples',1,2,'/sys/role','sys/role/index','C','system:role:list','2022-07-04 15:23:35','2022-07-04 15:23:39','角色管理菜单'),(5,'菜单管理','tree-table',1,3,'/sys/menu','sys/menu/index','C','system:menu:list','2022-07-04 15:23:41','2022-07-04 15:23:43','菜单管理菜单'),(6,'部门管理','tree',2,1,'/bsns/department','bsns/Department','C','','2022-07-04 15:24:40','2022-07-04 15:24:44','部门管理菜单'),(7,'岗位管理','post',2,2,'/bsns/post','bsns/Post','C','','2022-07-04 15:24:42','2022-07-04 15:24:46','岗位管理菜单'),(8,'用户新增','#',3,2,'','','F','system:user:add','2022-07-04 15:24:42','2022-07-04 15:24:46','添加用户按钮'),(9,'用户修改','#',3,3,'','','F','system:user:edit','2022-07-04 15:24:42','2022-07-04 15:24:46','修改用户按钮'),(10,'用户删除','#',3,4,'','','F','system:user:delete','2022-07-04 15:24:42','2022-07-04 15:24:46','删除用户按钮'),(11,'分配角色','#',3,5,'','','F','system:user:role','2022-07-04 15:24:42','2022-07-04 15:24:46','分配角色按钮'),(12,'重置密码','#',3,6,'','','F','system:user:resetPwd','2022-07-04 15:24:42','2022-07-04 15:24:46','重置密码按钮'),(13,'角色新增','#',4,2,'','','F','system:role:add','2022-07-04 15:24:42','2022-07-04 15:24:46','添加用户按钮'),(14,'角色修改','#',4,3,'','','F','system:role:edit','2022-07-04 15:24:42','2022-07-04 15:24:46','修改用户按钮'),(15,'角色删除','#',4,4,'',NULL,'F','system:role:delete','2022-07-04 15:24:42','2022-07-04 15:24:46','删除用户按钮'),(16,'分配权限','#',4,5,'','','F','system:role:menu','2022-07-04 15:24:42','2022-07-04 15:24:46','分配权限按钮'),(17,'菜单新增','#',5,2,'',NULL,'F','system:menu:add','2022-07-04 15:24:42','2022-07-04 15:24:46','添加菜单按钮'),(18,'菜单修改','#',5,3,'',NULL,'F','system:menu:edit','2022-07-04 15:24:42','2022-07-04 15:24:46','修改菜单按钮'),(19,'菜单删除','#',5,4,'',NULL,'F','system:menu:delete','2022-07-04 15:24:42','2022-07-04 15:24:46','删除菜单按钮'),(20,'用户查询','#',3,1,'',NULL,'F','system:user:query','2022-07-04 15:24:42','2022-07-04 15:24:46','用户查询按钮'),(21,'角色查询','#',4,1,'',NULL,'F','system:role:query','2022-07-04 15:24:42','2022-07-04 15:24:46','角色查询按钮'),(22,'菜单查询','#',5,1,'',NULL,'F','system:menu:query','2022-07-04 15:24:42','2022-07-04 15:24:46','菜单查询按钮'),(33,'测速22','122',3,3,'','34','M','33','2022-08-19 03:11:20','2022-08-18 19:11:33',NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`code`,`create_time`,`update_time`,`remark`) values (1,'超级管理员','admin','2022-07-04 14:40:44','2022-07-04 14:40:47','拥有系统最高权限'),(2,'普通角色','common','2022-07-04 14:41:56','2022-07-04 14:41:58','普通角色'),(3,'测试角色','test','2022-07-04 14:42:24','2022-07-04 14:42:27','测试角色'),(4,'2',NULL,NULL,NULL,NULL),(5,'3',NULL,NULL,NULL,NULL),(6,'4',NULL,NULL,NULL,NULL),(7,'5',NULL,NULL,NULL,NULL),(14,'6',NULL,NULL,NULL,NULL),(16,'8',NULL,NULL,NULL,NULL),(17,'0',NULL,NULL,NULL,NULL),(19,'测2','cc2','2022-08-13 21:06:21','2022-08-13 13:06:27','eewew2'),(20,'ccc测试','test2','2022-08-29 17:10:33',NULL,'xxx'),(21,'今天测试角色','todytest','2022-08-29 22:01:11',NULL,'ccc');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色菜单主键ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=239 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (8,2,1),(9,2,2),(10,2,3),(11,2,4),(12,2,5),(13,2,6),(14,2,7),(15,3,2),(16,3,6),(17,3,7),(21,7,1),(22,7,2),(23,7,6),(24,7,7),(25,6,1),(26,6,3),(27,6,9),(28,6,10),(29,19,1),(30,19,3),(31,19,2),(32,19,6),(33,1,1),(34,1,3),(35,1,20),(36,1,8),(37,1,9),(38,1,10),(39,1,11),(40,1,12),(41,1,4),(42,1,21),(43,1,13),(44,1,14),(45,1,15),(46,1,16),(47,1,23),(48,1,5),(49,1,22),(50,1,17),(51,1,18),(52,1,19),(53,1,2),(54,1,6),(55,1,7),(208,20,1),(209,20,3),(210,20,20),(211,20,8),(212,20,9),(213,20,33),(214,20,10),(215,20,11),(216,20,4),(217,20,21),(218,20,13),(219,20,5),(220,20,22),(221,20,17),(222,20,18),(223,20,2),(224,20,6),(225,20,7),(232,21,1),(233,21,9),(234,21,4),(235,21,21),(236,21,2),(237,21,6),(238,21,7);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT 'default.jpg' COMMENT '用户头像',
  `email` varchar(100) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`avatar`,`email`,`phonenumber`,`login_date`,`status`,`create_time`,`update_time`,`remark`) values (1,'java1234','$2a$10$Kib4zuVhTzg3I1CoqJfd0unuY9G9ysI7cfbhyT3fi7k7Z/4pr3bGW','20220727112556000000325.jpg','caofeng4017@126.com','18862857417','2022-08-29 22:10:52','0','2022-06-09 08:47:52','2022-06-22 08:47:54','备注'),(2,'common','$2a$10$tiArwm0GxChyEP5k0JGzsOuzyY15IKA.ZTl8S2aj3haYlKAfpwfl.','222.jpg','','','2022-08-22 21:34:39','0',NULL,NULL,NULL),(3,'test','$2a$10$tiArwm0GxChyEP5k0JGzsOuzyY15IKA.ZTl8S2aj3haYlKAfpwfl.','333.jpg','','','2022-07-24 17:36:07','0',NULL,NULL,NULL),(4,'1','$2a$10$lD0Fx7oMsFFmX9hVkmYy7eJteH8pBaXXro1X9DEMP5sbM.Z6Co55m','default.jpg','','',NULL,'1',NULL,NULL,NULL),(5,'2',NULL,'default.jpg','','',NULL,'1',NULL,NULL,NULL),(15,'fdsfs','$2a$10$AQVcp4hQ7REc5o7ztVnI7eX.sJdcYy3d1x2jm5CfrcCoMZMPacfpi','default.jpg','fdfa4@qq.com','18862851414','2022-08-02 02:22:45','1','2022-08-02 02:21:24','2022-08-01 18:23:16','fdfds4'),(28,'sdfss2','$2a$10$7aNJxwVmefI0XAk64vrzYuOqeeImYJUQnoBrtKP9pLTGTWO2CXQ/y','default.jpg','dfds3@qq.com','18862857413',NULL,'1','2022-08-07 00:42:46','2022-08-06 16:43:04','ddd33'),(29,'ccc','$2a$10$7cbWeVwDWO9Hh3qbJrvTHOn0E/DLYXxnIZpxZei0jY4ChfQbJuhi.','20220829080150000000341.jpg','3242@qq.com','18862584120','2022-08-29 19:52:27','0','2022-08-29 17:04:58',NULL,'xxx'),(30,'ccc666','$2a$10$Tmw5VCM/K2vb837AZDYHQOqE3gPiRZKevxLsh/ozndpTSjdwABqaK','20220829100454000000771.jpg','fdafds@qq.com','18865259845','2022-08-29 22:05:18','0','2022-08-29 22:00:39',NULL,'ccc');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,2,2),(4,1,2),(6,3,3),(7,3,2),(9,4,3),(10,5,3),(11,15,3),(16,28,2),(17,28,3),(20,29,20),(21,30,17),(22,30,21);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
