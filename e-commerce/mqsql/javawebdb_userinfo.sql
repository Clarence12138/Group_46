-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: javawebdb
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `userinfoid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `password` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `profession` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `favor` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `description` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`userinfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'xqb','12345','男','后端','写作','呜呜呜'),(2,'Clarence','111','男','后端','写作','perfect'),(3,'Tom','123','男','经理','写作','good'),(4,'2021212917','111','男','测试','音乐','请输入'),(5,'202121292217','123123','男','测试','音乐','请输入'),(6,'拉亚斯特','111','男','前端','绘画','不是我最想要的，不过，也行'),(7,'Tom','111','男','前端','绘画','不是我最想要的，不过，也行'),(8,'Tom','111','男','前端','绘画','不是我最想要的，不过，也行'),(9,'1213','1111','男','测试','音乐','请输入'),(10,'2021212917','sss','女','测试','音乐','请输入'),(11,'2021212917','sss','女','测试','音乐','请输入'),(12,'121','sss','女','测试','音乐','请输入'),(13,'Lihua','111222','男','前端','写作','喜欢写英语作文'),(14,'shuai','123','男','经理','绘画','帅帅帅');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30  1:13:12
