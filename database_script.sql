-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema laboratory
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema laboratory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `laboratory` DEFAULT CHARACTER SET utf8 ;
USE `laboratory` ;

-- -----------------------------------------------------
-- Table `laboratory`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`patient` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `dob` VARCHAR(45) NULL,
  `nic` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratory`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`doctor` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `specialization` VARCHAR(45) NULL,
  `available_days` VARCHAR(45) NULL,
  `available_time` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`doctor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratory`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`appointment` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `doctor_id` INT NULL,
  `appointment_date` VARCHAR(45) NULL,
  `appointment_time` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`appointment_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratory`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`report` (
  `report_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `type` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `description` VARCHAR(1000) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`report_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratory`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `appointment_id` INT NULL,
  `amount` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`payment_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `laboratory`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratory`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
