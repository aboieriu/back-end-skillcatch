-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Sep 2016 la 10:13
-- Versiune server: 10.1.9-MariaDB
-- PHP Version: 5.5.30

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
-- Structura de tabel pentru tabelul `badge`
--

CREATE TABLE `badge` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `badge`
--

INSERT INTO `badge` (`id`, `name`, `description`, `image`, `points`) VALUES
(1, 'Awesomenewss', 'Excelent Job', 'http://localhost:8080/skillcatch/images/badges/award-icon.png', 100),
(2, 'Bodacious', 'Really Nice Done!', 'http://localhost:8080/skillcatch/images/badges/award-icon.png', 500),
(3, 'SuperImportantDoer', 'God Among Humans', 'http://localhost:8080/skillcatch/images/badges/award-icon.png', 750),
(4, 'SecondDoersBadges', 'Good Job', 'http://localhost:8080/skillcatch/images/badges/trophy-icon.png', 300),
(5, 'UserOwnTaskPlanBadge', 'Nice Job', 'http://localhost:8080/skillcatch/images/badges/award-icon.png', 200),
(6, 'SomeNewFancyBadge', 'Really cool WebDesigner', 'http://localhost:8080/skillcatch/images/badges/trophy-icon.png', 800);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `descriptions` varchar(45) DEFAULT NULL,
  `createdOn` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `project`
--

INSERT INTO `project` (`id`, `name`, `descriptions`, `createdOn`) VALUES
(1, 'FirstProject', 'FirstProject''s Descriprion', '2016-07-04 05:04:07.000000'),
(2, 'SecondProject', 'SecondProject''s Description', '2016-07-04 05:04:07.000000'),
(3, 'ThirdProject', 'ThirdProject''s Description', '2016-07-04 05:04:07.000000');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `project_has_task_plan`
--

