-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2018 at 10:53 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newsoft`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `balcit` ()  begin
declare finish int default 0;

declare t1ype varchar(30);

declare emailcur cursor for select id from balancesheet;

declare continue handler for not found set finish=1;

open emailcur;

while finish=0 do
fetch emailcur into t1ype;
insert into trainamt (id) values (t1ype);

end while;
close emailcur;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `readit` ()  begin
declare finish int default 0;

declare t1ype varchar(30);
declare t2ype varchar(40);
declare g varchar(10);
declare emailcur cursor for select id, name,gender from pilgrim;

declare continue handler for not found set finish=1;

open emailcur;

while finish=0 do
fetch emailcur into t1ype,t2ype,g;
insert into train (id,name,gender) values (t1ype,t2ype,g);

end while;
close emailcur;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `balancesheet`
--

CREATE TABLE `balancesheet` (
  `id` varchar(20) NOT NULL,
  `name` varchar(80) NOT NULL,
  `persons` int(11) NOT NULL,
  `adultnon` int(11) NOT NULL,
  `scmnon` int(11) NOT NULL,
  `scfnon` int(11) NOT NULL,
  `childnon` int(11) NOT NULL,
  `adultac` int(11) NOT NULL,
  `scmac` int(11) NOT NULL,
  `scfac` int(11) NOT NULL,
  `childac` int(11) NOT NULL,
  `paid` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `balancesheet`
--

INSERT INTO `balancesheet` (`id`, `name`, `persons`, `adultnon`, `scmnon`, `scfnon`, `childnon`, `adultac`, `scmac`, `scfac`, `childac`, `paid`, `balance`, `total`) VALUES
('dpr2017Vand', 'Vandana Agnihotri', 1, 1, 0, 0, 0, 0, 0, 0, 0, 10750, 0, 10750),
('dpr2017Prad', 'Pradeep Kumar Gupta', 6, 5, 1, 0, 0, 0, 0, 0, 0, 70000, 29950, 99950),
('dpr2017Ashi', 'Ashish Kumar Agarwal', 2, 2, 0, 0, 0, 0, 0, 0, 0, 31700, 0, 31700),
('dpr2017Viml', 'Vimla Jaiswal', 2, 0, 1, 1, 0, 0, 0, 0, 0, 19400, 0, 19400),
('dpr2017Rajv', 'Rajveer Singh', 2, 0, 1, 1, 0, 0, 0, 0, 0, 19400, 0, 19400),
('dpr2017Mith', 'Mithlesh Shukla', 2, 1, 0, 1, 0, 0, 0, 0, 0, 20300, 0, 20300),
('dpr2017Prab', 'Prabhuta Shukla', 5, 4, 0, 1, 0, 0, 0, 0, 0, 52550, 0, 52550),
('dpr2017Memb', 'Member Lal', 6, 5, 0, 1, 0, 0, 0, 0, 0, 63300, 0, 63300),
('dpr2017Ramg', 'Ramgopal', 1, 0, 1, 0, 0, 0, 0, 0, 0, 9850, 0, 9850),
('dpr2017Daya', 'Daya Ram', 4, 2, 1, 0, 1, 0, 0, 0, 0, 34350, 0, 34350),
('dpr2017Ravi', 'Ravindranath Tagore', 2, 2, 0, 0, 0, 0, 0, 0, 0, 40780, 0, 40780),
('dpr2017Kaml', 'Kamla Devi', 1, 0, 0, 1, 0, 0, 0, 0, 0, 7500, 2050, 9550),
('dpr2017Bitt', 'Bitto Devi Pathak', 1, 0, 0, 1, 0, 0, 0, 0, 0, 9550, 0, 9550),
('dpr2017Meer', 'Meera Verma', 1, 1, 0, 0, 0, 0, 0, 0, 0, 10750, 0, 10750),
('dpr2017Hari', 'Harish Ch Pandey', 1, 1, 0, 0, 0, 0, 0, 0, 0, 20390, 0, 20390),
('dpr2017Juge', 'Jugesh Gujral', 4, 2, 0, 2, 0, 0, 0, 0, 0, 31300, 33400, 64700),
('dpr2017Vija', 'Vijay Veer Sharan', 2, 0, 1, 1, 0, 0, 0, 0, 0, 19400, 0, 19400),
('dpr2017Shsh', 'Shshibala', 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 30150, 30150),
('dpr2017Rani', 'Rani Nirmala', 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9550, 9550),
('dpr2017Maik', 'Maikulal', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 10750, 10750);

--
-- Triggers `balancesheet`
--
DELIMITER $$
CREATE TRIGGER `after_update` BEFORE UPDATE ON `balancesheet` FOR EACH ROW BEGIN

set new.persons=old.persons+new.persons;
set new.adultnon=old.adultnon+new.adultnon;
set new.scmnon=old.scmnon+new.scmnon;
set new.scfnon=old.scfnon+new.scfnon;
set new.childnon=old.childnon+new.childnon;

set new.adultac=old.adultac+new.adultac;
set new.scmac=old.scmac+new.scmac;
set new.scfac=old.scfac+new.scfac;
set new.childac=old.childac+new.childac;

set new.paid=old.paid+new.paid;
set new.balance=old.balance+new.balance;
set new.total=old.total+new.total;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `expense`
--

CREATE TABLE `expense` (
  `remark` varchar(200) NOT NULL,
  `value` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expense`
