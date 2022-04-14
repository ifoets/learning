--only use of subquery find max price, min price and average price of all phones
--rename max_price, min_price,avg_price

select
(select max(price) from phones)  as max_price,
(select min(price) from phones) as min_price ,
(select avg(price) from phones)  as avg_price
;