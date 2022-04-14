--show each username  and the  likes they have created

--heres number of likes means all likes(comment likes  and post likes)
select username, count(*)
from users u
join likes l on l.user_id = u.id
group by u.username;

--if only post likes count then

select username, count(*)
from users u
join likes l on l.user_id = u.id
where l.post_id is not null
group by u.username;

--only comment likes count
select username, count(*)
from users u
join likes l on l.user_id = u.id
where l.comment_id is not null
group by u.username;

