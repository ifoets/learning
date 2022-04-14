--select each title of books and author name and dispay author who don't have any book
select title, name 
from books right join authors on authors.id = books.author_id

--or

select title, name 
from authors right join book on authors.id = books.author_id