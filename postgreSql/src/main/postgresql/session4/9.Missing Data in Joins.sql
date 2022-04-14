select url, username 
from photos
join users on users.id=photos.user_id;

insert into photos(url,user_id)
            values('https://banner.jpg',NULL);

--we not getting all url user since some user id is NULL on execute below query

select url, username 
from photos
join users on users.id=photos.user_id;