--

INSERT INTO `expense` (`remark`, `value`) VALUES
('Train', 0),
('BeMathBus', 12300),
('G1TPTYFood', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `fare`
--

CREATE TABLE `fare` (
  `adult` int(11) NOT NULL,
  `yid` varchar(60) NOT NULL,
  `package` varchar(60) NOT NULL,
  `scm` int(11) NOT NULL,
  `scf` int(11) NOT NULL,
  `child` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fare`
--

INSERT INTO `fare` (`adult`, `yid`, `package`, `scm`, `scf`, `child`) VALUES
(13800, 'dpy2017', 'AC', 11500, 10950, 13200),
(9100, 'dpy2017', 'NONAC', 8250, 8050, 8200),
(10750, 'dpr2017', 'P1NONAC', 9850, 9550, 3000),
(16800, 'dpr2017', 'P2AC', 15950, 15550, 0),
(20390, 'dpr2017', 'P3AC', 18020, 17115, 0),
(18720, 'dpr2017', 'P4AC', 16850, 15535, 0),
(15850, 'dpr2017', 'P5AC', 15050, 14750, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fareac`
--

CREATE TABLE `fareac` (
  `adult` int(11) NOT NULL,
  `scm` int(11) NOT NULL,
  `scf` int(11) NOT NULL,
  `child` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `farenonac`
--

CREATE TABLE `farenonac` (
  `adult` int(11) NOT NULL,
  `scm` int(11) NOT NULL,
  `scf` int(11) NOT NULL,
  `child` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pilgrim`
--

CREATE TABLE `pilgrim` (
  `id` varchar(20) NOT NULL,
  `name` varchar(80) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `ac` varchar(60) NOT NULL,
  `dob` int(11) DEFAULT NULL,
  `charge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pilgrim`
--

INSERT INTO `pilgrim` (`id`, `name`, `age`, `gender`, `phone`, `ac`, `dob`, `charge`) VALUES
('dpr2017Vand', 'Vandana Agnihotri', 46, 'A', 'null', 'P1NONAC', 6011971, 10750),
('dpr2017Prad', 'Pradeep Kumar Gupta', 38, 'A', 'null', 'P2AC', 0, 16800),
('dpr2017Prad', 'Updesh Gupta', 33, 'A', '9411918596', 'P2AC', 0, 16800),
('dpr2017Prad', 'Anguri Devi', 52, 'A', 'null', 'P2AC', 0, 16800),
('dpr2017Prad', 'Shikha Gupta', 21, 'A', 'null', 'P2AC', 0, 16800),
('dpr2017Prad', 'Pooja Gupta', 30, 'A', 'null', 'P2AC', 0, 16800),
('dpr2017Prad', 'Tikaram Gupta', 61, 'SCM', 'null', 'P2AC', 25071955, 15950),
('dpr2017Ashi', 'Ashish Kumar Agarwal', 51, 'A', '9458683636', 'P5AC', 0, 15850),
('dpr2017Ashi', 'Shikhar Rani', 48, 'A', '8307007997', 'P5AC', 0, 15850),
('dpr2017Viml', 'Vimla Jaiswal', 60, 'SCF', '9927361822, 8868965069', 'P1NONAC', 8071956, 9550),
('dpr2017Viml', 'Suresh Ch Jaiswal', 65, 'SCM', '9411005928', 'P1NONAC', 15101951, 9850),
('dpr2017Rajv', 'Rajveer Singh', 61, 'SCM', '9528531002', 'P1NONAC', 0, 9850),
('dpr2017Rajv', 'Sunita Devi', 60, 'SCF', 'null', 'P1NONAC', 0, 9550),
('dpr2017Mith', 'Mithlesh Shukla', 61, 'SCF', 'null', 'P1NONAC', 25071955, 9550),
('dpr2017Mith', 'Suman Shukla', 52, 'A', 'null', 'P1NONAC', 10021965, 10750),
('dpr2017Prab', 'Prabhuta Shukla', 57, 'A', '8869826076', 'P1NONAC', 0, 10750),
('dpr2017Prab', 'Sudha Shukla', 51, 'A', 'null', 'P1NONAC', 20121965, 10750),
('dpr2017Prab', 'Arti Pandey', 55, 'A', 'null', 'P1NONAC', 1011962, 10750),
('dpr2017Prab', 'Sangeeta Shukla', 42, 'A', 'null', 'P1NONAC', 25061974, 10750),
('dpr2017Prab', 'Kamlesh Srivastva', 58, 'SCF', 'null', 'P1NONAC', 2011959, 9550),
('dpr2017Memb', 'Member Lal', 59, 'A', '8273234908', 'P1NONAC', 0, 10750),
('dpr2017Memb', 'Anand Kishore', 47, 'A', '8533945494', 'P1NONAC', 0, 10750),
('dpr2017Memb', 'Bhagwandevi', 58, 'SCF', 'null', 'P1NONAC', 0, 9550),
('dpr2017Memb', 'Guddo', 45, 'A', 'null', 'P1NONAC', 0, 10750),
('dpr2017Memb', 'Rajeswar', 53, 'A', '9411424250', 'P1NONAC', 0, 10750),
('dpr2017Memb', 'Urmilla Gupta', 50, 'A', '', 'P1NONAC', 0, 10750),
('dpr2017Ramg', 'Ramgopal', 66, 'SCM', '9634443408', 'P1NONAC', 17091950, 9850),
('dpr2017Daya', 'Daya Ram', 63, 'SCM', '7500755568', 'P1NONAC', 0, 9850),
('dpr2017Daya', 'Ramu Gupta', 40, 'A', 'null', 'P1NONAC', 0, 10750),
('dpr2017Daya', 'Seema Gupta', 35, 'A', 'null', 'P1NONAC', 0, 10750),
('dpr2017Daya', 'Neel', 8, 'child', 'null', 'P1NONAC', 0, 3000),
('dpr2017Ravi', 'Ravindranath Tagore', 53, 'A', '8123711818', 'P3AC', 0, 20390),
('dpr2017Ravi', 'Harnaryan Saxena', 33, 'A', '9259077504', 'P3AC', 0, 20390),
('dpr2017Kaml', 'Kamla Devi', 64, 'SCF', 'null', 'P1NONAC', 0, 9550),
('dpr2017Bitt', 'Bitto Devi Pathak', 65, 'SCF', 'null', 'P1NONAC', 1011952, 9550),
('dpr2017Meer', 'Meera Verma', 55, 'A', 'null', 'P1NONAC', 0, 10750),
('dpr2017Hari', 'Harish Ch Pandey', 52, 'A', '7895260377', 'P3AC', 1011965, 20390),
('dpr2017Juge', 'Jugesh Gujral', 51, 'A', '9267335116', 'P2AC', 0, 16800),
('dpr2017Juge', 'Sangeeta Gujral', 45, 'A', 'null', 'P2AC', 0, 16800),
('dpr2017Juge', 'Krishna Kumari', 68, 'SCF', 'null', 'P2AC', 0, 15550),
('dpr2017Juge', 'Indra Arora', 60, 'SCF', '', 'P2AC', 0, 15550),
('dpr2017Vija', 'Vijay Veer Sharan', 63, 'SCM', '9528150504', 'P1NONAC', 1011954, 9850),
('dpr2017Vija', 'Rita Agarwal', 58, 'SCF', '7895059901', 'P1NONAC', 1011959, 9550),
('dpr2017Shsh', 'Shshibala', 65, 'SCF', '9837600361', 'P1NONAC', 0, 9550),
('dpr2017Shsh', 'Roop', 65, 'SCM', 'null', 'P1NONAC', 0, 9850),
('dpr2017Shsh', 'Amit Agarwal', 30, 'A', 'null', 'P1NONAC', 0, 10750),
('dpr2017Rani', 'Rani Nirmala', 65, 'SCF', 'null', 'P1NONAC', 0, 9550),
('dpr2017Maik', 'Maikulal', 58, 'A', '8193838860, 8218942872', 'P1NONAC', 0, 10750);

--
-- Triggers `pilgrim`
--
DELIMITER $$
CREATE TRIGGER `after_insert` AFTER INSERT ON `pilgrim` FOR EACH ROW begin

insert into train (id,name,gender) values (new.id,new.name,new.gender);

end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE `train` (
  `id` varchar(30) NOT NULL,
  `name` varchar(40) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `train1` varchar(6) NOT NULL DEFAULT '00000',
  `train2` varchar(6) NOT NULL DEFAULT '00000',
  `train3` varchar(6) NOT NULL DEFAULT '00000',
  `train4` varchar(6) NOT NULL DEFAULT '00000',
  `tirupati` varchar(100) NOT NULL DEFAULT '0',
  `rameswaram` varchar(200) NOT NULL DEFAULT '0',
  `kanyakumari` varchar(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`id`, `name`, `gender`, `train1`, `train2`, `train3`, `train4`, `tirupati`, `rameswaram`, `kanyakumari`) VALUES
('dpr2017Vand', 'Vandana Agnihotri', 'A', 'S0405', 'S0656', 'S0607', 'S0251', 'D8D', '0', '0'),
('dpr2017Prad', 'Pradeep Kumar Gupta', 'A', 'B0221', 'B0159', 'B0226', 'B0002', 'D10A', '0', '0'),
('dpr2017Prad', 'Updesh Gupta', 'A', 'B0222', 'B0161', 'B0227', 'B0003', 'D10B', '0', '0'),
('dpr2017Prad', 'Anguri Devi', 'A', 'B0220', 'B0160', 'B0225', 'B0001', 'D10C', '0', '0'),
('dpr2017Prad', 'Shikha Gupta', 'A', 'B0223', 'B0162', 'B0229', 'B0005', 'D10D', '0', '0'),
('dpr2017Prad', 'Pooja Gupta', 'A', 'B0224', 'B0336', 'B0230', 'B0006', 'DOUBLE2', '0', '0'),
('dpr2017Prad', 'Tikaram Gupta', 'SCM', 'B0109', 'B0339', 'B0228', 'B0004', 'DDOUBLE2', '0', '0'),
('dpr2017Ashi', 'Ashish Kumar Agarwal', 'A', 'B0226', 'S0602', 'B0234', 'B0554', 'DDOUBLE6', '0', '0'),
('dpr2017Ashi', 'Shikhar Rani', 'A', 'B0231', 'S0603', 'B0239', 'B0556', 'DOUBLE6', '0', '0'),
('dpr2017Viml', 'Vimla Jaiswal', 'SCF', 'S0450', 'S0605', 'S0709', 'S1335', 'DDOUBLE7', '0', '0'),
('dpr2017Viml', 'Suresh Ch Jaiswal', 'SCM', 'S0449', 'S0601', 'S0710', 'S1337', 'DOUBLE7', '0', '0'),
('dpr2017Rajv', 'Rajveer Singh', 'SCM', 'S0453', 'S0604', 'S0713', 'S1008', 'DOUBLE6', '0', '0'),
('dpr2017Rajv', 'Sunita Devi', 'SCF', 'S0454', 'S0607', 'S0714', 'S1770', 'DOUBLE7', '0', '0'),
('dpr2017Mith', 'Mithlesh Shukla', 'SCF', 'S0452', 'S0617', 'S0711', 'S1338', 'DDOUBLE4', '0', '0'),
('dpr2017Mith', 'Suman Shukla', 'A', 'S0451', 'S0618', 'S0712', 'S1006', 'DOUBLE4', '0', '0'),
('dpr2017Prab', 'Prabhuta Shukla', 'A', 'S0471', 'S0620', 'S0715', 'S0337', 'DDOUBLE5', '0', '0'),
('dpr2017Prab', 'Sudha Shukla', 'A', 'S0466', 'S0619', 'S0716', 'S0338', 'DOUBLE5', '0', '0'),
('dpr2017Prab', 'Arti Pandey', 'A', 'S0467', 'S0622', 'S0701', 'S0440', 'DOUBLE5', '0', '0'),
('dpr2017Prab', 'Sangeeta Shukla', 'A', 'S0469', 'S0621', 'S0702', 'S0551', 'DOUBLE4', '0', '0'),
('dpr2017Prab', 'Kamlesh Srivastva', 'SCF', 'S0465', 'S0702', 'S0703', 'S0554', 'DDOUBLE3', '0', '0'),
('dpr2017Memb', 'Member Lal', 'A', 'S0458', 'S0666', 'S0610', 'S0003', 'D9B', '0', '0'),
('dpr2017Memb', 'Anand Kishore', 'A', 'S0459', 'S0671', 'S0611', 'S0008', 'D9D', '0', '0'),
('dpr2017Memb', 'Bhagwandevi', 'SCF', 'S0457', 'S0665', 'S0609', 'S0006', 'D9C', '0', '0'),
('dpr2017Memb', 'Guddo', 'A', 'S0461', 'S0667', 'S0615', 'S0772', 'D9E', '0', '0'),
('dpr2017Memb', 'Rajeswar', 'A', 'S0462', 'S0669', 'S0613', 'S0448', 'D9F', '0', '0'),
('dpr2017Memb', 'Urmilla Gupta', 'A', 'S0404', 'S0672', 'S0604', 'S0244', 'D8E', '0', '0'),
('dpr2017Ramg', 'Ramgopal', 'SCM', 'S0468', 'S0701', 'S0705', 'S0556', 'DOUBLE3', '0', '0'),
('dpr2017Daya', 'Daya Ram', 'SCM', 'S0401', 'S0651', 'S0601', 'S0557', 'D8A', '0', '0'),
('dpr2017Daya', 'Ramu Gupta', 'A', 'S0402', 'S0653', 'S0602', 'RC400', 'D8B', '0', '0'),
('dpr2017Daya', 'Seema Gupta', 'A', 'S0403', 'S0654', 'S0603', 'S0660', 'D8C', '0', '0'),
('dpr2017Daya', 'Neel', 'child', 'S04N0', 'S06NO', 'S06NO', 'RANNO', '0', '0', '0'),
('dpr2017Ravi', 'Ravindranath Tagore', 'A', 'A0109', 'A0141', 'B0131', 'A0445', 'D10E', '0', '0'),
('dpr2017Ravi', 'Harnaryan Saxena', 'A', 'A0110', 'A0142', 'B0132', 'A0446', 'D10F', '0', '0'),
('dpr2017Kaml', 'Kamla Devi', 'SCF', 'S0436', 'S0704', 'S0706', 'S0336', 'DOUBLE3', '0', '0'),
('dpr2017Bitt', 'Bitto Devi Pathak', 'SCF', 'S0433', 'S0668', 'S0704', 'S0333', '0', '0', '0'),
('dpr2017Meer', 'Meera Verma', 'A', 'S0460', 'S0703', 'S0612', 'S0556', 'DOUBLE3', '0', '0'),
('dpr2017Hari', 'Harish Ch Pandey', 'A', 'A0116', 'AWL01', 'B0160', 'A0443', '0', '0', '0'),
('dpr2017Juge', 'Jugesh Gujral', 'A', 'B0225', 'B0233', 'B0233', 'B0551', 'D8F', '0', '0'),
('dpr2017Juge', 'Sangeeta Gujral', 'A', 'B0227', 'B0236', 'B0235', 'B0553', 'D9A', '0', '0'),
('dpr2017Juge', 'Krishna Kumari', 'SCF', 'B0228', 'B0241', 'B0236', 'B0552', 'DDOUBLE1', '0', '0'),
('dpr2017Juge', 'Indra Arora', 'SCF', 'B0112', 'S0125', 'B0157', 'B0441', 'DDOUBLE8', '0', '0'),
('dpr2017Vija', 'Vijay Veer Sharan', 'SCM', 'S0767', 'S0541', 'S0462', 'S0141', '0', '0', '0'),
('dpr2017Vija', 'Rita Agarwal', 'SCF', 'S0771', 'S0544', 'S0464', 'S0144', '0', '0', '0'),
('dpr2017Shsh', 'Shshibala', 'SCF', 'S1271', 'S0549', '00000', 'S0149', '0', '0', '0'),
('dpr2017Shsh', 'Roop', 'SCM', 'S1266', 'S0552', '00000', 'S0152', '0', '0', '0'),
('dpr2017Shsh', 'Amit Agarwal', 'A', 'S1267', 'W3300', '00000', 'W7900', '0', '0', '0'),
('dpr2017Rani', 'Rani Nirmala', 'SCF', 'S0770', 'S0633', 'S0448', 'S0233', '0', '0', '0'),
('dpr2017Maik', 'Maikulal', 'A', 'S0769', 'S0636', 'S0448', 'S0236', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `trainamt`
--

CREATE TABLE `trainamt` (
  `id` varchar(30) NOT NULL,
  `train1` int(11) NOT NULL DEFAULT '0',
  `train2` int(11) NOT NULL DEFAULT '0',
  `train3` int(11) NOT NULL DEFAULT '0',
  `train4` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
