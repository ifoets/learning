--calculate average price of phones for each manufacturer , then print the highest average price .max_average_price

select max(average) as max_average_price
from
(select manufacturer, avg(price)as average
from phones
group by manufacturer) as p
;