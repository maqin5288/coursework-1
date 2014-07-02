DROP TABLE IF EXISTS `coursework`.`customer`;
DROP TABLE IF EXISTS `coursework`.`address`;
DROP TABLE IF EXISTS `coursework`.`customer_address_link`;


CREATE TABLE `coursework`.`customer` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY (`id`)
);

INSERT INTO `coursework`.`customer` (`first_name`,`last_name`,`date_of_birth`) VALUES ('Srikanth','Anusuri','2000-05-05');
INSERT INTO `coursework`.`customer` (`first_name`,`last_name`,`date_of_birth`) VALUES ('Ahab','E','2000-04-04');
INSERT INTO `coursework`.`customer` (`first_name`,`last_name`,`date_of_birth`) VALUES ('Qin','Ma','2000-06-06');


CREATE TABLE `coursework`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street_address` VARCHAR(45) NOT NULL,
  `apartment_number` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `coursework`.`address` (`street_address`, `city`, `state`, `zip`) VALUES ('1234 Main St', 'Detroit', 'MI', '48321');
INSERT INTO `coursework`.`address` (`street_address`, `apartment_number`, `city`, `state`, `zip`) VALUES ('321 Detroit Ave', '200', 'Livonia', 'MI', '48322');
INSERT INTO `coursework`.`address` (`street_address`, `apartment_number`, `city`, `state`, `zip`) VALUES ('100 Ford Rd', '', 'Farmington', 'MI', '48521');
INSERT INTO `coursework`.`address` (`street_address`, `apartment_number`, `city`, `state`) VALUES ('150 Farmington Rd', '123', 'Farmington', 'MI');

CREATE TABLE `coursework`.`customer_address_link` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_idx` (`customer_id` ASC),
  INDEX `fk_address_idx` (`address_id` ASC),
  CONSTRAINT `fk_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `coursework`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `coursework`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `coursework`.`customer_address_link` (`customer_id`, `address_id`) VALUES (2, 2);
INSERT INTO `coursework`.`customer_address_link` (`customer_id`, `address_id`) VALUES (1, 1);
INSERT INTO `coursework`.`customer_address_link` (`customer_id`, `address_id`) VALUES (3, 3);
INSERT INTO `coursework`.`customer_address_link` (`customer_id`, `address_id`) VALUES (3, 4);


SELECT * FROM `coursework`.`customer`;
SELECT * FROM `coursework`.`address`;
SELECT * FROM `coursework`.`customer_address_link`;

-- Join criteria
SELECT c.*, a.* FROM `coursework`.`customer` c, `coursework`.`address` a, `coursework`.`customer_address_link` cal WHERE cal.customer_id=c.id and cal.address_id=a.id;