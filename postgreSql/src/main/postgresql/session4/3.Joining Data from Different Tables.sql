
--select contents, username from comments
select contents , username 
from comments 
join users on users.id = comments.user_id ;

