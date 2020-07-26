SET NAMES utf8 ;
/*DROP DATABASE IF EXISTS `test`;

CREATE DATABASE `test`;*/

USE `test`;

DROP TABLE IF EXISTS `Country`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `name_idx` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;*/
