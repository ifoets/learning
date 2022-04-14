--4 costly products
select * 
from products order by price desc
limit 4;
--4 most price/weight
select *
from products order by price/weight desc
limit 4;

--4 most costly and 4 most price/weight
--if any thing is identical then only the common on will print

(select * 
from products order by price desc
limit 4)
union
(select *
from products order by price/weight desc
limit 4
);

--if any thing is identical and we want all to
(select * 
from products order by price desc
limit 4)
union all
(select *
from products order by price/weight desc
limit 4
); 