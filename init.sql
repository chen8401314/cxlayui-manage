/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.20-log : Database - cx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cx`;

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `zindex` int(2) DEFAULT NULL COMMENT '菜单排序',
  `istype` int(1) DEFAULT NULL COMMENT '权限分类（0 菜单；1 功能）',
  `descpt` varchar(50) DEFAULT NULL COMMENT '描述',
  `code` varchar(20) DEFAULT NULL COMMENT '菜单编号',
  `icon` varchar(30) DEFAULT NULL COMMENT '菜单图标名称',
  `page` varchar(50) DEFAULT NULL COMMENT '菜单url',
  `insert_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`pid`,`zindex`,`istype`,`descpt`,`code`,`icon`,`page`,`insert_time`,`update_time`) values (1,'系统管理',0,100,0,'系统管理','system','','/','2017-12-20 16:22:43','2018-01-09 19:26:36'),(2,'用户管理',1,1100,0,'用户管理','usermanage','','/user/userList','2017-12-20 16:27:03','2018-01-09 19:26:30'),(3,'角色管理',1,1200,0,'角色管理','rolemanage','','/auth/roleManage','2017-12-20 16:27:03','2018-01-09 19:26:42'),(4,'权限管理',1,1300,0,'权限管理','permmanage',NULL,'/auth/permList','2017-12-30 19:17:32','2018-01-09 19:26:48'),(17,'信息管理',0,200,0,'','testInfo',NULL,'/','2018-04-23 21:32:01','2018-04-23 21:33:46'),(18,'信息内容列表',17,201,0,'','testInfoList',NULL,'/testInfo/testInfoList','2018-04-23 21:32:35','2018-04-23 21:33:52');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `descpt` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `code` varchar(20) DEFAULT NULL COMMENT '角色编号',
  `insert_uid` int(11) DEFAULT NULL COMMENT '操作用户id',
  `insert_time` datetime DEFAULT NULL COMMENT '添加数据时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`,`descpt`,`code`,`insert_uid`,`insert_time`,`update_time`) values (1,'超级管理','超级管理员','superman',NULL,'2018-01-09 19:28:53','2018-04-23 21:33:33'),(2,'高级管理员','高级管理员','highmanage',NULL,'2018-01-17 13:53:23','2018-01-18 13:39:29');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `permit_id` int(5) NOT NULL AUTO_INCREMENT,
  `role_id` int(5) NOT NULL,
  PRIMARY KEY (`permit_id`,`role_id`),
  KEY `perimitid` (`permit_id`) USING BTREE,
  KEY `roleid` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `role_permission` */

insert  into `role_permission`(`permit_id`,`role_id`) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2),(4,1),(5,2),(6,2),(8,2),(10,2),(11,2),(12,2),(13,2),(14,2),(17,1),(18,1);

/*Table structure for table `test_info` */

DROP TABLE IF EXISTS `test_info`;

CREATE TABLE `test_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `test_info` */

insert  into `test_info`(`id`,`name`,`age`,`create_time`) values (1,'test1',30,'2018-04-23 21:01:23'),(3,'test1',31,'2018-04-24 01:20:42'),(4,'test1',234,'2018-04-24 01:20:42'),(5,'test1',34,'2018-04-24 01:20:42'),(6,'test1',33,'2018-04-24 01:20:42'),(7,'test1',98,'2018-04-24 01:20:42'),(8,'test1',2,'2018-04-24 01:20:42'),(9,'test1',3243,'2018-04-24 01:20:42'),(10,'test1',23,'2018-04-24 01:19:35'),(11,'test1',32,'2018-04-24 01:20:42'),(12,'test1',12,'2018-04-24 01:20:42'),(13,'test1',50,'2018-04-24 01:20:42'),(14,'test1',123,'2018-04-24 01:20:42'),(15,'test1',43,'2018-04-24 01:20:42'),(16,'test2',23,'2018-04-24 01:21:03'),(17,'test333',23,'2018-04-24 01:22:06');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `mobile` varchar(15) DEFAULT '' COMMENT '手机号',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `insert_uid` int(11) DEFAULT NULL COMMENT '添加该用户的用户id',
  `insert_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除（0：正常；1：已删）',
  `is_job` tinyint(1) DEFAULT '0' COMMENT '是否在职（0：正常；1，离职）',
  `mcode` varchar(10) DEFAULT '' COMMENT '短信验证码',
  `send_time` datetime DEFAULT NULL COMMENT '短信发送时间',
  PRIMARY KEY (`id`),
  KEY `name` (`username`) USING BTREE,
  KEY `id` (`id`) USING BTREE,
  KEY `mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`mobile`,`email`,`password`,`insert_uid`,`insert_time`,`update_time`,`is_del`,`is_job`,`mcode`,`send_time`) values (1,'admin','12345678901','aaa','c33367701511b4f6020ec61ded352059',NULL,'2017-12-29 17:27:23','2018-04-23 20:47:43',0,0,'181907','2018-01-17 13:42:45');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(5) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `userid` (`user_id`) USING BTREE,
  KEY `roleid` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
