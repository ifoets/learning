    select title, name
    from books
    join authors on authors.id=books.author_id;