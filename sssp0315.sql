/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.51 : Database - sssp0315
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sssp0315` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `sssp0315`;

/*Table structure for table `sssp_departments` */

DROP TABLE IF EXISTS `sssp_departments`;

CREATE TABLE `sssp_departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

/*Data for the table `sssp_departments` */

insert  into `sssp_departments`(`id`,`department_name`) values (1,'市场部'),(2,'销售部'),(3,'会计部'),(4,'卫生部'),(5,'研发部');

/*Table structure for table `sssp_employees` */

DROP TABLE IF EXISTS `sssp_employees`;

CREATE TABLE `sssp_employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1by80iowxwcoway8hwu8aytt8` (`department_id`),
  CONSTRAINT `FK_1by80iowxwcoway8hwu8aytt8` FOREIGN KEY (`department_id`) REFERENCES `sssp_departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

/*Data for the table `sssp_employees` */

insert  into `sssp_employees`(`id`,`last_name`,`email`,`birth`,`create_time`,`department_id`) values (1,'张三','zhangsan@163.com','2000-02-12','2018-09-28 15:09:55',1),(2,'李四','lisi@163.com','2008-09-20','2018-09-28 15:33:01',4),(3,'王五','wangwu@163.com','1990-09-20','2018-09-29 12:53:24',5),(4,'赵六','zhaoliu@163.com','1990-09-11','2018-09-29 12:55:50',2),(5,'钱七','qianqi@163.com','1990-09-10','2018-09-29 12:56:44',3),(6,'孙八','sunba@163.com','1990-09-10','2018-09-29 12:57:16',5),(7,'李九','lijiu@163.com','1990-09-10','2018-09-29 12:57:56',5),(8,'周十','zhoushi@163.com','1990-09-10','2018-09-29 12:57:56',5),(9,'吴十一','wushiyi@163.com','1990-09-10','2018-09-29 12:57:56',5),(10,'郑十二','zhengshier@163.com','1990-09-10','2018-09-29 12:57:56',5),(11,'刘十三','liushisan@163.com','1990-09-14','2018-09-29 13:01:02',5),(12,'陈十四','chenshisi@163.com','1990-09-10','2018-09-29 13:01:41',5);

/*Table structure for table `t_persons` */

DROP TABLE IF EXISTS `t_persons`;

CREATE TABLE `t_persons` (
  `id` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_au9theha6idyn0eau45afxli9` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `t_persons` */

