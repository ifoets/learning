--create view to execut many similar recent query
create view recent_posts as
(
  select *
from posts
order by created_at desc
  limit 10;
);

--see view
select *from  recent_posts;


--show the users who created the 10 most recent post
select username 
from recent_posts r
join users u on r.user_id = u.id;

--show the no of likes each of the 10 recent post
select r.name, count(*)
from recent_posts r
join likes l on r.id=l.post_id
where l.post_id is not null
group by r.name;

--show the users who where tagged in the 10 most recent post 
with tags as(
select  post_id from caption_tags
Union All
select post_id from photo_tags
)
select username 
from recent_posts r 
join tags on tags.post_id=r.id
join users u on r.user_id = u.id;

--show the hastags used by the 10 most recent posts

select r.id , h.hashtag_id
from recent_posts r 
join hashtags_posts h on h.post_id=r.id;

--show the average no of hashtags used in most 10 recent post

select count(*)/10
from recent_posts r 
join hashtags_posts h on h.post_id=r.id

--show the no of comments received the most 10 recent post;

select count(*)
from recent_posts r
join comments c on c.post_id=r.id;



