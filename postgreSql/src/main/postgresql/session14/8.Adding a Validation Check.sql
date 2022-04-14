-

create table products
(
id serial primary key,
name varchar(50) not null,
department varchar(50) not null,
price integer not null,
weight integer
);

--curretnly it is inserted
	insert into products(name, department,price, weight)
	values('iphone','Apple', -1000, 2);

--add check validation
--table creation


create table products
(
id serial primary key,
name varchar(50) not null,
department varchar(50) not null,
price integer check(price>0),
weight integer
);

--external validation if already -price exists then this fail need to clean up
alter table products
add check(price>0);

--now restriction
	insert into products(name, department,price, weight)
	values('xyz','BBB', -1000, 2);



