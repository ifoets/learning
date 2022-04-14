--select the 3 users with the heighest Id's from user tables

--Total query runtime: 595 msec.
select *
from users
order by id desc
limit 3;

