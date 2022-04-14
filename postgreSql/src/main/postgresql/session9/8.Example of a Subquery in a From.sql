--find average number of orders for all users, many ways it can solve but concentrate on subquery from from section
--ie totoal no of orders/totol no of users

select sum(totol_order)/count(user_id) as average
from (select user_id, count(*) as totol_order from orders group by user_id ) as o
--or
select avg(order_cnt) as average
from (select user_id, count(*) as order_cnt from orders group by user_id) as o

--udmy solution
--first step build intermediate table from whhere we can find the  average order of all users
select user_id, count(*) from orders group by user_id;

--select user_id, avg(count(*)) from orders group by user_id; not word

--solution
select avg(order_count)
from (
select user_id, count(*) as order_count from orders group by user_id
) as o;

