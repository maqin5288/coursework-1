DROP DATABASE IF EXISTS `coursework`;
DROP USER `tektree`@`localhost`;
CREATE DATABASE `coursework`;

CREATE USER `tektree`@`%` IDENTIFIED BY 'P@55word';
GRANT ALL privileges ON coursework.* TO `tektree`@`%`;
