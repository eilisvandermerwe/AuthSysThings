DROP DATABASE AuthSysThing;
CREATE DATABASE AuthSysThing;
USE AuthSysThing;
CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(30),
	username varchar(30) UNIQUE,
	password varchar(40)
);

-- INSERT INTO users (name, username, password) VALUES ("Bilbo!", "bilboB1", "ring");

-- SELECT * FROM users;

-- SELECT name, username, password FROM users WHERE username = "bilboB" AND password = "ring";