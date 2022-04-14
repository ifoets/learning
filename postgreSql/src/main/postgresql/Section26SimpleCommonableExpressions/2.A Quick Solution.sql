--show  the username of the users who were tag in a caption or photo before jan 7th 2010. 
--Also show date they where tagged.

--solution from udemy..union of caption and photo table then join  with users


--note union only can do when two tables have sets of identical column(where union will be applyed) and here is perfect
--first step union
select user_id,created_at from caption_tags
union all
select user_id, created_at from photo_tags;

--finally
select u.username, tags.created_at as created_at
from users u
join
(
select user_id,created_at from caption_tags
union all
select user_id, created_at from photo_tags
) as tags
on tags.user_id=u.id
where tags.created_at <'2010-01-07';