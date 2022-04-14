--now dropping lat lng columns ..this is last migration


--do
alter table posts
drop  column lat,
drop column lng;

--un do
alter table posts
add  column lat integer,
add column lng integer;