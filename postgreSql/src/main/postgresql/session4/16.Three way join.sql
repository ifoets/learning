--find photos url , comments and username who commented on own photos

select p.url,c.contents, u.username 
from comments c 
join photos p on p.id=c.photo_id join users u on c.user_id=u.id
where  c.user_id=p.user_id;

--or
select p.url,c.contents, u.username 
from comments c 
join photos p on p.id=c.photo_id join users u on c.user_id=u.id and p.user_id=u.id


--from
--join
--join
--...so on
--where
--this is the way of query writting flow

