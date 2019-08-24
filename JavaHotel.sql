create database JavaHotel;

use JavaHotel;
create table users (
id int NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL UNIQUE,
passwrd varchar(255) Not null ,
firstName varchar(255) NOT NULL ,
lastName varchar(255) NOT NULL ,
ssn int NOT NULL UNIQUE,
email varchar(255) Not null ,
address varchar(255) Not null ,
phone int NOT NULL,
userRole varchar(255) not null default 'customer',
accountStatus varchar(255) not null default 'active',
PRIMARY KEY (id)
);
