--find book rating, book and authername where rating is done by auther only

select b.title,  a.name , r.rating 
from reviews r 
join books b on b.id=r.book_id join authors a on a.id=b.author_id and a.id=r.reviewer_id

--or
select b.title, a.name, r.rating
from books b 
join reviews r on b.id=r.book_id join authors a on a.id=b.author_id and a.id=r.reviewer_id