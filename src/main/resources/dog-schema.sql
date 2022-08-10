DROP TABLE IF EXISTS `dog` CASCADE;

CREATE TABLE `dog` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255),
	`breed` VARCHAR(255),
	`cost` DOUBLE NOT NULL
);