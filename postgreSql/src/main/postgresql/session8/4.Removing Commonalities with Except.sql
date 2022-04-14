
--except select form 1st query not exists in 2nd query and remove duplicate
(select * 
from products order by price desc
limit 4)
except
(select *
from products order by price/weight desc
limit 4
);

--except all select form 1st query not exists in 2nd query 
(select * 
from products order by price desc
limit 4)
except all
(select *
from products order by price/weight desc
limit 4
);