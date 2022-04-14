--print the name of all phones that have price greater than any phone made by Sumsang

--firt step
select price from  phones where manufacturer='Samsung';

--second step
--select name
--from  phones
--where price > ANY (above result)

--finally
select  name
from phones
where  price  > ALL (
select price from  phones where manufacturer='Samsung'
);