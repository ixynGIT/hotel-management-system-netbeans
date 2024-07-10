-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2023 at 04:09 PM
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
-- Database: `plasabas_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `roomno` varchar(30) NOT NULL,
  `Fullname` varchar(50) NOT NULL,
  `Cnumber` varchar(11) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `GovType` varchar(30) NOT NULL,
  `GovID` varchar(35) NOT NULL,
  `CheckIN` varchar(30) NOT NULL,
  `CheckOUT` varchar(30) DEFAULT NULL,
  `Rprice` int(30) NOT NULL,
  `Rtotal` int(35) NOT NULL,
  `Paid` int(30) DEFAULT NULL,
  `TOTAL` int(11) NOT NULL,
  `Stat` varchar(30) NOT NULL,
  `clientid` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`roomno`, `Fullname`, `Cnumber`, `Address`, `GovType`, `GovID`, `CheckIN`, `CheckOUT`, `Rprice`, `Rtotal`, `Paid`, `TOTAL`, `Stat`, `clientid`) VALUES
('OCHO-OCHO', 'Christian Rafael S. Plasabas', '09219539679', 'Prk Bangus, Panabo City', 'Driver License', '212-ADSFW', '2023-05-01', '2023-05-11', 2045, 20450, 20450, 0, 'Checked OUT', 1),
('X-2003', 'asdfasd', '13123', '123124', 'Phil Health', '42dxd', '2023-05-04', '2023-05-11', 400, 2800, 2800, 0, 'Checked OUT', 2);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomnumber` varchar(30) DEFAULT NULL,
  `roomtype` varchar(30) DEFAULT NULL,
  `price` int(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `roomid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomnumber`, `roomtype`, `price`, `status`, `roomid`) VALUES
('OCHO-OCHO', 'Premium', 8800, 'Available', 1),
('X-2003', 'Sukarap', 400, 'Available', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `log_id` int(10) NOT NULL,
  `log_uname` varchar(30) DEFAULT NULL,
  `log_pass` varchar(15) DEFAULT NULL,
  `log_fname` varchar(30) DEFAULT NULL,
  `log_lname` varchar(30) DEFAULT NULL,
  `log_sex` varchar(10) DEFAULT NULL,
  `log_cnum` varchar(11) DEFAULT NULL,
  `log_email` varchar(30) DEFAULT NULL,
  `log_squest` varchar(30) DEFAULT NULL,
  `log_sqAns` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`log_id`, `log_uname`, `log_pass`, `log_fname`, `log_lname`, `log_sex`, `log_cnum`, `log_email`, `log_squest`, `log_sqAns`) VALUES
(4, 'testing', '1234', 'christianrafael', 'plasabas', 'Male', '0923123', 'christianrafael@gmail.com', 'Who is your favorite person?', 'mom'),
(5, 'hello', 'kani', 'christian rafael', 'plasabas', 'Male', '012312', 'xd@gmail.com', 'What is your dream job?', 'sa puso mo'),
(6, 'register', '123', 'Kent', 'Baldo', 'Trans', '31231', '41231', 'What is your first pet name?', 'xd');

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE `types` (
  `type` varchar(30) DEFAULT NULL,
  `type_price` int(30) DEFAULT NULL,
  `typeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`type`, `type_price`, `typeid`) VALUES
('Premium', 8800, 1),
('Sukarap', 400, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`clientid`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomid`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`typeid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `clientid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_login`
--
ALTER TABLE `tbl_login`
  MODIFY `log_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `typeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
