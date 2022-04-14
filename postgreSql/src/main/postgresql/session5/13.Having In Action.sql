--find the number of comments for each photos where the photos id is less than  3 and the photos have more than 2 comments

select c.photo_id, count(*) 
from comments c
where c.photo_id<3
group by c.photo_id
having count(*)>2;
