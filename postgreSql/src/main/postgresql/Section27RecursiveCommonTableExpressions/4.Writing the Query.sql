--Recursive CTE(Comman Table Expression)

with recursive countdown(val) AS
( 
   select 3 as val
   union
   select  val-1 from countdown where val >1
)
select *
from countdown;

---followers of followers so on...tree structure

--//this need to verify looks not correct result
with recursive flrs as
(
(select username, leader_id, follower_id
from users u
join followers f on f.leader_id=u.id)
union
select username, leader_id, follower_id from flrs where leader_id = follower_id
) 
select *
from flrs;

--duemy solution
with recursive suggesations(leader_id, follower_id, depth) as 
(
	select leader_id,follower_id, 1 as depth
	from followers 
	where follower_id=1000
union 
	select followers.follower_id, followers.leader_id, depth+1
	from followers 
	join suggesations s on s.leader_id=followers.follower_id
	where depth<3
)
select distinct users.id, users.username
from suggesations
join users on users.id=suggesations.leader_id
where depth>1
limit 5;