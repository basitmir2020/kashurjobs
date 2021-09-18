-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2020 at 02:47 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(300) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `Username`, `Password`, `date`) VALUES
(1, 'admin', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '2020-02-26 23:11:49');

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

CREATE TABLE `attendence` (
  `id` int(11) NOT NULL,
  `empId` int(11) DEFAULT NULL,
  `SchId` int(11) DEFAULT NULL,
  `signIn` time DEFAULT NULL,
  `signOut` time DEFAULT NULL,
  `signinDelay` int(11) DEFAULT NULL,
  `signoutDelay` int(11) DEFAULT NULL,
  `overtime` int(11) DEFAULT NULL,
  `companiesId` int(11) NOT NULL,
  `dateTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendence`
--

INSERT INTO `attendence` (`id`, `empId`, `SchId`, `signIn`, `signOut`, `signinDelay`, `signoutDelay`, `overtime`, `companiesId`, `dateTime`) VALUES
(2, 2, 1, '08:00:00', '10:00:00', 2, 0, 0, 2, '2020-03-01 22:53:40'),
(5, 5, 1, '08:00:00', '09:00:00', 1, 1, 0, 2, '2020-03-03 21:02:05'),
(6, 4, 1, '08:00:00', '08:00:00', 0, 0, 0, 2, '2020-03-05 21:49:18'),
(7, 5, 1, '08:00:00', '08:00:00', 0, 0, 0, 2, '2020-03-05 22:14:14'),
(8, 6, 5, '10:00:00', '05:00:00', 5, 5, 1, 2, '2020-03-07 12:18:26'),
(12, 7, 1, '08:00:00', '08:00:00', 0, 1, 1, 2, '2020-03-08 16:06:59');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `cname` varchar(30) NOT NULL,
  `phone` bigint(16) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `status` int(11) NOT NULL,
  `address` varchar(20) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `cname`, `phone`, `username`, `password`, `status`, `address`, `datetime`) VALUES
