--distinct always comes in select section and and after select keyword

--find all department
select distinct department from products;

--find no of all department
select count(distinct department) from products;

--we can use group by at the palce of distinct but we can't use distinct at the place of group by

--unique combination of multiple column

--it will give distinct combination of department and name

select distinct department, name from products; 

--unique combination of multiple column will not gives count

--select count(distinct department, name) from products;  --it not works 