--find the number of comments for each photos where the photos id is less than  3 and the photos have more than 2 comments
--this is poor solution, think better or see next section
select count(*) 
from comments c
join photos p on p.id=c.photo_id
where p.id<3
group by c.photo_id
having count(*)>2;

--print url also together

select p.url, count(*) 
from comments c
join photos p on p.id=c.photo_id
where p.id<3
group by p.url
having count(*)>2;

--the process of internal flow
---from
--join
---where
--group by
---having
--select	