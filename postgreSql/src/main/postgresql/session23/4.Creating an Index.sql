--creating index on username column of table users

--before indexing
--query runtime: 136 msec without any index on usrname
select * from users where username='Janie8';

--creating index automatically provided  name tablename_columnname_idx -users_username_idx
create index on users(username);
--with customerize nameing
create index users_username_index on users(username);

--after indexing on usename column 
---query runtime: 71 msec.
select * from users where username='Janie8';

--for delete index
drop index users_username_idx; --if we follow naming convention of indexing directly delete without searching its name
