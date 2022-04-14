
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

--possible solution in explanation