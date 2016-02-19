-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2016 at 09:34 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skillcatch`
--

-- --------------------------------------------------------

--
-- Table structure for table `badge`
--

CREATE TABLE IF NOT EXISTS `badge` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `badge_has_task`
--

CREATE TABLE IF NOT EXISTS `badge_has_task` (
  `badge_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `group_local`
--

CREATE TABLE IF NOT EXISTS `group_local` (
  `groupId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_local`
--

INSERT INTO `group_local` (`groupId`, `name`, `startDate`, `endDate`) VALUES
(1, 'dasdsa', '2013-01-20', '2013-01-20'),
(2, 'ddsa', '2013-02-20', '2013-03-20'),
(3, 'cata', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `project_group`
--

CREATE TABLE IF NOT EXISTS `project_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `descriptions` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_group`
--

INSERT INTO `project_group` (`id`, `name`, `descriptions`, `status`) VALUES
(1, 'Ionut', 'Entry-Level', 1),
(2, 'Andrei', 'Entry-Level', 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task_plan`
--

CREATE TABLE IF NOT EXISTS `task_plan` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task_plan_has_project_group`
--

CREATE TABLE IF NOT EXISTS `task_plan_has_project_group` (
  `task_plan_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task_plan_has_task`
--

CREATE TABLE IF NOT EXISTS `task_plan_has_task` (
  `task_plan_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('Andrei', '$2a$04$.v8YDmOWVrcaUGIPyQ.hz.6V6NudPTr1OhuQ0VMEIN.L4NovBhlOi'),
('Ionut', '1234567');

-- --------------------------------------------------------

--
-- Table structure for table `user_has_project_group`
--

CREATE TABLE IF NOT EXISTS `user_has_project_group` (
  `user_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_has_role`
--

CREATE TABLE IF NOT EXISTS `user_has_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_has_task`
--

CREATE TABLE IF NOT EXISTS `user_has_task` (
  `user_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(2, 'Andrei', 'ROLE_DEV'),
(1, 'Ionut', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `badge`
--
ALTER TABLE `badge`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `badge_has_task`
--
ALTER TABLE `badge_has_task`
  ADD PRIMARY KEY (`badge_id`,`task_id`),
  ADD KEY `fk_badge_has_task_task1_idx` (`task_id`),
  ADD KEY `fk_badge_has_task_badge1_idx` (`badge_id`);

--
-- Indexes for table `group_local`
--
ALTER TABLE `group_local`
  ADD PRIMARY KEY (`groupId`);

--
-- Indexes for table `project_group`
--
ALTER TABLE `project_group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task_plan`
--
ALTER TABLE `task_plan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task_plan_has_project_group`
--
ALTER TABLE `task_plan_has_project_group`
  ADD PRIMARY KEY (`task_plan_id`,`project_group_id`),
  ADD KEY `fk_task_plan_has_project_group_project_group1_idx` (`project_group_id`),
  ADD KEY `fk_task_plan_has_project_group_task_plan1_idx` (`task_plan_id`);

--
-- Indexes for table `task_plan_has_task`
--
ALTER TABLE `task_plan_has_task`
  ADD PRIMARY KEY (`task_plan_id`,`task_id`),
  ADD KEY `fk_task_plan_has_task_task1_idx` (`task_id`),
  ADD KEY `fk_task_plan_has_task_task_plan_idx` (`task_plan_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_has_project_group`
--
ALTER TABLE `user_has_project_group`
  ADD PRIMARY KEY (`user_id`,`project_group_id`),
  ADD KEY `fk_user_has_project_group_project_group1_idx` (`project_group_id`),
  ADD KEY `fk_user_has_project_group_user_idx` (`user_id`);

--
-- Indexes for table `user_has_role`
--
ALTER TABLE `user_has_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `fk_user_has_role_role1_idx` (`role_id`),
  ADD KEY `fk_user_has_role_user1_idx` (`user_id`);

--
-- Indexes for table `user_has_task`
--
ALTER TABLE `user_has_task`
  ADD PRIMARY KEY (`user_id`,`task_id`),
  ADD KEY `fk_user_has_task_task1_idx` (`task_id`),
  ADD KEY `fk_user_has_task_user1_idx` (`user_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uni_username_role` (`role`,`username`),
  ADD KEY `fk_username_idx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `badge_has_task`
--
ALTER TABLE `badge_has_task`
  ADD CONSTRAINT `fk_badge_has_task_badge1` FOREIGN KEY (`badge_id`) REFERENCES `badge` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_badge_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `task_plan_has_project_group`
--
ALTER TABLE `task_plan_has_project_group`
  ADD CONSTRAINT `fk_task_plan_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_task_plan_has_project_group_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `task_plan_has_task`
--
ALTER TABLE `task_plan_has_task`
  ADD CONSTRAINT `fk_task_plan_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_task_plan_has_task_task_plan` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_has_project_group`
--
ALTER TABLE `user_has_project_group`
  ADD CONSTRAINT `fk_user_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_project_group_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_has_role`
--
ALTER TABLE `user_has_role`
  ADD CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_has_task`
--
ALTER TABLE `user_has_task`
  ADD CONSTRAINT `fk_user_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_task_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
