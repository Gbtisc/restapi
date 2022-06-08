CREATE SCHEMA `enterprise`;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_status` int NOT NULL DEFAULT '1',
  `creationDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userId_UNIQUE` (`user_id`),
  UNIQUE KEY `userName_UNIQUE` (`user_name`),
  UNIQUE KEY `userEmail_UNIQUE` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci