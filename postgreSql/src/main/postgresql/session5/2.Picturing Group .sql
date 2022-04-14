
select user_id 
from comments
group by user_id;

	--we can't select any other column except group by rather than we can aggrigate or some calulation max min concat etc

--this  will not work
select contents 
from comments
group by user_id;