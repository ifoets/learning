
--select contents, url from comments
select contents , url 
from comments 
join photos on photos.id = comments.photo_id ;
