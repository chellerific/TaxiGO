SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `taxigo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `taxigo` ;

-- -----------------------------------------------------
-- Table `taxigo`.`clientinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taxigo`.`clientinfo` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `reported` TINYINT(1) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taxigo`.`taxiinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taxigo`.`taxiinfo` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taxigo`.`bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taxigo`.`bookings` (
  `companyname` VARCHAR(20) NOT NULL,
  `customer` VARCHAR(20) NOT NULL,
  `origin` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `bookingid` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bookingid`),
  INDEX `customer_idx` (`customer` ASC),
  INDEX `companyname_idx` (`companyname` ASC),
  CONSTRAINT `customer`
    FOREIGN KEY (`customer`)
    REFERENCES `taxigo`.`clientinfo` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `companyname`
    FOREIGN KEY (`companyname`)
    REFERENCES `taxigo`.`taxiinfo` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taxigo`.`admininfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taxigo`.`admininfo` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taxigo`.`taxioperator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taxigo`.`taxioperator` (
  `operator` VARCHAR(20) NOT NULL,
  `baserate` DOUBLE NOT NULL,
  `priceperkm` DOUBLE NOT NULL,
  `weekendfee` DOUBLE NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`operator`),
  CONSTRAINT `operator`
    FOREIGN KEY (`operator`)
    REFERENCES `taxigo`.`taxiinfo` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
