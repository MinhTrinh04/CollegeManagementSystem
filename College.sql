-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: college
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `ID` int NOT NULL,
  `Name` longtext NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (0,'CNTT Việt Pháp K67'),(1,'Kỹ thuật Hóa học K67'),(2,'Ngôn ngữ Anh K67'),(3,'Kinh tế K67'),(4,'Điện tử Viễn thông K67');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `ID` int NOT NULL,
  `Name` longtext NOT NULL,
  `Class` int NOT NULL,
  `Description` longtext NOT NULL,
  `Lim` longtext NOT NULL,
  `Prof` int NOT NULL,
  `Department` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `Department_idx` (`Department`),
  KEY `Prof_idx` (`Prof`),
  KEY `Class_idx` (`Class`),
  CONSTRAINT `Class` FOREIGN KEY (`Class`) REFERENCES `classes` (`ID`),
  CONSTRAINT `Department` FOREIGN KEY (`Department`) REFERENCES `departments` (`ID`),
  CONSTRAINT `Prof` FOREIGN KEY (`Prof`) REFERENCES `employees` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Nhập môn lập trình',0,'Khóa học cơ bản về lập trình','30',1,1),(2,'Cấu trúc dữ liệu và giải thuật',0,'Khóa học về cấu trúc dữ liệu và giải thuật','25',1,1),(3,'Hệ điều hành',0,'Khóa học về hệ điều hành','35',1,1),(4,'Mạng máy tính',0,'Khóa học về mạng máy tính','40',1,1),(5,'Cơ sở dữ liệu',0,'Khóa học về cơ sở dữ liệu','30',1,1),(6,'Hóa học đại cương',1,'Khóa học cơ bản về hóa học','30',2,2),(7,'Hóa hữu cơ',1,'Khóa học về hóa hữu cơ','25',2,2),(8,'Hóa lý',1,'Khóa học về hóa lý','35',2,2),(9,'Hóa phân tích',1,'Khóa học về hóa phân tích','40',2,2),(10,'Kỹ thuật phản ứng',1,'Khóa học về kỹ thuật phản ứng','30',2,2),(11,'Tiếng Anh giao tiếp cơ bản',2,'Khóa học giao tiếp tiếng Anh cơ bản','30',3,3),(12,'Tiếng Anh thương mại',2,'Khóa học tiếng Anh cho thương mại','25',3,3),(13,'Viết luận tiếng Anh',2,'Khóa học về kỹ năng viết luận tiếng Anh','20',3,3),(14,'Ngữ pháp tiếng Anh nâng cao',2,'Khóa học ngữ pháp tiếng Anh nâng cao','35',3,3),(15,'Tiếng Anh chuyên ngành',2,'Khóa học tiếng Anh chuyên ngành','30',3,3),(16,'Kinh tế vi mô',3,'Các nguyên tắc cơ bản của kinh tế vi mô','30',4,4),(17,'Kinh tế vĩ mô',3,'Nghiên cứu về nền kinh tế tổng thể','25',4,4),(18,'Thị trường tài chính',3,'Tìm hiểu về thị trường tài chính','35',4,4),(19,'Phân tích kinh tế',3,'Phân tích dữ liệu kinh tế','40',4,4),(20,'Kinh tế lượng',3,'Ứng dụng thống kê trong kinh tế','30',4,4),(21,'Mạch điện tử',4,'Khóa học về mạch điện tử cơ bản','30',5,5),(22,'Viễn thông số',4,'Nghiên cứu về viễn thông kỹ thuật số','25',5,5),(23,'Xử lý tín hiệu số',4,'Tìm hiểu về xử lý tín hiệu số','35',5,5),(24,'Truyền thông không dây',4,'Khóa học về truyền thông không dây','40',5,5),(25,'Anten và lan truyền sóng',4,'Nghiên cứu về anten và lan truyền sóng','30',5,5);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `ID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (0,'Management'),(1,'Công nghệ thông tin'),(2,'Kỹ thuật Hóa học'),(3,'Ngôn ngữ Anh'),(4,'Kinh tế'),(5,'Điện tử Viễn thông');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `ID` int NOT NULL,
  `FirstName` longtext NOT NULL,
  `LastName` longtext NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PhoneNumber` longtext NOT NULL,
  `BirthDate` longtext NOT NULL,
  `Salary` double NOT NULL,
  `Department` int NOT NULL,
  `Password` longtext NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `Deaprtment_idx` (`Department`),
  CONSTRAINT `Deaprtment` FOREIGN KEY (`Department`) REFERENCES `departments` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (0,'Admin','0','admin0@gmail.com','1234567890','2000-01-01',0,0,'0000'),(1,'Nguyễn Văn','A','nguyenvana@gmail.com','0123456789','1980-05-10',60000,1,'1234'),(2,'Trần Thị','B','tranthib@gmail.com','0987654321','1978-08-15',65000,2,'1234'),(3,'Lê Văn','C','levanc@gmail.com','0169852357','1975-03-22',70000,3,'1234'),(4,'Phạm Thị','D','phamthid@gmail.com','0963258741','1982-07-05',75000,4,'1234'),(5,'Hồ Văn','E','hovane@gmail.com','0357896541','1979-11-18',80000,5,'1234');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `Enrollment_id` int NOT NULL AUTO_INCREMENT,
  `Course_id` int DEFAULT NULL,
  `Course_name` varchar(100) DEFAULT NULL,
  `Student_id` int DEFAULT NULL,
  `Student_name` varchar(100) DEFAULT NULL,
  `Class_id` int DEFAULT NULL,
  `Class_name` varchar(100) DEFAULT NULL,
  `Prof_id` int DEFAULT NULL,
  `Prof_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Enrollment_id`),
  UNIQUE KEY `UK_Enrollments_Course_Student_Class` (`Course_id`,`Student_id`,`Class_id`),
  UNIQUE KEY `enrollments_unique` (`Course_id`,`Student_id`,`Class_id`),
  KEY `Student_id` (`Student_id`),
  KEY `Class_id` (`Class_id`),
  KEY `FK_Enrollments_Employees_ID` (`Prof_id`),
  CONSTRAINT `enrollments_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `students` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `enrollments_ibfk_2` FOREIGN KEY (`Class_id`) REFERENCES `classes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `enrollments_ibfk_3` FOREIGN KEY (`Course_id`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Enrollments_Employees_ID` FOREIGN KEY (`Prof_id`) REFERENCES `employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Course` int NOT NULL,
  `Class` int NOT NULL,
  `Student` int NOT NULL,
  `Grade` double DEFAULT NULL,
  `Max` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Course` (`Course`,`Student`,`Class`),
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`Course`, `Student`, `Class`) REFERENCES `enrollments` (`Course_id`, `Student_id`, `Class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `ID` int NOT NULL,
  `FirstName` longtext NOT NULL,
  `LastName` longtext NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PhoneNumber` longtext NOT NULL,
  `BirthDate` longtext NOT NULL,
  `Class` int NOT NULL,
  `Password` longtext NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `Class_idx` (`Class`),
  CONSTRAINT `Class_id` FOREIGN KEY (`Class`) REFERENCES `classes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (0,'Minh','Trinh','minhtrinh@gmail.com','12345678','28-01-2004',0,'1234'),(1,'Hung','Ngo','hungngo@gmail.com','12345678','04-01-2004',0,'1234'),(2,'Lê Văn','Cường','cuongle@example.com','0912345678','2005-05-20',1,'1234'),(3,'Phạm Thị','Dung','dungpham@example.com','0876543210','2004-11-25',1,'1234'),(4,'Hồ Văn','Giang','giangho@example.com','0987654322','2005-02-10',2,'1234'),(5,'Vũ Thị','Hạnh','hanhvu@example.com','0123456780','2004-09-15',2,'1234'),(6,'Đặng Văn','Huy','huydang@example.com','0912345679','2005-07-05',3,'1234'),(7,'Bùi Thị','Linh','linhbui@example.com','0876543211','2004-04-20',3,'1234'),(8,'Đỗ Văn','Nam','namdo@example.com','0987654323','2005-12-10',4,'1234'),(9,'Ngô Thị','Oanh','oanhngo@example.com','0123456781','2004-06-05',4,'1234');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-10 17:46:09
