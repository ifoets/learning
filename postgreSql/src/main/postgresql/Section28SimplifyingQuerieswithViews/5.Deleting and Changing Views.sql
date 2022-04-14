--replace the old view have 10 row now want to 15

create or replace view recent_posts as
(
 select *
from posts
order by created_at desc
limit 15
);	

--see
select *from recent_posts;

--delete view
drop view recent_posts;