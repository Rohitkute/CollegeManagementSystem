-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: collegemanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `course_id` bigint DEFAULT NULL,
  `professor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UK_fe0i52si7ybu0wjedj6motiim` (`email`),
  KEY `FKdfypyqt0stgfc0aij9kcxm99s` (`course_id`),
  KEY `FK6qd34ryg9xge96upkktpry261` (`professor_id`),
  CONSTRAINT `FK6qd34ryg9xge96upkktpry261` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`professor_id`),
  CONSTRAINT `FKdfypyqt0stgfc0aij9kcxm99s` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'address1','2000-01-01','student1@example.com','John','MALE','Doe','password1',1,1),(2,'address2','2000-02-02','student2@example.com','Jane','FEMALE','Smith','password2',2,2),(3,'address3','2000-03-03','student3@example.com','Bob','MALE','Johnson','password3',1,1),(4,'address4','2000-04-04','student4@example.com','Alice','FEMALE','Williams','password4',3,3),(5,'address5','2000-05-05','student5@example.com','David','MALE','Brown','password5',2,2),(6,'address6','2000-06-06','student6@example.com','Sarah','FEMALE','Davis','password6',3,3),(7,'address7','2000-07-07','student7@example.com','Tom','MALE','Garcia','password7',1,1),(8,'address8','2000-08-08','student8@example.com','Emily','FEMALE','Martinez','password8',2,2),(9,'address9','2000-09-09','student9@example.com','Mike','MALE','Anderson','password9',3,3),(10,'address10','2000-10-10','student10@example.com','Lisa','FEMALE','Taylor','password10',1,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-19  8:24:38
