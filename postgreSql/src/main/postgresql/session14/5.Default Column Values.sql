--default value if no value provide it tak automatically

create table products
(
id serial primary key,
name varchar(50) not null,
department varchar(50) not null,
price integer not null,
weight integer
);

--setting default
alter table products
alter column price
set default 99999;

--setting default must be compitable the data type of that column