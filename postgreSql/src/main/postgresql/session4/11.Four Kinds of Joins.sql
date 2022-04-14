--just JOIN means inner join ie common in both table with joining cretaria

select url, username 
from photos
join users on users.id=photos.user_id;

insert into photos(url,user_id)
            values('https://banner.jpg',NULL);

--we not getting all url user since some user id is NULL on execute below query

select url, username 
from photos
join users on users.id=photos.user_id;

--JOIN or INNER JOIN both are same thing that join the default matching rest descrted from result set

select url, username 
from photos
inner join users on users.id=photos.user_id;

--Left Join take all rows from left table and matching from right table
-- and nullify(since [from] is left table)right site stuff any non matching in right table in overall join

select url, username 
from photos
left join users on users.id=photos.user_id;

--Right Join take all rows from right table and matching from left table
-- and nullify left site stuff any non matching in left table in overall join

select url, username 
from photos
right join users on users.id=photos.user_id;

--full join is left join + right join

select url, username 
from photos
full join users on users.id=photos.user_id;

