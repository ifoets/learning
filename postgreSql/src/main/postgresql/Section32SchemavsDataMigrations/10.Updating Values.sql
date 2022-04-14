--migration of data
--copying data from lat,lng to loc

begin;

update  posts
set loc = point(lng,lat)
where  loc is null;

commit;
