-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema skillcatch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema skillcatch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skillcatch` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema skillcatch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema skillcatch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skillcatch` DEFAULT CHARACTER SET latin1 ;
USE `skillcatch` ;

-- -----------------------------------------------------
-- Table `skillcatch`.`task_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`task_plan` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`task` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`task_plan_has_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`task_plan_has_task` (
  `task_plan_id` INT NOT NULL COMMENT '',
  `task_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`task_plan_id`, `task_id`)  COMMENT '',
  INDEX `fk_task_plan_has_task_task1_idx` (`task_id` ASC)  COMMENT '',
  INDEX `fk_task_plan_has_task_task_plan_idx` (`task_plan_id` ASC)  COMMENT '',
  CONSTRAINT `fk_task_plan_has_task_task_plan`
    FOREIGN KEY (`task_plan_id`)
    REFERENCES `skillcatch`.`task_plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_plan_has_task_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `skillcatch`.`task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`badge` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`badge_has_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`badge_has_task` (
  `badge_id` INT NOT NULL COMMENT '',
  `task_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`badge_id`, `task_id`)  COMMENT '',
  INDEX `fk_badge_has_task_task1_idx` (`task_id` ASC)  COMMENT '',
  INDEX `fk_badge_has_task_badge1_idx` (`badge_id` ASC)  COMMENT '',
  CONSTRAINT `fk_badge_has_task_badge1`
    FOREIGN KEY (`badge_id`)
    REFERENCES `skillcatch`.`badge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_badge_has_task_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `skillcatch`.`task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`project_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`project_group` (
  `id` INT(11) NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `descriptions` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `status` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillcatch`.`task_plan_has_project_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`task_plan_has_project_group` (
  `task_plan_id` INT NOT NULL COMMENT '',
  `project_group_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`task_plan_id`, `project_group_id`)  COMMENT '',
  INDEX `fk_task_plan_has_project_group_project_group1_idx` (`project_group_id` ASC)  COMMENT '',
  INDEX `fk_task_plan_has_project_group_task_plan1_idx` (`task_plan_id` ASC)  COMMENT '',
  CONSTRAINT `fk_task_plan_has_project_group_task_plan1`
    FOREIGN KEY (`task_plan_id`)
    REFERENCES `skillcatch`.`task_plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_plan_has_project_group_project_group1`
    FOREIGN KEY (`project_group_id`)
    REFERENCES `skillcatch`.`project_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skillcatch`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`role` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

USE `skillcatch` ;

-- -----------------------------------------------------
-- Table `skillcatch`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`user` (
  `id` INT(11) NOT NULL COMMENT '',
  `username` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `surname` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `email` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `password` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `phone` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `address` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillcatch`.`user_has_project_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`user_has_project_group` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `project_group_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`user_id`, `project_group_id`)  COMMENT '',
  INDEX `fk_user_has_project_group_project_group1_idx` (`project_group_id` ASC)  COMMENT '',
  INDEX `fk_user_has_project_group_user_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_user_has_project_group_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `skillcatch`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_project_group_project_group1`
    FOREIGN KEY (`project_group_id`)
    REFERENCES `skillcatch`.`project_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillcatch`.`user_has_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`user_has_task` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `task_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`user_id`, `task_id`)  COMMENT '',
  INDEX `fk_user_has_task_task1_idx` (`task_id` ASC)  COMMENT '',
  INDEX `fk_user_has_task_user1_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_user_has_task_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `skillcatch`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_task_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `skillcatch`.`task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `skillcatch`.`user_has_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skillcatch`.`user_has_role` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `role_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`user_id`, `role_id`)  COMMENT '',
  INDEX `fk_user_has_role_role1_idx` (`role_id` ASC)  COMMENT '',
  INDEX `fk_user_has_role_user1_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_user_has_role_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `skillcatch`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `skillcatch`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
