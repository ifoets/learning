--find author_id and  no of books they written table structure in corresponding explanation

select b.author_id, count(*) from books b group by b.author_id;