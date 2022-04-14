--print no/count of paid and unpaid, @see explanation

select paid, count(*)
from orders
group by paid; 