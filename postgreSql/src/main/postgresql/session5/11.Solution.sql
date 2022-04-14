--find auther name and no of books on his name
--here name without table name dot can also work since column name is uniqu in join tables
select name, count(*)
from books
join authors on authors.id=books.author_id
group by name;