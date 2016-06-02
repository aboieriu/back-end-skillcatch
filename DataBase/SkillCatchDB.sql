-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Iun 2016 la 14:03
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
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `badge`
--

INSERT INTO `badge` (`id`, `name`, `description`, `task_id`) VALUES
(1, 'Fine Results', 'Badge for Fine Results', 1),
(2, 'Best Results', 'Badge for Best Results', 1),
(3, 'Extraordinary Results', 'Badge for Extraordinary Results', 1),
(4, 'Extraordinary Results', 'Badge for Extraordinary Results', 2);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `project_group`
--

CREATE TABLE `project_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `descriptions` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `project_group`
--

INSERT INTO `project_group` (`id`, `name`, `descriptions`, `status`, `user_id`) VALUES
(1, 'Grup1', 'Java jdk 1.6', 2, 1),
(4, 'Grup2', 'JavaScript, PHP', 1, 1),
(5, 'Grup 5', 'Pyton', 3, 2),
(6, 'Grup 6', 'Ruby', 2, 3),
(8, 'Grup8', 'HTML CSS', 1, 3);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `project_group_has_task_plan`
--

CREATE TABLE `project_group_has_task_plan` (
  `task_plan_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `project_group_has_task_plan`
--

INSERT INTO `project_group_has_task_plan` (`task_plan_id`, `project_group_id`) VALUES
(1, 1),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `project_group_has_user`
--

CREATE TABLE `project_group_has_user` (
  `user_id` int(11) NOT NULL,
  `project_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `project_group_has_user`
--

INSERT INTO `project_group_has_user` (`user_id`, `project_group_id`) VALUES
(1, 1),
(1, 4),
(2, 5);

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
(1, 'ROLE_DEV', 'Rol Developer'),
(2, 'ROLE_USER', 'Rol Utilizator');

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
(1, 'Context Creation', 'Creare Context Servlet', 'On Progress'),
(2, 'Hibernate Mapping', 'Mapare Entitati', 'On Progress');

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
(1, 'Spring Integration', 'Adaugare componente Spring'),
(2, 'Hibernate Integration', 'Adaugare componente Hibernate');

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
(2, 2);

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
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `surname`, `email`, `password`, `phone`, `address`, `image`) VALUES
(1, 'admin', 'Administrator', 'Administrator', 'admin@skillcatch.com', '$2a$12$eTQ.ZPJsQEuWRdUfR6crXObIcta.5ZDTqIxjNZsCi8EnVGNiIXlva', '123456', 'Str.Turnului Nr. 3', 'http://expatbloke.com/wp-content/uploads/2016/01/default_avatar_560d512bd0fc2.gif'),
(2, 'Ionut', 'Ionut', 'Developer', 'ionut@skillcatch.com', '$2a$12$nXDuPzufHkx7jki0OmP91.sxUL/6RgQU66lUOCxGjq6ydTKRwOPL.', '123456', 'Str.Garii', 'http://expatbloke.com/wp-content/uploads/2016/01/default_avatar_560d512bd0fc2.gif'),
(3, 'User', 'User', 'User', 'user@skillcatch.com', '$2a$12$wmBRMxI4oRJvU7LOnYtvZ.Eo.IxKj9TLy.x1BtaPs3ywtYhgXJYVe', 'usernormal', 'Str.Harmanului', 'http://expatbloke.com/wp-content/uploads/2016/01/default_avatar_560d512bd0fc2.gif');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user_has_badge`
--

CREATE TABLE `user_has_badge` (
  `user_id` int(11) NOT NULL,
  `badge_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user_has_badge`
--

INSERT INTO `user_has_badge` (`user_id`, `badge_id`) VALUES
(1, 2),
(2, 4),
(3, 1),
(3, 2);

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
(1, 2),
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user_has_task`
--

CREATE TABLE `user_has_task` (
  `user_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user_has_task`
--

INSERT INTO `user_has_task` (`user_id`, `task_id`) VALUES
(1, 1),
(2, 2),
(3, 1);

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
-- Indexes for table `project_group`
--
ALTER TABLE `project_group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project_group_has_task_plan`
--
ALTER TABLE `project_group_has_task_plan`
  ADD PRIMARY KEY (`task_plan_id`,`project_group_id`),
  ADD KEY `fk_task_plan_has_project_group_project_group1_idx` (`project_group_id`),
  ADD KEY `fk_task_plan_has_project_group_task_plan1_idx` (`task_plan_id`);

--
-- Indexes for table `project_group_has_user`
--
ALTER TABLE `project_group_has_user`
  ADD PRIMARY KEY (`user_id`,`project_group_id`),
  ADD KEY `fk_user_has_project_group_project_group1_idx` (`project_group_id`),
  ADD KEY `fk_user_has_project_group_user_idx` (`user_id`);

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
-- Indexes for table `user_has_badge`
--
ALTER TABLE `user_has_badge`
  ADD PRIMARY KEY (`user_id`,`badge_id`),
  ADD KEY `fk_badge_id` (`badge_id`);

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
-- Restrictii pentru tabele sterse
--

--
-- Restrictii pentru tabele `project_group_has_task_plan`
--
ALTER TABLE `project_group_has_task_plan`
  ADD CONSTRAINT `fk_task_plan_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_plan_has_project_group_task_plan1` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `project_group_has_user`
--
ALTER TABLE `project_group_has_user`
  ADD CONSTRAINT `fk_user_has_project_group_project_group1` FOREIGN KEY (`project_group_id`) REFERENCES `project_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_has_project_group_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `task_plan_has_task`
--
ALTER TABLE `task_plan_has_task`
  ADD CONSTRAINT `fk_task_plan_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_task_plan_has_task_task_plan` FOREIGN KEY (`task_plan_id`) REFERENCES `task_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `user_has_badge`
--
ALTER TABLE `user_has_badge`
  ADD CONSTRAINT `fk_badge_id` FOREIGN KEY (`badge_id`) REFERENCES `badge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `user_has_role`
--
ALTER TABLE `user_has_role`
  ADD CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrictii pentru tabele `user_has_task`
--
ALTER TABLE `user_has_task`
  ADD CONSTRAINT `fk_user_has_task_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_has_task_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
