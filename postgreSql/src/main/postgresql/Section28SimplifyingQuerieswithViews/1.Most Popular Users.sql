--show the most popular users, the users who where taged most

--step 1 union caption_tags and photo_tags

with tags(user_id) as
(
   select user_id from  caption_tags
UNION ALL
   select user_id from photo_tags
)
select  u.username, count(u.username)
from users u
join tags t on t.user_id = u.id
group by u.username
order by count(u.username) desc
limit 1;

--duemy solution
--many many times we joing caption_tags and photo_tags in demanding query so these 2 table seperate as design mistake
select username, count(*)
from users 
join
(
   select user_id  from caption_tags
UNION ALL
   select user_id from photo_tags
) as tags on tags.user_id= users.id
group by username 
order by count(*) desc
limit 1;