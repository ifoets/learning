--Recursive CTE(Comman Table Expression)

with recursive countdown(val) AS
( 
   select 3 as val
   union
   select  val-1 from countdown where val >1
)
select *
from countdown;

--Result Table Result Table
--RT WT
--3 3
--2 2
--1 1