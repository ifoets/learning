--here unique user_id get grouped we can select  or aggrigate both are same thing
select user_id
from comments
group by user_id


--there are many id in grouped with single unique user_id and the max ofthem selected @see corresponding explanation section intermediate
--table digram
select max(id)
from comments
group by user_id

--count means how many in each uniee grouped by group value

select user_id, count(id) as no_comments
from comments
group by user_id