insert  into `t_persons`(`id`,`birthday`,`email`,`last_name`) values ('4028aaf76623ab64016623abfeed0000','1999-09-11','wangwu@163.com','王五'),('ff808081662025d5016620262b600000','1999-09-23','zhangsan@163.com','张三'),('ff808081662025d5016620277e230002','1999-09-12','lisi@163.com','李四');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `password` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `email` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_date` time DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`,`telephone`,`birthday`,`create_date`,`last_modified`) values (23,'王五_0','1234560','0wangwu@163.com','13724562360','1990-09-30','10:40:36','2018-09-28 10:40:36'),(24,'王五_1','1234561','1wangwu@163.com','13724562361','1990-09-30','10:40:36','2018-09-28 10:40:36'),(25,'王五_2','1234562','2wangwu@163.com','13724562362','1990-09-30','10:40:36','2018-09-28 10:40:36'),(26,'王五_3','1234563','3wangwu@163.com','13724562363','1990-09-30','10:40:36','2018-09-28 10:40:36'),(27,'王五_4','1234564','4wangwu@163.com','13724562364','1990-09-30','10:40:36','2018-09-28 10:40:36'),(28,'王五_5','1234565','5wangwu@163.com','13724562365','1990-09-30','10:40:36','2018-09-28 10:40:36'),(29,'王五_6','1234566','6wangwu@163.com','13724562366','1990-09-30','10:40:36','2018-09-28 10:40:36'),(30,'王五_7','1234567','7wangwu@163.com','13724562367','1990-09-30','10:40:36','2018-09-28 10:40:36'),(31,'王五_8','1234568','8wangwu@163.com','13724562368','1990-09-30','10:40:36','2018-09-28 10:40:36'),(32,'王五_9','1234569','9wangwu@163.com','13724562369','1990-09-30','10:40:36','2018-09-28 10:40:36'),(33,'王五_10','12345610','10wangwu@163.com','137245623610','1990-09-30','10:40:36','2018-09-28 10:40:36'),(34,'王五_11','12345611','11wangwu@163.com','137245623611','1990-09-30','10:40:36','2018-09-28 10:40:36'),(35,'王五_12','12345612','12wangwu@163.com','137245623612','1990-09-30','10:40:36','2018-09-28 10:40:36'),(36,'王五_13','12345613','13wangwu@163.com','137245623613','1990-09-30','10:40:36','2018-09-28 10:40:36'),(37,'王五_14','12345614','14wangwu@163.com','137245623614','1990-09-30','10:40:36','2018-09-28 10:40:36'),(38,'王五_15','12345615','15wangwu@163.com','137245623615','1990-09-30','10:40:36','2018-09-28 10:40:36'),(39,'王五_16','12345616','16wangwu@163.com','137245623616','1990-09-30','10:40:36','2018-09-28 10:40:36'),(40,'王五_17','12345617','17wangwu@163.com','137245623617','1990-09-30','10:40:36','2018-09-28 10:40:36'),(41,'王五_18','12345618','18wangwu@163.com','137245623618','1990-09-30','10:40:36','2018-09-28 10:40:36'),(42,'王五_19','12345619','19wangwu@163.com','137245623619','1990-09-30','10:40:36','2018-09-28 10:40:36'),(43,'王五_20','12345620','20wangwu@163.com','137245623620','1990-09-30','11:00:16','2018-09-28 11:00:16'),(44,'王五_21','12345621','21wangwu@163.com','137245623621','1990-09-30','11:00:16','2018-09-28 11:00:16'),(45,'王五_22','12345622','22wangwu@163.com','137245623622','1990-09-30','11:00:16','2018-09-28 11:00:16'),(46,'王五_23','12345623','23wangwu@163.com','137245623623','1990-09-30','11:00:16','2018-09-28 11:00:16'),(47,'王五_24','12345624','24wangwu@163.com','137245623624','1990-09-30','11:00:16','2018-09-28 11:00:16'),(48,'王五_25','12345625','25wangwu@163.com','137245623625','1990-09-30','11:00:16','2018-09-28 11:00:16'),(49,'王五_26','12345626','26wangwu@163.com','137245623626','1990-09-30','11:00:16','2018-09-28 11:00:16'),(50,'王五_27','12345627','27wangwu@163.com','137245623627','1990-09-30','11:00:16','2018-09-28 11:00:16'),(51,'王五_28','12345628','28wangwu@163.com','137245623628','1990-09-30','11:00:16','2018-09-28 11:00:16'),(52,'王五_29','12345629','29wangwu@163.com','137245623629','1990-09-30','11:00:16','2018-09-28 11:00:16'),(53,'王五_30','12345630','30wangwu@163.com','137245623630','1990-09-30','11:00:16','2018-09-28 11:00:16'),(54,'王五_31','12345631','31wangwu@163.com','137245623631','1990-09-30','11:00:16','2018-09-28 11:00:16'),(55,'王五_32','12345632','32wangwu@163.com','137245623632','1990-09-30','11:00:16','2018-09-28 11:00:16'),(56,'李四','12345633','33wangwu@163.com','137245623633','1990-09-30','11:00:16','2018-09-28 11:00:16'),(57,'王五_34','12345634','34wangwu@163.com','137245623634','1990-09-30','11:00:16','2018-09-28 11:00:16'),(58,'王五_35','12345635','35wangwu@163.com','137245623635','1990-09-30','11:00:16','2018-09-28 11:00:16'),(59,'王五_36','12345636','36wangwu@163.com','137245623636','1990-09-30','11:00:16','2018-09-28 11:00:16'),(60,'王五_37','12345637','37wangwu@163.com','137245623637','1990-09-30','11:00:16','2018-09-28 11:00:16'),(61,'王五_38','12345638','38wangwu@163.com','137245623638','1990-09-30','11:00:16','2018-09-28 11:00:16'),(62,'王五_39','12345639','39wangwu@163.com','137245623639','1990-09-30','11:00:16','2018-09-28 11:00:16'),(65,'王五_20','12345620','20wangwu@163.com','137245623620','1990-09-30','13:07:47','2018-09-28 13:07:47'),(66,'王五_21','12345621','21wangwu@163.com','137245623621','1990-09-30','13:07:47','2018-09-28 13:07:47'),(67,'王五_22','12345622','22wangwu@163.com','137245623622','1990-09-30','13:07:47','2018-09-28 13:07:47'),(68,'王五_23','12345623','23wangwu@163.com','137245623623','1990-09-30','13:07:47','2018-09-28 13:07:47'),(69,'王五_24','12345624','24wangwu@163.com','137245623624','1990-09-30','13:07:47','2018-09-28 13:07:47'),(70,'王五_25','12345625','25wangwu@163.com','137245623625','1990-09-30','13:07:47','2018-09-28 13:07:47'),(71,'王五_26','12345626','26wangwu@163.com','137245623626','1990-09-30','13:07:47','2018-09-28 13:07:47'),(72,'王五_27','12345627','27wangwu@163.com','137245623627','1990-09-30','13:07:47','2018-09-28 13:07:47'),(73,'王五_28','12345628','28wangwu@163.com','137245623628','1990-09-30','13:07:47','2018-09-28 13:07:47'),(74,'王五_29','12345629','29wangwu@163.com','137245623629','1990-09-30','13:07:47','2018-09-28 13:07:47'),(75,'王五_30','12345630','30wangwu@163.com','137245623630','1990-09-30','13:07:47','2018-09-28 13:07:47'),(76,'王五_31','12345631','31wangwu@163.com','137245623631','1990-09-30','13:07:47','2018-09-28 13:07:47'),(77,'王五_32','12345632','32wangwu@163.com','137245623632','1990-09-30','13:07:47','2018-09-28 13:07:47'),(78,'王五_33','12345633','33wangwu@163.com','137245623633','1990-09-30','13:07:47','2018-09-28 13:07:47'),(79,'王五_34','12345634','34wangwu@163.com','137245623634','1990-09-30','13:07:47','2018-09-28 13:07:47'),(80,'王五_35','12345635','35wangwu@163.com','137245623635','1990-09-30','13:07:47','2018-09-28 13:07:47'),(81,'王五_36','12345636','36wangwu@163.com','137245623636','1990-09-30','13:07:47','2018-09-28 13:07:47'),(82,'王五_37','12345637','37wangwu@163.com','137245623637','1990-09-30','13:07:47','2018-09-28 13:07:47'),(83,'王五_38','12345638','38wangwu@163.com','137245623638','1990-09-30','13:07:47','2018-09-28 13:07:47'),(84,'王五_39','12345639','39wangwu@163.com','137245623639','1990-09-30','13:07:47','2018-09-28 13:07:47');

