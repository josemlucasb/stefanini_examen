-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbprueba
-- ------------------------------------------------------
-- Server version	5.5.56-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banco` (
  `id_banco` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_banco`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` VALUES (1,'banco1','direc1','2020-12-20 01:34:41'),(3,'JOSE MANUEL','direc2','2020-12-20 02:49:12'),(4,'JOSE MANUEL','direc2','2020-12-20 02:58:55'),(5,'JOSE MANUEL','direc2','2020-12-20 03:00:44'),(6,'JOSE MANUEL','direc2','2020-12-20 03:03:15'),(7,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(8,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(9,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(10,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(11,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(12,'JOSE MANUEL','direc2','2020-06-20 15:10:04'),(13,'JOSE MANUEL','direc2','2020-06-20 15:10:04');
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenpago`
--

DROP TABLE IF EXISTS `ordenpago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenpago` (
  `id_ordenpago` int(11) NOT NULL AUTO_INCREMENT,
  `id_sucursal` int(11) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `moneda` char(3) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_ordenpago`),
  KEY `FK_ID_SUCURSAL_ORDENPAGO_idx` (`id_sucursal`),
  CONSTRAINT `FK_ID_SUCURSAL_ORDENPAGO` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenpago`
--

LOCK TABLES `ordenpago` WRITE;
/*!40000 ALTER TABLE `ordenpago` DISABLE KEYS */;
INSERT INTO `ordenpago` VALUES (1,2,20.00,'PEN',1,'2020-10-10 14:10:20'),(2,2,30.00,'PEN',1,'2020-10-10 14:10:20'),(3,2,40.00,'PEN',1,'2020-10-10 14:10:20'),(4,2,20.00,'USD',1,'2020-10-10 14:10:20'),(5,3,20.00,'USD',1,'2020-10-10 14:10:20'),(6,3,30.00,'USD',1,'2020-10-10 14:10:20');
/*!40000 ALTER TABLE `ordenpago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `id_banco` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_sucursal`),
  KEY `FK_ID_BANCO_idx` (`id_banco`),
  CONSTRAINT `FK_ID_BANCO_SUCURSAL` FOREIGN KEY (`id_banco`) REFERENCES `banco` (`id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,4,'Sucursal 1','direc sucursal','2020-10-10 14:10:20'),(2,4,'Sucursal 2','direc sucursal','2020-10-10 14:10:20'),(3,5,'Sucursal 1','direc sucursal','2020-10-10 14:10:20');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-20  0:43:33
