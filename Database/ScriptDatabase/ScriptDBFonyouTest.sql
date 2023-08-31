
-- -----------------------------------------------------
-- Schema test_fonyou
-- -----------------------------------------------------
GRANT ALL PRIVILEGES ON test_fonyou.* TO 'test_fonyou'@'localhost';

DROP SCHEMA IF EXISTS `test_fonyou`;
CREATE SCHEMA IF NOT EXISTS `test_fonyou` DEFAULT CHARACTER SET utf8 ;
USE `test_fonyou` ;

-- -----------------------------------------------------
-- Table `test_fonyou`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`exam` (
  `id_exam` INT NOT NULL AUTO_INCREMENT,
  `exam_name` VARCHAR(300) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT "ACTIVE",
  `user` VARCHAR(45) NOT NULL,
  `version` VARCHAR(45) NOT NULL,
  `creation` DATETIME NOT NULL DEFAULT NOW(),
  `exam_key` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id_exam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`question` (
  `id_question` INT NOT NULL AUTO_INCREMENT,
  `question_text` VARCHAR(500) NOT NULL,
  `question_key` VARCHAR(45) NOT NULL,
  `option_key_correct_answer` VARCHAR(45),
  `status` VARCHAR(45) NOT NULL DEFAULT "ACTIVE",
  PRIMARY KEY (`id_question`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`option_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`option_question` (
  `id_option` INT NOT NULL AUTO_INCREMENT,
  `option_text` VARCHAR(500) NOT NULL,
  `option_key` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT "ACTIVE",
  `id_question` INT NOT NULL,
  PRIMARY KEY (`id_option`),
  INDEX `fk_option_question_question_idx` (`id_question` ASC) ,
  CONSTRAINT `fk_option_question_question`
    FOREIGN KEY (`id_question`)
    REFERENCES `test_fonyou`.`question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`exam_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`exam_question` (
  `id_question` INT NOT NULL,
  `id_exam` INT NOT NULL,
  PRIMARY KEY (`id_question`, `id_exam`),
  INDEX `fk_question_has_exam_exam1_idx` (`id_exam` ASC) ,
  INDEX `fk_question_has_exam_question1_idx` (`id_question` ASC) ,
  CONSTRAINT `fk_question_has_exam_question1`
    FOREIGN KEY (`id_question`)
    REFERENCES `test_fonyou`.`question` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_has_exam_exam1`
    FOREIGN KEY (`id_exam`)
    REFERENCES `test_fonyou`.`exam` (`id_exam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`student` (
  `id_student` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `address` VARCHAR(300) NOT NULL,
  `city` VARCHAR(300) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT "ACTIVE",
  `time_zone` VARCHAR(45) NOT NULL,
  `student_key` VARCHAR(45) NOT NULL UNIQUE,
  `creation` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id_student`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`student_exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`student_exam` (
  `id_student_exam` INT NOT NULL AUTO_INCREMENT,
  `id_student` INT NOT NULL,
  `id_exam` INT NOT NULL,
  `due_date` DATETIME NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT "ACTIVE",
  `time_zone` VARCHAR(45) NOT NULL,
  `exam_grade` DOUBLE,
  `creation` DATETIME NOT NULL DEFAULT NOW(),
  `application_date` DATETIME,
  PRIMARY KEY (`id_student_exam`),
  INDEX `fk_student_has_exam_exam1_idx` (`id_exam` ASC) ,
  INDEX `fk_student_has_exam_student1_idx` (`id_student` ASC) ,
  CONSTRAINT `fk_student_has_exam_student1`
    FOREIGN KEY (`id_student`)
    REFERENCES `test_fonyou`.`student` (`id_student`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_has_exam_exam1`
    FOREIGN KEY (`id_exam`)
    REFERENCES `test_fonyou`.`exam` (`id_exam`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_fonyou`.`exam_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_fonyou`.`exam_answer` (
  `id_student_exam` INT NOT NULL,
  `id_question` INT NOT NULL,
  `id_exam` INT NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  `is_correct` TINYINT NOT NULL,
  INDEX `fk_aswer_question_student_exam1_idx` (`id_student_exam` ASC) ,
  PRIMARY KEY (`id_student_exam`),
  INDEX `fk_aswer_question_question_exam1_idx` (`id_question` ASC, `id_exam` ASC) ,
  UNIQUE INDEX `id_student_exam_UNIQUE` (`id_student_exam` ASC) ,
  UNIQUE INDEX `id_question_UNIQUE` (`id_question` ASC) ,
  UNIQUE INDEX `id_exam_UNIQUE` (`id_exam` ASC) ,
  CONSTRAINT `fk_aswer_question_student_exam1`
    FOREIGN KEY (`id_student_exam`)
    REFERENCES `test_fonyou`.`student_exam` (`id_student_exam`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_aswer_question_question_exam1`
    FOREIGN KEY (`id_question` , `id_exam`)
    REFERENCES `test_fonyou`.`exam_question` (`id_question` , `id_exam`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
