--show the name of all products with the price greater than the average product price

--step first
select  avg(price) from products;

--second step
--select name from product where price greater than product-average-price

--finally
select name, price
from products
where price > (
select avg(price) as avg_price from products
);  --here can use (subquery) as P ie no alias accepted here