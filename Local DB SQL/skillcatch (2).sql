-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23 Oct 2015 la 13:58
-- Versiune server: 5.6.26
-- PHP Version: 5.5.28

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
-- Structura de tabel pentru tabelul `login_group`
--

CREATE TABLE IF NOT EXISTS `login_group` (
  `id` int(11) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `login_group`
--

INSERT INTO `login_group` (`id`, `user_name`, `password`) VALUES
(0, 'Vasile', 'abcd1234'),
(1, 'Petrica', '1234abcd');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `login_user`
--

CREATE TABLE IF NOT EXISTS `login_user` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(11) NOT NULL,
  `repositoryUrl` varchar(100) NOT NULL,
  `groupId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `login_user`
--

INSERT INTO `login_user` (`id`, `user_name`, `password`, `surname`, `name`, `email`, `phone`, `repositoryUrl`, `groupId`) VALUES
(1, 'Smaranda', 'qwerty123', 'Popescu', 'Smaranda', 'smaranda_popescu@yahoo.com', 21312, 'www.google.ro', 2),
(2, 'Esmeralda', '123pisi', 'sajfojs', 'jbsdjvcb', 'Esmeralda.sajfojs@yahoo.com', 8862, 'www.youtube.com', 1),
(3, 'abcd', '1123rty', 'dfdvc', 'advd', 's.f@yahoo.com', 4354, '', 0);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'Gigel', '1234567'),
(2, 'Ninel', 'abcdef');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_group`
--
ALTER TABLE `login_group`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `login_user`
--
ALTER TABLE `login_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
