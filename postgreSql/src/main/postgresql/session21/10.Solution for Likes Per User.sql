--show each username  and the  likes they have created

--heres number of likes means all likes(comment likes  and post likes)

--step 1
select *
from users u
join likes l on l.user_id = u.id

--and check every thing that we required exists in combined table or not

select username, count(*)
from users u
join likes l on l.user_id = u.id
group by u.username;

--if only post likes count then


