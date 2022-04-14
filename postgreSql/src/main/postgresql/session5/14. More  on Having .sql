--find the users(user_id) where the user has commented on the first 2 photos and the user added more than 2 comments on those photos

select user_id, count(*)
from comments
where photo_id in (1, 2)
group by user_id
having count(*)>2	


--find the users name where the user has commented on the first 2 photos and the user added more than 2 comments on those photos
select u.username, count(*)
from users u
join comments c on c.user_id=u.id where c.photo_id in (1, 2)
group by u.username
having count(*)>2

--first 50 photos and 20 comment user
select user_id, count(*)
from comments
where photo_id<50
group by user_id
having count(*)>20