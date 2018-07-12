/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.51 : Database - mybatisdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisdemo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mybatisdemo`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `cnumber` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `card` */

insert  into `card`(`uid`,`cnumber`) values (1,'1'),(2,'2'),(3,'3'),(4,'123'),(5,'afsd');

/*Table structure for table `citys` */

DROP TABLE IF EXISTS `citys`;

CREATE TABLE `citys` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `cname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `citys` */

insert  into `citys`(`cid`,`pid`,`cname`) values (1,1,'湛江'),(2,2,'海口'),(3,1,'中山'),(4,1,'广州'),(5,2,'三亚'),(6,1,'深圳');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `tutorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `tutorId` (`tutorId`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`tutorId`) REFERENCES `tutor` (`tutorId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseId`,`cname`,`description`,`startDate`,`endDate`,`tutorId`) values (1,'数学','数学','2018-07-12 16:22:07','2018-07-12 16:22:03',1),(2,'语文','语文','2018-07-12 16:22:11','2018-07-12 16:22:02',2),(3,'英语','英语','2018-07-12 16:22:13','2018-07-12 16:21:59',2),(4,'地理','地理','2018-07-12 16:22:11','2018-07-12 16:22:11',2);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`pid`,`pname`,`page`) values (1,'zhangsan',4),(2,'lisi',6),(3,'wangwu',3),(4,'tianqi',7);

/*Table structure for table `provinces` */

DROP TABLE IF EXISTS `provinces`;

CREATE TABLE `provinces` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `provinces` */

insert  into `provinces`(`pid`,`pname`) values (1,'广东'),(2,'海南');

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`rid`,`rname`) values (1,'shouli'),(2,'bing');

/*Table structure for table `tutor` */

DROP TABLE IF EXISTS `tutor`;

CREATE TABLE `tutor` (
  `tutorId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  PRIMARY KEY (`tutorId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tutor` */

insert  into `tutor`(`tutorId`,`name`,`email`,`address`) values (1,'王老师','1',1),(2,'李老师','2',2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`) values (1,'张三'),(2,'李四');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
