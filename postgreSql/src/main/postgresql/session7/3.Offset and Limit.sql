--find last 10 row from users

select count(*) from users; --result 50

select *from users offset 40;

--offset is for remove first offset count and limit is to limit this many rows



--first 5 most expensive products
select *from products order by price desc limit 5;

--first 5 most expensive products except first
select *from products order by price desc 
limit 5
offset 1;

--limit then offset is better but we can offset then limit also ,it works

select *from products order by price desc 
offset 1
limit 5;

--first 20 least price

select *from products order by price  
limit 5
offset 0;

