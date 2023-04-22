-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sunbeamdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sunbeamdb` ;

-- -----------------------------------------------------
-- Schema sunbeamdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sunbeamdb` DEFAULT CHARACTER SET utf8 ;
USE `sunbeamdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `email` VARCHAR(60) NULL,
  `phone_number` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  `biography` TEXT NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `elder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `elder` ;

CREATE TABLE IF NOT EXISTS `elder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `height` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `access_code` VARCHAR(10) NULL,
  `elder_overview` TEXT NULL,
  `gender` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `biography` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appointment` ;

CREATE TABLE IF NOT EXISTS `appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL,
  `appointment_date` DATE NULL,
  `appointment_time` TIME NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `location_id` INT NULL,
  `elder_id` INT NOT NULL,
  `category_id` INT NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appointment_user_idx` (`user_id` ASC),
  INDEX `fk_appointment_location1_idx` (`location_id` ASC),
  INDEX `fk_appointment_client1_idx` (`elder_id` ASC),
  INDEX `fk_appointment_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_appointment_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reminder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reminder` ;

CREATE TABLE IF NOT EXISTS `reminder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reminder_date` DATE NULL,
  `reminder_time` TIME NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `appointment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reminder_appointment1_idx` (`appointment_id` ASC),
  CONSTRAINT `fk_reminder_appointment1`
    FOREIGN KEY (`appointment_id`)
    REFERENCES `appointment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medication` ;

CREATE TABLE IF NOT EXISTS `medication` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medication_name` VARCHAR(200) NULL,
  `health_condition` VARCHAR(50) NULL,
  `description` VARCHAR(500) NULL,
  `elder_id` INT NOT NULL,
  `dose` VARCHAR(45) NULL,
  `frequency` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medication_client1_idx` (`elder_id` ASC),
  CONSTRAINT `fk_medication_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `note` ;

CREATE TABLE IF NOT EXISTS `note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `flagged` TINYINT NULL,
  `create_date` DATE NULL,
  `user_id` INT NOT NULL,
  `elder_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_note_user1_idx` (`user_id` ASC),
  INDEX `fk_note_client1_idx` (`elder_id` ASC),
  CONSTRAINT `fk_note_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_note_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_reminder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_reminder` ;

