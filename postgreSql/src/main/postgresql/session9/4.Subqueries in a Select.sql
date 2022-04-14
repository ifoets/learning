--in select section sub query must return a single value
--Ex
select name, price,(
select max(price) from products --this is select section so must return single value
)
from products where price>867

--another ex
select price from products where id=3 --it gives single value or no value..ie is single only
--
select name, price,(
select price from products where id=3 --this is select section so must return single NULL value only
) as id_3_price
from products where price>867
