
--this is the way working with group by first find table and the column get used in group by then next any thing
/*
select
from [table]
group by [column]
*/

--find author_id and  no of books they written, table structure is in corresponding explanation

select b.author_id, count(*) 
from books b 
group by b.author_id;
