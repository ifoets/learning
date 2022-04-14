--
select username, contents
from users
join comments on comments.user_id = users.id
where username ='Alyson14';

--Explain..just gives query information
EXPLAIN
select username, contents
from users
join comments on comments.user_id = users.id
where username ='Alyson14';

--it gives the additionl information planning time execution time

EXPLAIN ANALYSE
select username, contents
from users
join comments on comments.user_id = users.id
where username ='Alyson14';