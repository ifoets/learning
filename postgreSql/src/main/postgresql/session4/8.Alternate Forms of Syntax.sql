    select title, name
    from books
    join authors on authors.id=books.author_id;

--order of table may or may not make difference in result  
select  name, title
    from authors
    join books on authors.id=books.author_id;

--if tow column have same name in join imginary table then we must give the context

    select books.id, authors.id --not simply id
    from books
    join authors on authors.id=books.author_id;

--or 
  select books.id as book_id, authors.id --not simply id
    from books
    join authors on authors.id=books.author_id;

--when table use AS alies name then all place in table it can be used

select comments.id as comment_id , p.id 
from  photos AS p 
join comments on p.id = comments.photo_id ;

--or witout AS

select comments.id as comment_id , p.id 
from  photos  p 
join comments on p.id = comments.photo_id ;
