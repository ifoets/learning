    select title, name
    from books
    join authors on authors.id=books.author_id;

--order of column not big matter    
select  name, title
    from books
    join authors on authors.id=books.author_id;