--Recursive CTE(Comman Table Expression)
-----followers of followers so on...tree structure

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