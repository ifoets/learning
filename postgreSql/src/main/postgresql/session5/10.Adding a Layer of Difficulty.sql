--we want to collect infomation fro both the table ie means need to join

--find the  auther name and count of book written by then table structure is in explanation

select a.name, count(*)
from books b 
join authors a on a.id=b.author_id
group by a.name 