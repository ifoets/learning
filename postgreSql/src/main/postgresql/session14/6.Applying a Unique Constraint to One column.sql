--iserting duplicate product name

insert into products(name, department,price, weight)
values('pants','Cloths', 100, 1);

insert into products(name, department,price, weight)
values('pants','Cloths', 100, 2);

--add unique constraint
alter table products
add unique(name); --this is not applying if a duplicate name already exists in table

--first clean up all duplicate name then only it can be applyed