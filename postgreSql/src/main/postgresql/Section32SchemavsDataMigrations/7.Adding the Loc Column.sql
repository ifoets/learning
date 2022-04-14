--migration of adding new  column to posts

--up/do
alter table posts
add column loc POINT;

--drop
alter table posts
drop column loc;

--add values without api deplyment loc will be contain null
insert into posts(url,lat,lng)
values('https:zzz.d',100,200);
