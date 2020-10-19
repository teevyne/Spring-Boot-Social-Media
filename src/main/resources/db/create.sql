DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'appuser123';
GRANT ALL PRIVILEGES ON socialappdb.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES ;

DROP DATABASE IF EXISTS socialappdb;
CREATE DATABASE socialappdb;