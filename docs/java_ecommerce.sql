-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2023 at 05:32 PM
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
-- Database: `java_ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `ID` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `CartID` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `Title` varchar(256) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  `Price` double NOT NULL,
  `Brand` varchar(256) NOT NULL,
  `Image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `Title`, `Description`, `Price`, `Brand`, `Image`) VALUES
(1, 'Air Jordan 1 Mid SE', 'Every time the AJ1 gets a remake, you get the classic sneaker in new colours and textures for an exciting, revamped look but with all the familiar comforts you know. Premium materials and accents give modern expression to an all-time favourite.', 1000, 'Nike', '/img/pro1.webp'),
(2, 'Air Jordan Legacy 312 Low', 'The Air Jordan Legacy 312 Low celebrates Michael Jordan\'s legacy with this shout-out to Chicago\'s 312 area code. The design creates a modern mash-up of iconic Jordan elements.', 2000, 'Nike', '/img/pro2.webp'),
(3, 'Air Jordan XXXVII Low PF', 'You\'ve got the hops and the speed—lace up in shoes that enhance what you bring to the court. The latest AJ is all about take-offs and landings, with multiple Air units to help get you off the ground and Formula 23 foam to ease your impact. The upper is made from strong, reinforced leno-weave fabric that\'ll help keep you contained no matter how fast you move—and leave your game uncompromised.', 2500, 'Nike', '/img/pro3.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrderID`,`ProductID`,`CartID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
