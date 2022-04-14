--join users and posts table. Show the username of user ID 200 and the captions of all the posts they have created

select u.username, p.caption
from users u
join posts p on p.user_id=u.id
where u.id=200; 