--find no of comments on each photos

select photo_id, count(*) from comments c group by c.photo_id;

--find the url and count of each photos

select  p.url, count(*) from comments c join photos p on  p.id=c.photo_id group by p.url;