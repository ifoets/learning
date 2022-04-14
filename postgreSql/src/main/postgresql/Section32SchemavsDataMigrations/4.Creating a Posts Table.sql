--create table for migration

--up/do
create table posts(
id serial primary key,
url varchar (300),
lat  numeric,
lng  numeric
);

--undo
drop table posts;