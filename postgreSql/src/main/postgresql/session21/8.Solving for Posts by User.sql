--join users and posts table. Show the username of user ID 200 and the captions of all the posts they have created

--step 1
select *
from users 
join posts on posts.user_id = users.id

--and check the join and table and your needed stuff

--step 2 finally
select username, caption
from users 
join posts on posts.user_id = users.id
where users.id = 200;

