--without using join or a group by, print number of order of each product

--step 1 it give count of every product id in order table
select product_id, count(*)
from orders
group by product_id;

--finally
select p.name, (select count(*) from orders o where o.product_id=p.id)
from products p;