--print fist_name and last_name of user and their paid or unpaid value of each product for each users

select u.first_name, u.last_name, o.paid
from users u
join orders o on u.id=o.user_id;