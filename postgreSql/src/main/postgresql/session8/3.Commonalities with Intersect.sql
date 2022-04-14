
--intersect means collect comman in both the query
(select * 
from products order by price desc
limit 4)
intersect
(select *
from products order by price/weight desc
limit 4
);

--intersect al means comman in result set
(select * 
from products order by price desc
limit 4)
intersect all
(select *
from products order by price/weight desc
limit 4
);