/*Table structure for table `test01` */

DROP TABLE IF EXISTS `test01`;

CREATE TABLE `test01` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=gbk;

/*Data for the table `test01` */

insert  into `test01`(`id`,`tel`,`birth`,`password`) values (123,'13724562360','2018-10-01','1234560'),(124,'13724562361','2018-10-01','1234561'),(125,'13724562362','2018-10-01','1234562'),(126,'13724562363','2018-10-01','1234563'),(127,'13724562364','2018-10-01','1234564'),(128,'13724562365','2018-10-01','1234565'),(129,'13724562366','2018-10-01','1234566'),(130,'13724562367','2018-10-01','1234567'),(131,'13724562368','2018-10-01','1234568'),(132,'13724562369','2018-10-01','1234569'),(133,'137245623610','2018-10-01','12345610'),(134,'137245623611','2018-10-01','12345611'),(135,'137245623612','2018-10-01','12345612'),(136,'137245623613','2018-10-01','12345613'),(137,'137245623614','2018-10-01','12345614'),(138,'137245623615','2018-10-01','12345615'),(139,'137245623616','2018-10-01','12345616'),(140,'137245623617','2018-10-01','12345617'),(141,'137245623618','2018-10-01','12345618'),(142,'137245623619','2018-10-01','12345619'),(143,'137245623620','2018-10-01','12345620'),(144,'137245623621','2018-10-01','12345621'),(145,'137245623622','2018-10-01','12345622'),(146,'137245623623','2018-10-01','12345623'),(147,'137245623624','2018-10-01','12345624'),(148,'137245623625','2018-10-01','12345625'),(149,'137245623626','2018-10-01','12345626'),(150,'137245623627','2018-10-01','12345627'),(151,'137245623628','2018-10-01','12345628'),(152,'137245623629','2018-10-01','12345629'),(153,'137245623630','2018-10-01','12345630'),(154,'137245623631','2018-10-01','12345631'),(155,'137245623632','2018-10-01','12345632'),(156,'137245623633','2018-10-01','12345633'),(157,'137245623634','2018-10-01','12345634'),(158,'137245623635','2018-10-01','12345635'),(159,'137245623636','2018-10-01','12345636'),(160,'137245623637','2018-10-01','12345637'),(161,'137245623638','2018-10-01','12345638'),(162,'137245623639','2018-10-01','12345639'),(163,'137245623620','2018-10-01','12345620'),(164,'137245623621','2018-10-01','12345621'),(165,'137245623622','2018-10-01','12345622'),(166,'137245623623','2018-10-01','12345623'),(167,'137245623624','2018-10-01','12345624'),(168,'137245623625','2018-10-01','12345625'),(169,'137245623626','2018-10-01','12345626'),(170,'137245623627','2018-10-01','12345627'),(171,'137245623628','2018-10-01','12345628'),(172,'137245623629','2018-10-01','12345629'),(173,'137245623630','2018-10-01','12345630'),(174,'137245623631','2018-10-01','12345631'),(175,'137245623632','2018-10-01','12345632'),(176,'137245623633','2018-10-01','12345633'),(177,'137245623634','2018-10-01','12345634'),(178,'137245623635','2018-10-01','12345635'),(179,'137245623636','2018-10-01','12345636'),(180,'137245623637','2018-10-01','12345637'),(181,'137245623638','2018-10-01','12345638'),(182,'137245623639','2018-10-01','12345639'),(183,'137245623639','2018-10-01','12345639');

