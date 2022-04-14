--print each product and price . Also print the description 
-- description -> if price>600 then 'heigh' if price>300 then medium else cheap

select 
  name,	
  price,
  CASE
  when price>600 then 'high'
  when price>300 then  'medium'
  else 'cheap'
  END
from products;

--default null

select 
  name,	
  price,
  CASE
  when price>600 then 'high'
  when price>300 then  'medium'
  END
from products;
