CREATE TABLE `Person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `Patronymic` varchar(255) NOT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Postcode` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  `House` int(11) DEFAULT NULL,
  `Apartment` int(11) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Login` varchar(255) NOT NULL,
  `Passwordd` varchar(255) NOT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Userpic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5398 DEFAULT CHARSET=utf8;
