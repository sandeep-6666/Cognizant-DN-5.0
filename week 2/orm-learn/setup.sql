-- Run these in a MySQL client (mysql -u root -p) before starting the app

CREATE SCHEMA IF NOT EXISTS ormlearn;

USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States of America');

-- Table for the Hibernate vs Spring Data JPA hands-on comparison
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);
