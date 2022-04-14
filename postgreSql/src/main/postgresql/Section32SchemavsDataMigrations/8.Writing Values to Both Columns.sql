--migration of adding new values after loc migration, ie new api get deployed with loc changes

--up/do
alter table posts
add column loc POINT;

--drop
alter table posts
drop column loc;

--add values without api deplyment loc will be contain null
insert into posts(url,lat,lng, loc)
values('https:/star.jpg',400,300,'(400,300)');
