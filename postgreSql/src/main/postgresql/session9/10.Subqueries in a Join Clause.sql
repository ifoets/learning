--find the user first name who ordered whous product_id is 3

select first_name
from users
join
(
select user_id from orders where product_id=3
) as o
on  o.user_id=users.id;

--or

select first_name
from users
join
orders o
on o.user_id=users.id
where o.product_id=3;