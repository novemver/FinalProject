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
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `height` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `access_code` VARCHAR(10) NULL,
  `client_overview` TEXT NULL,
  `gender` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `biography` VARCHAR(45) NULL,
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
  `client_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appointment_user_idx` (`user_id` ASC),
  INDEX `fk_appointment_location1_idx` (`location_id` ASC),
  INDEX `fk_appointment_client1_idx` (`client_id` ASC),
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
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
  `medication` VARCHAR(200) NULL,
  `health_condition` VARCHAR(50) NULL,
  `description` VARCHAR(500) NULL,
  `client_id` INT NOT NULL,
  `dose` VARCHAR(45) NULL,
  `frequency` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medication_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_medication_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_note_user1_idx` (`user_id` ASC),
  INDEX `fk_note_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_note_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_note_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
-- Table `emergency_contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emergency_contact` ;

CREATE TABLE IF NOT EXISTS `emergency_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `client_id` INT NOT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`, `client_id`),
  INDEX `fk_emergency_contact_client1_idx` (`client_id` ASC),
  INDEX `fk_emergency_contact_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_emergency_contact_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emergency_contact_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `family_member` ;

CREATE TABLE IF NOT EXISTS `family_member` (
  `client_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `relationship` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`client_id`, `user_id`),
  INDEX `fk_client_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_client_has_user_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_client_has_user_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
  `client_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`client_id`, `user_id`),
  INDEX `fk_client_has_user1_user1_idx` (`user_id` ASC),
  INDEX `fk_client_has_user1_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_client_has_user1_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
  `client_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `reply_to_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_client1_idx` (`client_id` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_comment_comment1_idx` (`reply_to_id` ASC),
  CONSTRAINT `fk_comment_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
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
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`, `phone_number`, `first_name`, `last_name`, `image_url`, `biography`, `create_date`, `update_date`) VALUES (1, 'admin', '$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS', 1, 'ADMIN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;

