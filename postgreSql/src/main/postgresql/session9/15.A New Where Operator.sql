--show name, department, price of the products that are more expensive than all the product in 'industrial' department

--fist step
select max(price) from products where department='industrial';

--second step
--select  name, department, price 
--from products
--where price > above query  resutl 

--finally
select  name, department, price 
from products
where price > (
select max(price) from products where department='Industrial'
);

--udmy sollution by using ALL key workd

select  name, department, price 
from products
where price > ALL (
select price from products where department='Industrial'
);