CREATE TABLE IF NOT EXISTS `user_has_reminder` (
  `user_id` INT NOT NULL,
  `reminder_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `reminder_id`),
  INDEX `fk_user_has_reminder_reminder1_idx` (`reminder_id` ASC),
  INDEX `fk_user_has_reminder_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_reminder_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_reminder_reminder1`
    FOREIGN KEY (`reminder_id`)
    REFERENCES `reminder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `family_member` ;

CREATE TABLE IF NOT EXISTS `family_member` (
  `elder_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `relationship` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  `is_emergency_contact` TINYINT NULL,
  PRIMARY KEY (`elder_id`, `user_id`),
  INDEX `fk_client_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_client_has_user_client1_idx` (`elder_id` ASC),
  CONSTRAINT `fk_client_has_user_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caretaker_has_client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caretaker_has_client` ;

CREATE TABLE IF NOT EXISTS `caretaker_has_client` (
  `elder_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`elder_id`, `user_id`),
  INDEX `fk_client_has_user1_user1_idx` (`user_id` ASC),
  INDEX `fk_client_has_user1_client1_idx` (`elder_id` ASC),
  CONSTRAINT `fk_client_has_user1_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_user1_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `create_date` DATE NULL,
  `elder_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `reply_to_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_client1_idx` (`elder_id` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_comment_comment1_idx` (`reply_to_id` ASC),
  CONSTRAINT `fk_comment_client1`
    FOREIGN KEY (`elder_id`)
    REFERENCES `elder` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_comment1`
    FOREIGN KEY (`reply_to_id`)
    REFERENCES `comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

CREATE TABLE IF NOT EXISTS `message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL,
  `create_date` DATE NULL,
  `enabled` TINYINT NULL,
  `receiver_id` INT NOT NULL,
  `sender_id` INT NOT NULL,
  `is_read` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_user1_idx` (`receiver_id` ASC),
  INDEX `fk_message_user2_idx` (`sender_id` ASC),
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user2`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS sun@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'sun'@'localhost' IDENTIFIED BY 'beam';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'sun'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `phone_number`, `first_name`, `last_name`, `image_url`, `biography`, `create_date`, `update_date`) VALUES (1, 'admin', '$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS', 1, 'ADMIN', '@distillery.edu', '5553294455', 'SD', 'Dee', 'https://static.wikia.nocookie.net/telletubbies/images/5/5d/Pic-meet-char-po.jpg/revision/latest?cb=20200317005848', NULL, '2023-03-17', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `phone_number`, `first_name`, `last_name`, `image_url`, `biography`, `create_date`, `update_date`) VALUES (2, 'kstout', '$2a$10$leijdDDbJ2tNn4G1T2Cbo.yIztaaPEYGWS5UX2Cm9SN7VcfxugduO', 1, 'user', 'kstout@distillery.edu', '5555555555', 'Kira', 'Stout', 'https://static.wikia.nocookie.net/telletubbies/images/e/e5/Tinky_Winky.jpg/revision/latest?cb=20200317005814', NULL, '2023-03-18', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `phone_number`, `first_name`, `last_name`, `image_url`, `biography`, `create_date`, `update_date`) VALUES (3, 'user', '$2a$10$qCiN.i4V2GslC.XHGUTMg.CIQAxFAw2iJDL0UZ2tRsuum5b1Mt.9S', 1, 'user', 'stello@distillery.edu', '5555555556', 'Sebastian', 'Tello', 'https://static.wikia.nocookie.net/telletubbies/images/d/d0/Kids_tele_lala.jpg/revision/latest/scale-to-width-down/200?cb=20120225003505', NULL, '2023-03-18', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `phone_number`, `first_name`, `last_name`, `image_url`, `biography`, `create_date`, `update_date`) VALUES (4, 'family', '$2a$10$.8sk8P7Bt8xnEjqVIjT2F.RTZ6ZBy9uJ7IFmGymK5sjCQalNqv7eO', 1, 'user', 'dsurina@distillery.edu', '5555555557', 'Dominic', 'Surina', 'https://static.wikia.nocookie.net/telletubbies/images/3/35/Url.jpg/revision/latest/scale-to-width-down/200?cb=20200413020256', NULL, '2023-03-18', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `location` (`id`, `name`, `address`, `city`, `state`, `zipcode`) VALUES (1, 'St. Francis Cardiology', '123 Seasme St', 'Denver', 'CO', '80002');

COMMIT;


-- -----------------------------------------------------
-- Data for table `elder`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `elder` (`id`, `first_name`, `last_name`, `weight`, `height`, `birthdate`, `access_code`, `elder_overview`, `gender`, `create_date`, `last_update`, `image_url`, `biography`, `enabled`) VALUES (1, 'Bert', 'Johson', '180', '6', '1945-08-05', NULL, 'WW2 Veteran. ', 'Male', '2023-03-18', NULL, 'https://static.wikia.nocookie.net/telletubbies/images/d/d4/Sun_Baby_Intro.PNG/revision/latest/scale-to-width-down/220?cb=20200319185815', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `category` (`id`, `name`, `description`) VALUES (1, 'Doctor', 'Medical Appointment');

COMMIT;


-- -----------------------------------------------------
-- Data for table `appointment`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `appointment` (`id`, `description`, `appointment_date`, `appointment_time`, `user_id`, `title`, `location_id`, `elder_id`, `category_id`, `create_date`, `update_date`) VALUES (1, 'Cardiologist appt. with Dr.Rob', '2023-03-23', '1700', 2, 'Get Bert to Cardiologist', 1, 1, 1, '2023-03-17', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `reminder`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `reminder` (`id`, `reminder_date`, `reminder_time`, `title`, `description`, `appointment_id`) VALUES (1, '2023-03-23', '1600', 'Cardiologist', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `medication`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `medication` (`id`, `medication_name`, `health_condition`, `description`, `elder_id`, `dose`, `frequency`) VALUES (1, 'Benazepril (Lotensin)', 'Heart murmurs', 'He has had a few heart attacks and is on a diet regmine for heart health', 1, '50mg', '2 times a day');

COMMIT;


-- -----------------------------------------------------
-- Data for table `note`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `note` (`id`, `title`, `description`, `flagged`, `create_date`, `user_id`, `elder_id`) VALUES (1, 'Pain Issues', 'He told me he had some pain in his chest.', NULL, '2023-03-17', 3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `family_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `family_member` (`elder_id`, `user_id`, `relationship`, `enabled`, `is_emergency_contact`) VALUES (1, 3, 'Grandson', 1, 1);
INSERT INTO `family_member` (`elder_id`, `user_id`, `relationship`, `enabled`, `is_emergency_contact`) VALUES (1, 4, 'Nephew', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `caretaker_has_client`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `caretaker_has_client` (`elder_id`, `user_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `comment` (`id`, `title`, `description`, `create_date`, `elder_id`, `user_id`, `reply_to_id`) VALUES (1, 'Family Reunion', 'Hey everyone, just a reminder that the family reunion is coming up and we would like to have Bert there! Let\'s see if we can schedule something on here.', '2023-03-17', 1, 3, NULL);
INSERT INTO `comment` (`id`, `title`, `description`, `create_date`, `elder_id`, `user_id`, `reply_to_id`) VALUES (2, NULL, 'I can get him there!', '2023-03-17', 1, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `message`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunbeamdb`;
INSERT INTO `message` (`id`, `description`, `create_date`, `enabled`, `receiver_id`, `sender_id`, `is_read`) VALUES (1, 'Hey, how is he today?', '2023-03-17', 1, 3, 2, NULL);

COMMIT;

