--select (single value return query)

select
(
select max(price) from products
);
--

select
(
select max(price) from products
)/
(
select min(price) from products
)
;
---
select
(
select max(price) from products
)/
(
select avg(price) from products
)
;
--select two column
select
(
select max(price) from products
), 
(
select avg(price) from products
)
;