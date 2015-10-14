CREATE DATABASE AuthSysThing;
USE AuthSysThing;
CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(30),
	username varchar(30),
	password varchar(40)
);