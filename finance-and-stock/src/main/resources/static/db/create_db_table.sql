CREATE DATABASE `financestockdb`;

USE `financestockdb`;
DROP TABLE `authorities`;
DROP TABLE `users`;

USE `financestockdb`;
CREATE TABLE `users`
(
    `user_id`           int          NOT NULL AUTO_INCREMENT,
    `name`              varchar(250) NOT NULL,
    `email`             varchar(100) NOT NULL,
    `mobile_number`     varchar(20)  NOT NULL,
    `document_number`   varchar(20)  NOT NULL,
    `password`          varchar(100)  NOT NULL,
    `role`              varchar(10)  NOT NULL,
    `registration_date` date DEFAULT NULL,
    PRIMARY KEY (`user_id`)
);

USE `financestockdb`;
CREATE TABLE `authorities`
(
    `id`      int         NOT NULL AUTO_INCREMENT,
    `user_id` int         NOT NULL,
    `name`    varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);
