-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: java
-- ------------------------------------------------------
-- Server version	5.5.5-10.8.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hptl_mast`
--

DROP TABLE IF EXISTS `hptl_mast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hptl_mast` (
  `SECU_KEY_CD` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `HPTL_NM` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `TYP_CD` varchar(2) CHARACTER SET latin1 DEFAULT NULL,
  `TYP_CD_NM` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `SIDO_CD` varchar(6) CHARACTER SET latin1 DEFAULT NULL,
  `SIDO_CD_NM` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `SIGGU_CD` varchar(6) CHARACTER SET latin1 DEFAULT NULL,
  `SIGGU_CD_NM` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `EMD` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `POST_CD` varchar(6) CHARACTER SET latin1 DEFAULT NULL,
  `ADDR` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  `TEL_NO` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `HPTL_URL` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `OPEN_DATE` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `DOC_NUM` int(11) DEFAULT NULL,
  `DOC_GNRL_NUM` int(11) DEFAULT NULL,
  `DOC_INT_NUM` int(11) DEFAULT NULL,
  `DOC_RESI_NUM` int(11) DEFAULT NULL,
  `DOC_SP_NUM` int(11) DEFAULT NULL,
  `DENT_GNRL_NUM` int(11) DEFAULT NULL,
  `DENT_INT_NUM` int(11) DEFAULT NULL,
  `DENT_RESI_NUM` int(11) DEFAULT NULL,
  `DENT_SP_NUM` int(11) DEFAULT NULL,
  `EAST_GNRL_NUM` int(11) DEFAULT NULL,
  `EAST_INT_NUM` int(11) DEFAULT NULL,
  `EAST_RESI_NUM` int(11) DEFAULT NULL,
  `EAST_SP_NUM` int(11) DEFAULT NULL,
  `X_LOC` float(10,3) DEFAULT NULL,
  `Y_lOC` float(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hptl_mast`
--

LOCK TABLES `hptl_mast` WRITE;
/*!40000 ALTER TABLE `hptl_mast` DISABLE KEYS */;
/*!40000 ALTER TABLE `hptl_mast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `member` (
  `Idx` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Id` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `name` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `pw` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`Idx`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'hong12345','honggildong','1234'),(2,'a','I_AM_A','top_secret'),(3,'hi','hello','secret');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie` (
  `movie_name` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `open_date` varchar(8) CHARACTER SET latin1 DEFAULT NULL,
  `rating` int(2) DEFAULT NULL,
  `genre` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `country` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `play_time` int(3) DEFAULT NULL,
  `provider` varchar(50) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('venom2','20211013',15,'action','US',97,'sonyPictures'),('inseption','20100721',12,'action','US',147,'thistation'),('007Die',NULL,NULL,'melo','korea',NULL,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_mast`
--

DROP TABLE IF EXISTS `movie_mast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie_mast` (
  `movie_name` varchar(100) CHARACTER SET latin1 NOT NULL,
  `open_date` varchar(8) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`movie_name`),
  UNIQUE KEY `open_date` (`open_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_mast`
--

LOCK TABLES `movie_mast` WRITE;
/*!40000 ALTER TABLE `movie_mast` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_mast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'java'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-20 15:45:04
