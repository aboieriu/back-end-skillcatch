-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: skillcatch
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `badge`
--

DROP TABLE IF EXISTS `badge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `badge` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badge`
--

LOCK TABLES `badge` WRITE;
/*!40000 ALTER TABLE `badge` DISABLE KEYS */;
INSERT INTO `badge` VALUES (1,'pro java',NULL);
/*!40000 ALTER TABLE `badge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_local`
--

DROP TABLE IF EXISTS `group_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_local` (
  `groupId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_local`
--

LOCK TABLES `group_local` WRITE;
/*!40000 ALTER TABLE `group_local` DISABLE KEYS */;
INSERT INTO `group_local` VALUES (1,'dasdsa','2013-01-20','2013-01-20'),(2,'ddsa','2013-02-20','2013-03-20'),(3,'cata',NULL,NULL);
/*!40000 ALTER TABLE `group_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_group`
--

DROP TABLE IF EXISTS `project_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `descriptions` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_group`
--

LOCK TABLES `project_group` WRITE;
/*!40000 ALTER TABLE `project_group` DISABLE KEYS */;
INSERT INTO `project_group` VALUES (1,'Ionut','Entry-Level',1),(2,'Andrei','Entry-Level',1);
/*!40000 ALTER TABLE `project_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_group_has_task_plan`
--

DROP TABLE IF EXISTS `project_group_has_task_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_group_has_task_plan` (
  `task_plan_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL,
  PRIMARY KEY (`task_plan_id`,`project_group_id`),
  KEY `fk_task_plan_has_project_group_project_group1_idx` (`project_group_id`),
  KEY `fk_task_plan_has_project_group_task_plan1_idx` (`task_plan_id`),
  CONSTRAINT `fk_task_plan_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_plan_has_project_group_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_group_has_task_plan`
--

LOCK TABLES `project_group_has_task_plan` WRITE;
/*!40000 ALTER TABLE `project_group_has_task_plan` DISABLE KEYS */;
INSERT INTO `project_group_has_task_plan` VALUES (1,2);
/*!40000 ALTER TABLE `project_group_has_task_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_group_has_user`
--

DROP TABLE IF EXISTS `project_group_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_group_has_user` (
  `user_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`project_group_id`),
  KEY `fk_user_has_project_group_project_group1_idx` (`project_group_id`),
  KEY `fk_user_has_project_group_user_idx` (`user_id`),
  CONSTRAINT `fk_user_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_project_group_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_group_has_user`
--

LOCK TABLES `project_group_has_user` WRITE;
/*!40000 ALTER TABLE `project_group_has_user` DISABLE KEYS */;
INSERT INTO `project_group_has_user` VALUES (0,2),(1,2);
/*!40000 ALTER TABLE `project_group_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_DEV',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Create Table',NULL),(2,'Destroy',NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_has_badge`
--

DROP TABLE IF EXISTS `task_has_badge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_has_badge` (
  `badge_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  PRIMARY KEY (`badge_id`,`task_id`),
  KEY `fk_badge_has_task_task1_idx` (`task_id`),
  KEY `fk_badge_has_task_badge1_idx` (`badge_id`),
  CONSTRAINT `fk_badge_has_task_badge1` FOREIGN KEY (`badge_id`) REFERENCES `badge` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_badge_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_has_badge`
--

LOCK TABLES `task_has_badge` WRITE;
/*!40000 ALTER TABLE `task_has_badge` DISABLE KEYS */;
INSERT INTO `task_has_badge` VALUES (1,1);
/*!40000 ALTER TABLE `task_has_badge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_plan`
--

DROP TABLE IF EXISTS `task_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_plan` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_plan`
--

LOCK TABLES `task_plan` WRITE;
/*!40000 ALTER TABLE `task_plan` DISABLE KEYS */;
INSERT INTO `task_plan` VALUES (1,'Start','Create DB');
/*!40000 ALTER TABLE `task_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_plan_has_task`
--

DROP TABLE IF EXISTS `task_plan_has_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_plan_has_task` (
  `task_plan_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  PRIMARY KEY (`task_plan_id`,`task_id`),
  KEY `fk_task_plan_has_task_task1_idx` (`task_id`),
  KEY `fk_task_plan_has_task_task_plan_idx` (`task_plan_id`),
  CONSTRAINT `fk_task_plan_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_plan_has_task_task_plan` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_plan_has_task`
--

LOCK TABLES `task_plan_has_task` WRITE;
/*!40000 ALTER TABLE `task_plan_has_task` DISABLE KEYS */;
INSERT INTO `task_plan_has_task` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `task_plan_has_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'Andrei','adnrei',NULL,NULL,'234',NULL,NULL),(1,'cata','cata','vlad',NULL,'123',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_role`
--

DROP TABLE IF EXISTS `user_has_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_has_role_role1_idx` (`role_id`),
  KEY `fk_user_has_role_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_role`
--

LOCK TABLES `user_has_role` WRITE;
/*!40000 ALTER TABLE `user_has_role` DISABLE KEYS */;
INSERT INTO `user_has_role` VALUES (0,1),(1,1);
/*!40000 ALTER TABLE `user_has_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_task`
--

DROP TABLE IF EXISTS `user_has_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_task` (
  `user_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`task_id`),
  KEY `fk_user_has_task_task1_idx` (`task_id`),
  KEY `fk_user_has_task_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_task_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_task`
--

LOCK TABLES `user_has_task` WRITE;
/*!40000 ALTER TABLE `user_has_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-15 17:51:50
