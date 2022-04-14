--Recursive CTE(Comman Table Expression)

with recursive countdown(val) AS
( 
   select 3 as val
   union
   select  val-1 from countdown where val >1
)
select *
from countdown;