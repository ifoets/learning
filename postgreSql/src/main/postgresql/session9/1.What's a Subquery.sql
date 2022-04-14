--List the name and price of all products that are more expensive than all the  productsin the Toys department

--list all toys name price decending order  price
select name, department, price
from products
where department='Toys'
order by price desc

--select max price of toys department
select  max(price) 
from products 
where  department='Toys'

--final query
--parenthesis (sub query) executed first in query
select  name, price
from products 
where price > 

(select  max(price)
from products 
where department='Toys' --no ; required here ; at last of the query only aways
);