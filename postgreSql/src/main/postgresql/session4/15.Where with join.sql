--find photos url and comments who commented on self

select p.url,c.contents 
from comments c 
join photos p on p.id=c.photo_id 
where  c.user_id=p.user_id;

--from
--join
--where
--this is the way of query writting flow

