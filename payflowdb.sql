-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 26, 2025 at 03:40 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payflowdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `admId` varchar(10) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `CEO`
--

CREATE TABLE `CEO` (
  `mngId` varchar(10) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `empID` varchar(10) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `id` varchar(10) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `trn` varchar(9) NOT NULL,
  `country` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `day` int(10) NOT NULL,
  `month` int(10) NOT NULL,
  `year` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`id`, `fullName`, `email`, `trn`, `country`, `street`, `city`, `parish`, `gender`, `day`, `month`, `year`) VALUES
('EMP001', '', 'janesmith@example.com', '123456789', 'Jamaica', 'Macathy Street', 'Montego Bay', 'St. James', 'Male', 7, 10, 1945),
('EMP002', '', 'desrine@gmail.com', '133895912', 'Jamaica', 'Macathy Street', 'Montego Bay', 'St. James', 'Female', 28, 7, 2004),
('EMP005', 'Test Software', 'testsoftware@gmail.com', '133895912', 'Jamaica', 'Princess Street', 'Morant Bay', 'St. Thomas', 'Male', 28, 10, 2004),
('EMP007', 'Deszana Harripaul', 'allaboutdez2025@gmail.com', '109987746', 'Jamaica', 'Manchester', 'Montego Bay', 'St. James', 'Female', 28, 7, 2004),
('EMP008', 'Hannah Maxwell', 'hannahmaxwell@gmail.com', '567826579', 'Jamaica', 'Macathy Street', 'Montego Bay', 'St. James', 'Female', 23, 8, 2012),
('EMP009', 'Josiah Maxwell', 'maxjosiah@gmail.com', '17807665', 'Jamaica', 'James Bond Beach', 'St. Anns Bay', 'St. Ann', 'Male', 7, 10, 2002),
('EMP1000', '', 'ashermaxwell@employee.com', '132456789', 'Jamaica', 'New Road', 'Kingston', 'Kingston', 'male', 9, 10, 2002),
('MNG1000', '', 'manager1000@payflow.com', '123456789', 'Jamaica', 'Money St.', 'Montego Bay', 'St. James', 'male', 7, 10, 1999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`admId`);

--
-- Indexes for table `CEO`
--
ALTER TABLE `CEO`
  ADD PRIMARY KEY (`mngId`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `emails` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
