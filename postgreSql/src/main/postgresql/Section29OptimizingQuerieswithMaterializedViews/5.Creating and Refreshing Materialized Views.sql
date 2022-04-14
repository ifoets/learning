--materlise view at very specific and postgres hold the result

--finally
--count() function not count null values
--this query takes 4/5 second on every run so go for materlise view

create materialized view weekly_likes as
(
	select date_trunc('week', coalesce(posts.created_at, comments.created_at)) as week
	,count(posts.id) as num_likes_for_posts
	,count(comments.id) as num_likes_for_comments
	from likes
	left join posts on posts.id=likes.post_id
	left join comments on comments.id=likes.comment_id
	group by week
	order by week
)with data;

--materialized view is result stored in postgre and we cant manually update it as we want
--if we delete data from original table get used in materialized view then here data is still
--present since stroed in postgres
delete
from posts 
where created_at<'2010-02-01'; 

--and run
select *from weekly_likes; --we can se the data here

--for reflecting the data we need to refresh query for materialized view
REFRESH materialized view weely_likes;

--then u can run and see the updated one after deletion of real table
select *from weekly_likes;

