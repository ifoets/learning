
--manufacturer whose price is less than 170
select manufacturer
from phones
where price<170;

----manufacturer who created more than two phone

select manufacturer
from phones
group by manufacturer
having count(*)>2;

--union of both

select manufacturer
from phones
where price<170

union

select manufacturer
from phones
group by manufacturer
having count(*)>2