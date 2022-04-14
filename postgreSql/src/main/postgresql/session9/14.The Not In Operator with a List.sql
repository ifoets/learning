--show the names of all products that are not in same department as the products with a price less than 100

--first step
select department from products where price<100;

--second step
--select from products where department not in (above result)

--finally
select name
from products
where department not in (
select department from products where price < 100
);