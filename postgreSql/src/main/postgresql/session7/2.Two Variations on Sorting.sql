--product order by name, asc
select *from products order by name;

--desc
select *from products order by name desc;

--order by price if price asc then order by waight desc

select  *from products order by price, weight desc;