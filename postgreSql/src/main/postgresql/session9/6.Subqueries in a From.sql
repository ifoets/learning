select name, price/weight as price_weight_ratio
from products;

--when sub query are in from section there must be alis name be used 

--select x, y
--from (subquery) as sb

--if column does not exits in from then it will not  work
--this is fine 
	select name, price_weight_ratio
	from (
		select name, price/weight as price_weight_ratio from products
	) as p --alis must be present when sub query is in from section
	where price_weight_ratio>5;

--this is not fine sincec price column does not exists in from(selected intermediate table)

select price, price_weight_ratio
from (
	select name, price/weight as price_weight_ratio from products
) as p --alis must be present when sub query is in from section
where price_weight_ratio>5;