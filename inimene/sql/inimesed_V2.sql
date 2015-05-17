-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.41-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for name
CREATE DATABASE IF NOT EXISTS `name` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `name`;


-- Dumping structure for table name.inimesed_v2
CREATE TABLE IF NOT EXISTS `inimesed_v2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inimene_number` int(3) NOT NULL,
  `inimene_name1` varchar(30) NOT NULL,
  `inimene_name2` varchar(30) NOT NULL,
  `inimene_bday` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Tabel inimeste andmetega.';

-- Dumping data for table name.inimesed_v2: ~4 rows (approximately)
DELETE FROM `inimesed_v2`;
/*!40000 ALTER TABLE `inimesed_v2` DISABLE KEYS */;
INSERT INTO `inimesed_v2` (`id`, `inimene_number`, `inimene_name1`, `inimene_name2`, `inimene_bday`) VALUES
	(1, 1, 'Andres', 'Oks', '1956-11-27'),
	(2, 2, 'Liis', 'Rruby', '1968-03-17'),
	(3, 3, 'Huugo', 'Sool', '1983-05-18'),
	(5, 5, 'Jaanek', 'Piks', '1975-09-19');
/*!40000 ALTER TABLE `inimesed_v2` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
