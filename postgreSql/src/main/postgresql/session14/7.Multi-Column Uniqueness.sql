--multiple column uniqueness
--table level
create table products
(
id serial primary key,
name varchar(50) not null,
department varchar(50) not null,
price integer not null,
weight integer,
unique(name, department)
);

--or
alter table products
add unique(name,department);  --it execute if name,department together duplicate should not exits other wise need to clean

--drop constraint
alter table products
drop constraint products_name_key;

-- one will add and another will not due to constraint
insert into products(name, department,price, weight)
values('Car','Toy', 10, 1);

insert into products(name, department,price, weight)
values('Car','Toy', 100, 2);

