--EXPLAIN ANALYZE before select gives explanation detials of query

--first execution 0.301ms..
--if we run many time it stablizing around Execution Time: 0.044 ms
--.big difference fast

EXPLAIN ANALYZE 
select *
from  users
where username='Email30';

--after droping the index
drop  index users_username_idx;

--now taime taken 1.987ms max an min 0.897ms around and average of 1.234ms
EXPLAIN ANALYZE 
select *
from  users
where username='Email30';

--indexing here makes around 1.23/0.044= 16-17 times faster
