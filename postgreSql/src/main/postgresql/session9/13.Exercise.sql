--get  name, price of phones that have price greater than Samsung S5620 Monte

--first step
select  price 
from phones 
where manufacturer='Samsung' and name ='S5620 Monte';

--second step
--select name, price from phones where price > above qury result

--finally
select name, price 
from phones 
where price > (
select  price 
from phones 
where manufacturer='Samsung' and name ='S5620 Monte'
);
 