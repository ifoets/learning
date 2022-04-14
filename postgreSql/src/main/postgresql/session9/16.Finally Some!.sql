--name of the products that are more expansive than at least oen of the products in 'Industrial' departments

--first step
select price
from products where department='Industrial';

--second step
--select name, department, price
--from products
--where price > ANY (result of above query) 

--finally with > ANY 
select name, department, price
from products
where price > ANY (
select price
from products 
where department='Industrial'
); 

--with > SOME both are same thing
select name, department, price
from products
where price > SOME (
select price
from products 
where department='Industrial'
); 