/* Procedure structure for procedure `check_drain` */

/*!50003 DROP PROCEDURE IF EXISTS  `check_drain` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `check_drain`()
BEGIN
DECLARE done BOOLEAN;
DECLARE str1 VARCHAR(50);
DECLARE str2 VARCHAR(50);
DECLARE drain_cursor CURSOR
FOR 
	SELECT c.id, o.order_date
	FROM customers c
	JOIN (SELECT customer_id, MAX(order_date) order_date
		FROM orders
		GROUP BY customer_id) o
	ON c.id = o.customer_id
	WHERE o.order_date < DATE_ADD(NOW(),INTERVAL -6 MONTH)
	AND c.state = '正常';
DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;
OPEN drain_cursor;
REPEAT
FETCH drain_cursor INTO str1,str2;
	INSERT INTO customer_drains(id, customer_id, last_order_date, status) 
	VALUES(NULL, str1, str2, '流失预警');
	UPDATE customers SET state = '流失预警' WHERE id = str1;
UNTIL done END REPEAT;
CLOSE drain_cursor;
END */$$
DELIMITER ;

/* Procedure structure for procedure `ip_analyse` */

/*!50003 DROP PROCEDURE IF EXISTS  `ip_analyse` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `ip_analyse`()
BEGIN
DECLARE done BOOLEAN;
DECLARE str1 VARCHAR(50);
DECLARE str2 VARCHAR(50);
DECLARE cur1 CURSOR
FOR 
SELECT t.telephone,t.password
FROM t_user t; /*定义游标；必须定义在变量之后！*/
DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1; /*定义句柄。continue设定循环退出条件。*/
/*当sqlstate为’02000‘时，设置done的值为1,02000是指一个没有找到的错误码*/
/*sqlstate是mysql的规定。表示找到最后无数据时，mysql报出的状态码！！*/
OPEN cur1; /*打开游标*/
REPEAT /*循环开始*/
FETCH cur1 INTO str1,str2; /*获取一行一列的数据*/
INSERT INTO test01 VALUES(null,str1,NOW(),str2);
UNTIL done END REPEAT; /*类似于java中的do...while循环*/
CLOSE cur1 ; /*关闭游标*/
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;