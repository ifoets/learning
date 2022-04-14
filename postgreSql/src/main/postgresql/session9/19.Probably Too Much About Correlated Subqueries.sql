--name, department, price of most expensive product in each department

--first step
select department, max(price) from products group by department;
--finally step
select p1.name, p1.department, p1.price
from products p1 join (
select department, max(price) as max_price from products group by department
) as p2 
on p1.department = p2.department and p2.max_price=p1.price
where p1.price in (
select max(price) from products group by department
);

--or

select p1.name, p1.department, p1.price
from products p1 
where p1.price in (
select max(price) 
from products p2 
where p2.department=p1.department
group by department
);

--or  udmy solution

select p1.name, p1.department, p1.price
from products p1 
where p1.price = (
select max(price) 
from products p2 
where p2.department=p1.department
);