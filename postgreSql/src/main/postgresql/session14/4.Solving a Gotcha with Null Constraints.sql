--for any particular value like price, weight that must be positive ,
--a validation require from database/table level also...for any worst senario

--not updating since some price is null

alter table 
products
alter column
price 
set not null;

--soluton update null price or delte all the price having null value
update products
set price=9999
where price is null;

--now can alter
alter table 
products
alter column
price 
set not null;


--now below query failing constraint
insert into products(name, department, weight)
values('pants','Cloths', 1);