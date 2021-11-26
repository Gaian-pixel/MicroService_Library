create database customer;
use customer;
create table customers(customerId varchar(20) not null,
name varchar(10) not null,
surname varchar(10) not null,
address varchar(20),
telNum varchar(10),
primary key(customerId)
);
