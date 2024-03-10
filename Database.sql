CREATE Database 'booksDB';
use 'booksDB'; 

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) NOT NULL,
  `bookAuthor` varchar(255) NOT NULL,
  `bookGenre` varchar(255) NOT NULL,
  `bookYear` int NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `books` WRITE;
INSERT INTO `books` (`bookId`, `bookName`, `bookAuthor`, `bookGenre`, `bookYear`) VALUES (1,'Echoes of Eternity','Aurora Montgomery','Fiction',2024),(2,'Whispers in the Wind','Benjamin Hayes','Novel',2023),(3,'The Midnight Serenade','Yvette Johnson','Novel',2024),(4,'Shadows of Solitude','Damien Blackwood','Fiction',2024),(5,'Dreams of the Forgotten','Eliza Rivers','Thriller',2021),(6,'The Enigma of Echo Lake','Felix Thompson','Non-Fiction',2021),(7,'Chronicles of the Celestial Sphere','Gabrielle Martinez','Science Fiction',2024),(8,'Lost in Luminescence','Harrison Clarke','Fiction',2024),(9,'Beyond the Veil of Time','Isabelle Bennett','Crime',2024),(10,'Songs of the Siren','Jonah Anderson','Crime',2023),(11,'The Forgotten Kingdom','Aurora Montgomery','Crime',2023),(12,'Echoes from the Abyss','Aurora Montgomery','Mystery',2023),(13,'The Serpent\'s Song','Marissa Sullivan','Crime',2023),(14,'Whispers of the Moon','Nathanial Parker','Mystery',2024),(15,'The Illusionist\'s Apprentice','Olivia Adams','History',2024),(16,'Tales from the Forgotten Realm','Patrick Gallagher','History',2024),(17,'Secrets of the Starlight Chamber','Quinn Roberts','Mystery',2021),(18,'The Enchanted Labyrinth','Rebecca Nelson','Fiction',2024),(19,'Echoes of the Eternal Forest','Sebastian Ramirez','Mystery',2024),(20,'The Celestial Codex','Damien Blackwood','History',2024),(21,'Whispers of the Winter Woods','Damien Blackwood','History',2023),(22,'The Alchemist\'s Daughter','Damien Blackwood','Fiction',2023),(23,'Chronicles of the Crimson Kingdom','Xander Morgan','Mystery',2021),(24,'The Oracle\'s Prophecy','Yvette Johnson','Crime',2021),(25,'Echoes of the Fallen','Gabrielle Martinez','Fiction',2021),(36,'europa','tester','FIction',2033);
UNLOCK TABLES;
