--for each week show the no of likes and comments received
--Use the post and comment created_at date not when the likes was received


--step 1
select date_trunk('week', coalesce(posts.created_at, comments.created_at)) 
from likes
left join posts on posts.id=likes.post_id
left join comments on comments.id=likes.comment_id;

--finally
--count() function not count null values
--this query takes 4/5 second on every run so go for materlise view
select date_trunc('week', coalesce(posts.created_at, comments.created_at)) as week
,count(posts.id) as num_likes_for_posts
,count(comments.id) as num_likes_for_comments
from likes
left join posts on posts.id=likes.post_id
left join comments on comments.id=likes.comment_id
group by week
order by week;