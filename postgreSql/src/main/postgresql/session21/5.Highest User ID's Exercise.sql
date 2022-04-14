--select the 3 users with the heighest Id's from user tables

--Total query runtime: 595 msec.
select id
from users
order by id desc
limit 3;

---Total query runtime: 86 msec.
select id
from users
limit 3 offset (
select  count(*)-3 
from users
);