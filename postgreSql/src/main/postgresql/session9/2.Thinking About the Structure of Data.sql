--there are sub query with query can be many layers 
--Ex

select p1.name,
(select count(*) from products)
from
(select  *from products) p1
join
(select  *from products ) p2
on p1.id=p2.id
where p1.id in (select id from products)
;