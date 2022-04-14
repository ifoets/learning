--group by value can be used in aggrigate function ut it not affected since it select from unique single value
--ie it is meaning less
select max(id),count(user_id),max(user_id),min(user_id),avg(user_id) 
from comments
group by user_id;

--aggrigate and non aggrigate can't be use on  single column together
--this will not work
select max(id),id
from comments

--it must be grouped then only it can work since  after grouping values of groups are in set unique 
--no any meaning with aggrigate function	
select max(id),id
from comments
 group by id