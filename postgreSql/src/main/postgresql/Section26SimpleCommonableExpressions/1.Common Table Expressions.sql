--show  the username of the users who were tag in a caption or photo before jan 7th 2010. 
--Also show date they where tagged.

select u.username, 
c.created_at,
case when c.created_at is null then p.created_at
     else c.created_at
     end
from users u
join caption_tags c on c.user_id=u.id join photo_tags p on p.user_id=u.id
where c.created_at <'2010-01-07' or p.created_at <'2010-01-07';