(1, 'Secure line', 9797981752, 'secureline', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', 1, 'habbak srg', '2020-02-26 23:17:09'),
(2, 'core face tech', 1234567895, 'corefacete', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', 1, 'lalchowk sgr', '2020-02-26 23:26:32'),
(3, 'niit limited', 1234567895, 'niitlimiited', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', 1, 'lalchowksrg', '2020-03-14 11:05:40');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `salaryId` int(11) DEFAULT NULL,
  `salaryRange` float DEFAULT NULL,
  `totalSalary` float DEFAULT NULL,
  `admitedOn` date DEFAULT NULL,
  `relievedOn` date DEFAULT NULL,
  `empTime` time DEFAULT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  `salaryDate` date DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `dateTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `userId`, `salaryId`, `salaryRange`, `totalSalary`, `admitedOn`, `relievedOn`, `empTime`, `scheduleId`, `salaryDate`, `roleId`, `companyId`, `dateTime`) VALUES
(1, 1, 2, 70000, 15000, '2019-03-02', '2020-03-02', '08:00:00', 1, '2020-03-01', 3, 2, '2020-03-01 16:16:50'),
(2, 2, 1, 70000, 20000, '2019-03-29', '2021-04-03', '08:00:00', 1, '2020-03-01', 3, 2, '2020-03-01 16:58:26'),
(3, 3, 2, 20000, 15000, '2019-03-04', '2020-03-04', '08:00:00', 3, '2020-03-09', 6, 2, '2020-03-03 11:21:43'),
(4, 4, 1, 80000, 20000, '2019-03-01', '2020-03-04', '08:00:00', 1, '2020-03-02', 6, 2, '2020-03-03 11:29:04'),
(5, 6, 1, 40000, 20000, '2019-02-25', '2020-03-09', '08:00:00', 1, '2020-03-05', 5, 2, '2020-03-03 11:50:21'),
(6, 8, 4, 60000, 10000, '2019-03-03', '2020-03-13', '08:00:00', 5, '2020-03-03', 7, 2, '2020-03-07 12:05:14'),
(7, 7, 5, 60000, 20000, '2019-03-11', '2020-03-12', '10:00:00', 1, '2020-03-18', 9, 2, '2020-03-08 15:06:46');

-- --------------------------------------------------------

--
-- Table structure for table `enquiry`
--

CREATE TABLE `enquiry` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `about` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enquiry`
--

INSERT INTO `enquiry` (`id`, `name`, `phone`, `about`, `date`) VALUES
(1, 'secureline', '9797981752', 'what is this', '2020-02-26 23:15:08');

-- --------------------------------------------------------

--
-- Table structure for table `issuesalary`
--

CREATE TABLE `issuesalary` (
  `id` int(11) NOT NULL,
  `empid` int(11) DEFAULT NULL,
  `attendenceId` int(11) DEFAULT NULL,
  `dueon` date DEFAULT NULL,
  `takeOn` date DEFAULT NULL,
  `leavesTaken` int(11) DEFAULT NULL,
  `dayDec` float DEFAULT NULL,
  `minDec` float DEFAULT NULL,
  `overtime` float DEFAULT NULL,
  `totalDec` float DEFAULT NULL,
  `salaryTaken` float DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `companiesId` int(11) DEFAULT NULL,
  `dateTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuesalary`
--

INSERT INTO `issuesalary` (`id`, `empid`, `attendenceId`, `dueon`, `takeOn`, `leavesTaken`, `dayDec`, `minDec`, `overtime`, `totalDec`, `salaryTaken`, `balance`, `companiesId`, `dateTime`) VALUES
(1, 6, 12, '2020-03-03', '2020-03-03', 1, 0, 300, 1, 300, 9800, 4800, 2, '2020-03-08 23:43:15'),
(2, 7, 12, '2020-03-18', '2020-03-20', 2, 0, 0, 1, 0, 20100, 10100, 2, '2020-03-08 23:45:56'),
(3, 4, 12, '2020-03-02', '2020-02-29', 1, 0, 0, 0, 0, 20000, 10000, 2, '2020-03-15 12:53:47');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `companyId`, `datetime`) VALUES
(3, 'admin', 2, '2020-02-28 15:45:30'),
(5, 'administration', 2, '2020-02-28 15:56:13'),
(6, 'accounts', 2, '2020-02-28 15:57:15'),
(7, 'employee', 2, '2020-03-01 16:20:15'),
(8, 'student', 2, '2020-03-07 11:54:43'),
(9, 'developer', 2, '2020-03-08 13:39:56');

-- --------------------------------------------------------

--
-- Table structure for table `salaries`
--

CREATE TABLE `salaries` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salaryFrom` float DEFAULT NULL,
  `salaryTo` float DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `ta` float DEFAULT NULL,
  `da` float DEFAULT NULL,
  `pf` float DEFAULT NULL,
  `other` float DEFAULT NULL,
  `dayDeduction` float DEFAULT NULL,
  `minDeduction` float DEFAULT NULL,
  `maxDeductionTime` float DEFAULT NULL,
  `leavesAllowed` int(11) DEFAULT NULL,
  `companiesId` int(11) NOT NULL,
  `dataTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salaries`
--

INSERT INTO `salaries` (`id`, `name`, `salaryFrom`, `salaryTo`, `createdBy`, `ta`, `da`, `pf`, `other`, `dayDeduction`, `minDeduction`, `maxDeductionTime`, `leavesAllowed`, `companiesId`, `dataTime`) VALUES
(1, 'Accounts', 30000, 40000, 1, 2000, 1000, 500, 1000, 500, 100, 4, 1, 2, '2020-02-29 00:56:39'),
(2, 'webdeveloper', 10000, 50000, 2, 5000, 2000, 1000, 0, 300, 200, 3, 2, 2, '2020-02-29 00:58:38'),
(3, 'andriod developer', 30000, 60000, 1, 2000, 1000, 1000, 500, 300, 400, 1, 2, 2, '2020-03-01 16:35:06'),
(4, 'teacher', 10000, 50000, 3, 500, 1000, 500, 200, 100, 100, 2, 1, 2, '2020-03-07 12:01:18'),
(5, 'Node js developer', 10000, 60000, 1, 500, 1000, 500, 200, 200, 50, 2, 2, 2, '2020-03-08 13:18:24');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `schFrom` varchar(10) DEFAULT NULL,
  `schTo` varchar(10) DEFAULT NULL,
  `weekdaysId` int(11) DEFAULT NULL,
  `signIn` time DEFAULT NULL,
  `signOut` time DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `companiesId` int(11) NOT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `name`, `schFrom`, `schTo`, `weekdaysId`, `signIn`, `signOut`, `userId`, `companiesId`, `datetime`) VALUES
(1, 'summer', 'march', 'september', 3, '08:00:00', '08:00:00', 6, 2, '2020-03-01 01:19:21'),
(2, 'winter', 'october', 'february', 3, '10:00:00', '07:00:00', 6, 2, '2020-03-01 01:22:51'),
(3, 'summer', 'january', 'jully', 2, '10:00:00', '04:00:00', 5, 1, '2020-03-01 11:50:45'),
(4, 'developer', 'march', 'may', 4, '08:00:00', '04:00:00', 1, 2, '2020-03-01 16:53:00'),
(5, 'Autum', 'january', 'march', 5, '10:00:00', '05:00:00', 1, 2, '2020-03-07 12:04:01'),
(6, 'react', 'march', 'february', 1, '08:00:00', '08:30:00', 1, 2, '2020-03-08 13:38:47');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `mobile1` varchar(16) DEFAULT NULL,
  `mobile2` varchar(16) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fname`, `lname`, `username`, `password`, `mobile1`, `mobile2`, `email`, `address`, `gender`, `companyId`, `datetime`) VALUES
(1, 'basit', 'mir', 'basitmir', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '97979801752', '9797981752', 'xaid902@gmail.com', 'habbak', 1, 2, '0000-00-00 00:00:00'),
(2, 'shahid', 'mir', 'Shahidmir', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '1234567891', 'xaid902@gmail.com', 'habbak', 1, 2, '2020-02-28 01:50:10'),
(3, 'shoib', 'mir', 'shoibmir', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '1234567891', 'shoib902@gmail.com', 'habbak', 1, 2, '2020-02-28 01:51:10'),
(4, 'kubra', 'mir', 'kubramir', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '1234567891', 'kubra902@gmail.com', 'habbak', 2, 2, '2020-02-28 01:55:19'),
(5, 'imaad', 'sheikh', 'imaadSheikh', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '1234567894', 'imaadSheikh@gmail.com', 'habbak', 1, 1, '2020-02-28 01:58:47'),
(6, 'Showkat', 'nazir', 'ShowkatN', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '9797981752', 'Showkat@gmail.com', 'sopore', 1, 2, '2020-02-28 14:21:29'),
(7, 'zamin ', 'sheikh', 'zaminSheikh', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '9149988023', 'zamin@gmail.com', 'habbak srg', 1, 2, '2020-03-01 16:19:42'),
(8, 'Firdous', 'Ahmed', 'firdousahmed', '72a700264b2793b708ca1fd8dcea0111c74604b4a92e749c41838ec2eee19731c7e27988d3de915704a30313dc4a78d0cafa554b0251c66a90212ad1698303c8', '9797981752', '9797981752', 'firdous@gmail.com', 'hmt srinagar', 1, 2, '2020-03-07 11:54:09');

-- --------------------------------------------------------

--
-- Table structure for table `weekdays`
--

CREATE TABLE `weekdays` (
  `id` int(11) NOT NULL,
  `name` varchar(70) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `companiesId` int(11) DEFAULT NULL,
  `dateTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weekdays`
--

INSERT INTO `weekdays` (`id`, `name`, `userid`, `companiesId`, `dateTime`) VALUES
(1, 'monday,tuesday,thrusday', 1, 2, '2020-02-29 16:00:26'),
(2, 'monday,friday,saturday,sunday', 4, 1, '2020-02-29 17:42:46'),
(3, 'monday,tuesday,wednesday', 4, 2, '2020-02-29 18:26:22'),
(4, 'monday,wednesday,friday', 3, 2, '2020-03-01 16:40:07'),
(5, 'monday,tuesday,wednesday,thrusday,friday,saturday', 6, 2, '2020-03-07 12:02:18'),
(6, 'sunday,monday,tuesday', 1, 2, '2020-03-08 13:29:52'),
(7, 'sunday,monday', 1, 2, '2020-03-08 13:30:37');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indexes for table `attendence`
--
ALTER TABLE `attendence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empId` (`empId`),
  ADD KEY `SchId` (`SchId`),
  ADD KEY `companiesId` (`companiesId`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `salaryId` (`salaryId`),
  ADD KEY `scheduleId` (`scheduleId`),
  ADD KEY `roleId` (`roleId`),
  ADD KEY `companyId` (`companyId`);

--
-- Indexes for table `enquiry`
--
ALTER TABLE `enquiry`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issuesalary`
--
ALTER TABLE `issuesalary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empid` (`empid`),
  ADD KEY `attendenceId` (`attendenceId`),
  ADD KEY `companiesId` (`companiesId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `companyId` (`companyId`);

--
-- Indexes for table `salaries`
--
ALTER TABLE `salaries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `createdBy` (`createdBy`),
  ADD KEY `companiesId` (`companiesId`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `weekdaysId` (`weekdaysId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `companiesId` (`companiesId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `companyId` (`companyId`);

--
-- Indexes for table `weekdays`
--
ALTER TABLE `weekdays`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `companiesId` (`companiesId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `attendence`
--
ALTER TABLE `attendence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `enquiry`
--
ALTER TABLE `enquiry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `issuesalary`
--
ALTER TABLE `issuesalary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `salaries`
--
ALTER TABLE `salaries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `weekdays`
--
ALTER TABLE `weekdays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendence`
--
ALTER TABLE `attendence`
  ADD CONSTRAINT `attendence_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `attendence_ibfk_2` FOREIGN KEY (`SchId`) REFERENCES `schedule` (`id`),
  ADD CONSTRAINT `attendence_ibfk_3` FOREIGN KEY (`companiesId`) REFERENCES `company` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`salaryId`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`),
  ADD CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`);

--
-- Constraints for table `issuesalary`
--
ALTER TABLE `issuesalary`
  ADD CONSTRAINT `issuesalary_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `issuesalary_ibfk_2` FOREIGN KEY (`attendenceId`) REFERENCES `attendence` (`id`),
  ADD CONSTRAINT `issuesalary_ibfk_3` FOREIGN KEY (`companiesId`) REFERENCES `company` (`id`);

--
-- Constraints for table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `role_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`);

--
-- Constraints for table `salaries`
--
ALTER TABLE `salaries`
  ADD CONSTRAINT `salaries_ibfk_1` FOREIGN KEY (`createdBy`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `salaries_ibfk_2` FOREIGN KEY (`companiesId`) REFERENCES `company` (`id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`weekdaysId`) REFERENCES `weekdays` (`id`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `schedule_ibfk_3` FOREIGN KEY (`companiesId`) REFERENCES `company` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`);

--
-- Constraints for table `weekdays`
--
ALTER TABLE `weekdays`
  ADD CONSTRAINT `weekdays_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `weekdays_ibfk_2` FOREIGN KEY (`companiesId`) REFERENCES `company` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
