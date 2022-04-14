--for any particular value like price, weight that must be positive ,
--a validation require from database/table level also...for any worst senario

create table products
(
id serial primary key,
name varchar(50),
department varchar(50),
price integer,
weight integer
);

insert into products(name, department,price, weight)
values('Shirt','Cloths', 20, 1);