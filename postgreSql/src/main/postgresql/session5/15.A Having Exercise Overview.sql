--print name of  manufacturer toatal revenue (price*unit_sold)..table structure is in explanantion

select manufacturer, sum(price*units_sold)
from phones
group by manufacturer
having sum(price*units_sold)>2000000