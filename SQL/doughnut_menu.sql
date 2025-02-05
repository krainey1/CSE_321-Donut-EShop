-- MySQL dump 10.13  Distrib 9.0.1, for macos14.7 (arm64)
--
-- Host: localhost    Database: donutdb
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doughnut_menu`
--

DROP TABLE IF EXISTS `doughnut_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doughnut_menu` (
  `ProductKey` int NOT NULL,
  `Doughnut` text,
  `Type` text,
  `Price` double DEFAULT NULL,
  `pageinfo` text,
  PRIMARY KEY (`ProductKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doughnut_menu`
--

LOCK TABLES `doughnut_menu` WRITE;
/*!40000 ALTER TABLE `doughnut_menu` DISABLE KEYS */;
INSERT INTO `doughnut_menu` VALUES (1,'Raised','Glazed',5,'it\'s basic but it still tastes good'),(2,'Raised','Sugar',5,'good luck getting the sugar of your hands'),(3,'Raised','Chocolate',5,'perfect for eating with your morning coffee'),(4,'Cake','Plain',7,'Our Plain Cake Donut (It\'s quite good)'),(5,'Cake','Chocolate',7,'Our Chocolate Cake Donut - For the chocolate cake lovers'),(6,'Cake','Sugar',7,'Our Cake Donut covered in sugar - what\'s not to love?'),(7,'Filled','Lemon',8,'Lemon filled doughnut - a perfect tart blend.'),(8,'Filled','Grape',8,'If you love grapes, you\'ll love our amazing jelly grape filled donut.'),(9,'Filled','Custard',8,'Enjoy a tasty doughnut with our homemade custard. So good it\'s been a family recipe for centuries.');
/*!40000 ALTER TABLE `doughnut_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13 11:36:21
