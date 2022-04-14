--single value return from subquery that get used in from section, then no need to use
select *
from(select max(price) from products) as p;

--this is really
select  max(price) from products;