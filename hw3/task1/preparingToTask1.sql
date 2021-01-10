create database if not exists ListExpenses;

use listexpenses;

create table if not exists expenses (
num int primary key,
paydate date,
receiver int,
value dec
);

create table if not exists receivers (
num int primary key,
name varchar(255) character set 'utf8'
);

insert into expenses values (1, '2011-5-10', 1, 2000.0);

insert into expenses (num, paydate, value, receiver) values (2, '2011-5-10', 94200.0, 2);
insert into expenses (num, paydate, value, receiver) values (3, '2011-5-11', 10000.0, 3);
insert into expenses (num, paydate, value, receiver) values (4, '2011-5-11', 12950.0, 2);

