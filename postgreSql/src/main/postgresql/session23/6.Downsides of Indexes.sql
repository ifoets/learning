--creating index create tree in hardisc and hence it take space

create index on users(username);

--to see the space get used in indexing
--872kb
select  pg_size_pretty(pg_relation_size('users'));

--the index size 
--184 kb
select  pg_size_pretty(pg_relation_size('users_username_idx'));