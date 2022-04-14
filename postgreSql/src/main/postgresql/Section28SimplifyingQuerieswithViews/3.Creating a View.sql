
--soluton using view as CTE

create  view tags as
(
   select created_at,user_id, post_id, 'photo_tag' as type from photo_tags
UNION ALL
    select created_at,user_id, post_id, 'caption_tag' as type from caption_tags
);

--see the  tags
select *from tags;
--now solution in seperate query
select username, count(*)
from users 
join
tags on tags.user_id= users.id
group by username 
order by count(*) desc
limit 1;