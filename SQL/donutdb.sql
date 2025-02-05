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
  `Doughnut` enum('Raised','Cake','Filled') DEFAULT NULL,
  `Type` enum('Chocolate','Glazed','Plain','Sugar','Lemon','Grape','Custard') DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `pageinfo` text,
  `AvailableQuantity` int DEFAULT '20',
  PRIMARY KEY (`ProductKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doughnut_menu`
--

LOCK TABLES `doughnut_menu` WRITE;
/*!40000 ALTER TABLE `doughnut_menu` DISABLE KEYS */;
INSERT INTO `doughnut_menu` VALUES (1,'Raised','Glazed',5,'it\'s basic but it still tastes good',15),(2,'Raised','Sugar',6,'good luck getting the sugar of your hands',17),(3,'Raised','Chocolate',5,'perfect for eating with your morning coffee',20),(4,'Cake','Plain',7,'Our Plain Cake Donut (It\'s quite good)',18),(5,'Cake','Chocolate',7,'Our Chocolate Cake Donut - For the chocolate cake lovers',18),(6,'Cake','Sugar',7,'Our Cake Donut covered in sugar - what\'s not to love?',20),(7,'Filled','Lemon',8,'Lemon filled doughnut - a perfect tart blend.',19),(8,'Filled','Grape',8,'If you love grapes, you\'ll love our amazing jelly grape filled donut.',20),(9,'Filled','Custard',8,'Enjoy a tasty doughnut with our homemade custard. So good it\'s been a family recipe for centuries.',20);
/*!40000 ALTER TABLE `doughnut_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doughnut_orders`
--

DROP TABLE IF EXISTS `doughnut_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doughnut_orders` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CardNumber` varchar(255) DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `Timestamp` date DEFAULT NULL,
  `Status` enum('Open','Closed') DEFAULT NULL,
  `TransactionLog` text,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doughnut_orders`
--

LOCK TABLES `doughnut_orders` WRITE;
/*!40000 ALTER TABLE `doughnut_orders` DISABLE KEYS */;
INSERT INTO `doughnut_orders` VALUES (1,'Billy Joel','13131414114',20,'2024-11-17','Open','1 Donut(s) of type Raised with a flavor of Sugar for 6.00,2 Donut(s) of type Cake with a flavor of Chocolate for 14.00'),(2,'Joanne Jonna','13131414114',12,'2024-11-17','Open','1 Donut(s) of type Raised with a flavor of Glazed for 5.00,1 Donut(s) of type Cake with a flavor of Plain for 7.00'),(3,'Joanne Jonna','13131414114',0,'2024-11-17','Closed',''),(4,'Joanne Jonna','13131414114',15,'2024-11-17','Open','1 Donut(s) of type Cake with a flavor of Chocolate for 7.00,1 Donut(s) of type Filled with a flavor of Lemon for 8.00'),(5,'Oden Odis','13131414114',13,'2024-11-17','Open','1 Donut(s) of type Raised with a flavor of Sugar for 6.00,1 Donut(s) of type Cake with a flavor of Plain for 7.00'),(6,'Oden Odis','1414141414',11,'2024-11-17','Open','1 Donut(s) of type Raised with a flavor of Sugar for 6.00,1 Donut(s) of type Raised with a flavor of Glazed for 5.00');
/*!40000 ALTER TABLE `doughnut_orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-17 21:41:32
