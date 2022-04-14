--
select *
from likes
where created_at <'2013-01-01';



--
--
Explain
select *
from likes
where created_at <'2013-01-01';

--
create index likes_created_at_idx on likes(created_at);

select count(*)
from likes
where created_at <'2013-01-01';
--60k

select count(*)
from likes
where created_at >'2013-01-01';
--688k

--its doing sequential scan even created index on it
Explain select count *
from likes
where created_at >'2013-01-01';

