--coalesce it return fist not null value
select coalesce(null,5);--5

select coalesce(10,5);--10

select coalesce((4)::boolean::integer,0);--1
select coalesce((null)::boolean::integer,0);--0 

--
select (null)::boolean;--it return boolean of null
select (null)::integer;--it return integer of null
select (null)::boolean::integer; --here two conversion firt to boolean of null then that to integer of null

select (123)::boolean::integer;--first true and then 1