CREATE TABLE `project_has_task_plan` (
  `task_plan_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `project_has_task_plan`
--

INSERT INTO `project_has_task_plan` (`task_plan_id`, `project_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(5, 3);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `role`
--

INSERT INTO `role` (`id`, `name`, `description`) VALUES
(1, 'ROLE_ADMIN', 'Administrator Credentials'),
(2, 'ROLE_USER', 'User Credentials'),
(4, 'ROLE_USER', 'Rol Utilizator'),
(5, 'ROLE_USER', 'Rol Utilizator'),
(6, 'ROLE_USER', 'Rol Utilizator'),
(7, 'ROLE_USER', 'Rol Utilizator'),
(8, 'ROLE_USER', 'Rol Utilizator'),
(9, 'ROLE_USER', 'Rol Utilizator'),
(10, 'ROLE_USER', 'Rol Utilizator'),
(11, 'ROLE_USER', 'Rol Utilizator');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `task`
--

INSERT INTO `task` (`id`, `name`, `description`, `status`) VALUES
(1, 'Install Java', 'Some Task Description', 'DONE'),
(2, 'SetupMaven', 'Some Task Description', 'DONE'),
(3, 'Setup SpringMVC', 'Some Task Description', 'DONE'),
(4, 'Deployment Task', 'Some Task Description', 'DONE'),
(5, 'Hibernate Mapping', 'Some Task Description', 'DONE'),
(6, 'Setup Hibernate', 'Some Task Description', 'DONE'),
(7, 'HttpClient Development', 'Some Task Description', 'DONE'),
(8, 'UnitTesting', 'Some Task Description', 'DONE'),
(9, 'GPopescuIndividualTask', 'Individual Task Description', 'TODO'),
(10, 'test', 'do something', 'TODO'),
(26, 'dasfdf', 'sdafsdfds', 'TODO');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `task_has_badge`
--

CREATE TABLE `task_has_badge` (
  `task_id` int(11) NOT NULL,
  `badge_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `task_has_badge`
--

INSERT INTO `task_has_badge` (`task_id`, `badge_id`) VALUES
(1, 6),
(2, 4),
(2, 6),
(3, 2),
(4, 4),
(5, 1),
(6, 2),
(6, 6),
(9, 1),
(9, 2),
(10, 1),
(10, 2);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `task_plan`
--

CREATE TABLE `task_plan` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `task_plan`
--

INSERT INTO `task_plan` (`id`, `name`, `description`) VALUES
(1, 'ProjectInit', 'Init project description'),
(2, 'ProjectSecondTask', 'More important tasks'),
(3, 'OwnUserTaskPlan', 'Super important stuff for user'),
(4, 'OwnUserTaskPlan2', 'Super important stuff 2 for user'),
(5, 'New TaskPlan', 'New TaskPlan'),
(6, 'Some Individual TaskPlan', 'Some Individual TaskPlan Description'),
(7, 'GPopescuIndividualTaskPlan', 'Individual user TaskPlan');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `task_plan_has_badge`
--

CREATE TABLE `task_plan_has_badge` (
  `task_plan_id` int(11) NOT NULL,
  `badge_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `task_plan_has_badge`
--

INSERT INTO `task_plan_has_badge` (`task_plan_id`, `badge_id`) VALUES
(1, 1),
(1, 4),
(1, 5),
(3, 5),
(4, 3),
(6, 1),
(6, 3),
(7, 5);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `task_plan_has_task`
--

CREATE TABLE `task_plan_has_task` (
  `task_plan_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `task_plan_has_task`
--

INSERT INTO `task_plan_has_task` (`task_plan_id`, `task_id`) VALUES
(1, 1),
(1, 2),
(2, 5),
(2, 6),
(3, 7),
(3, 8),
(4, 3),
(4, 4),
(4, 26),
(6, 10),
(7, 9);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `image` varchar(500) NOT NULL,
  `addedOn` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `surname`, `email`, `password`, `phone`, `address`, `image`, `addedOn`) VALUES
(1, 'admin', 'admin', 'admin', 'admin@admin.com', '$2a$12$eTQ.ZPJsQEuWRdUfR6crXObIcta.5ZDTqIxjNZsCi8EnVGNiIXlva', '0723134787', 'address', 'http://localhost:8080/skillcatch/images/malecostume-512.png', '2016-07-06 06:05:02.000000'),
(2, 'gpopescu', 'Popescu', 'George', 'gpopescu@pentalog.fr', '$2a$10$6IF2vsnYV5iKOOSplwwPdeaiLQOyXA9pW/xkD3KgXmMB1tpJsY43a', '07220120057', 'Str. Nicolae Balcescu Nr. 4', 'http://localhost:8080/skillcatch/images/user.jpg', '2016-07-29 01:01:01.000000'),
(5, 'SecondUser', 'SecondUser', 'SecondUser', 'SecondUser@skillcatch.com', '$2a$10$BfV4uAUDudvmCD0/hsfnIeND81QnMN5sTOKr4OT.24zUC6qf7a/G2', NULL, NULL, 'http://localhost:8080/skillcatch/images/Chrysanthemum.jpg', '2016-08-31 09:49:31.000000'),
(6, 'ThirdUser', 'ThirdUser', 'ThirdUser', 'ThirdUser@skillcatch.com', '$2a$10$qzW4SuGu01/ZMhp5g8Dwh.FTnMFgxTZdLg0q5N.urWfae0HXT7Aqa', NULL, NULL, 'http://localhost:8080/skillcatch/images/Penguins.jpg', '2016-09-20 10:37:06.000000');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user_has_project`
--

CREATE TABLE `user_has_project` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user_has_project`
--

INSERT INTO `user_has_project` (`user_id`, `project_id`) VALUES
(1, 1),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(5, 2);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user_has_role`
--

CREATE TABLE `user_has_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user_has_role`
--

INSERT INTO `user_has_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(5, 9),
(6, 11);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user_has_task_plan`
--

CREATE TABLE `user_has_task_plan` (
  `user_id` int(11) NOT NULL,
  `task_plan_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user_has_task_plan`
--

INSERT INTO `user_has_task_plan` (`user_id`, `task_plan_id`) VALUES
(2, 6),
(2, 7),
(5, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `badge`
--
ALTER TABLE `badge`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project_has_task_plan`
--
ALTER TABLE `project_has_task_plan`
  ADD PRIMARY KEY (`task_plan_id`,`project_id`),
  ADD KEY `fk_task_plan_has_project_group_project_group1_idx` (`project_id`),
  ADD KEY `fk_task_plan_has_project_group_task_plan1_idx` (`task_plan_id`);

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
-- Indexes for table `task_has_badge`
--
ALTER TABLE `task_has_badge`
  ADD PRIMARY KEY (`task_id`,`badge_id`),
  ADD KEY `fk_task_has_badge_badge1_idx` (`badge_id`),
  ADD KEY `fk_task_has_badge_task1_idx` (`task_id`);

--
-- Indexes for table `task_plan`
--
ALTER TABLE `task_plan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task_plan_has_badge`
--
ALTER TABLE `task_plan_has_badge`
  ADD PRIMARY KEY (`task_plan_id`,`badge_id`),
  ADD KEY `fk_task_plan_has_badge_badge1_idx` (`badge_id`),
  ADD KEY `fk_task_plan_has_badge_task_plan1_idx` (`task_plan_id`);

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
-- Indexes for table `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD PRIMARY KEY (`user_id`,`project_id`),
  ADD KEY `fk_user_has_project_project1_idx` (`project_id`),
  ADD KEY `fk_user_has_project_user1_idx` (`user_id`);

--
-- Indexes for table `user_has_role`
--
ALTER TABLE `user_has_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `fk_user_has_role_role1_idx` (`role_id`),
  ADD KEY `fk_user_has_role_user1_idx` (`user_id`);

--
-- Indexes for table `user_has_task_plan`
--
ALTER TABLE `user_has_task_plan`
  ADD PRIMARY KEY (`user_id`,`task_plan_id`),
  ADD KEY `fk_user_has_task_plan_task_plan1_idx` (`task_plan_id`),
  ADD KEY `fk_user_has_task_plan_user1_idx` (`user_id`);

--
-- Restrictii pentru tabele sterse
--

--
-- Restrictii pentru tabele `project_has_task_plan`
--
ALTER TABLE `project_has_task_plan`
  ADD CONSTRAINT `fk_task_plan_has_project_group_project_group1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_plan_has_project_group_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `task_has_badge`
--
ALTER TABLE `task_has_badge`
  ADD CONSTRAINT `fk_task_has_badge_badge1` FOREIGN KEY (`badge_id`) REFERENCES `badge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_has_badge_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `task_plan_has_badge`
--
ALTER TABLE `task_plan_has_badge`
  ADD CONSTRAINT `fk_task_plan_has_badge_badge1` FOREIGN KEY (`badge_id`) REFERENCES `badge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_plan_has_badge_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `task_plan_has_task`
--
ALTER TABLE `task_plan_has_task`
  ADD CONSTRAINT `fk_task_plan_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_plan_has_task_task_plan` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD CONSTRAINT `fk_user_has_project_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_project_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrictii pentru tabele `user_has_role`
--
ALTER TABLE `user_has_role`
  ADD CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrictii pentru tabele `user_has_task_plan`
--
ALTER TABLE `user_has_task_plan`
  ADD CONSTRAINT `fk_user_has_task_plan_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_has_task_plan_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
