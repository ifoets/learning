--names of only 2nd and 3rd excensive phones

select
from phones
order by price desc
limit 2
offset 1;