--show the ids of orders that involve a product with price/weight ratio greater than 5

--setp first
select id from products where  price/weight>5;

--second  step
--select id from orders where product_id in ...ids of above selected product

--finally
select id 
from orders
where  product_id  in (
select id  from products where price/weight>5
) 