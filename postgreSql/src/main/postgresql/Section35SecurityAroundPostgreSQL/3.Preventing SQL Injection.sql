create table users(
id serial primary key,
username varchar(30),
created_at timestamp with time zone default current_timestamp,
updated_at timestamp with time zone default current_timestamp,
bio varchar(400)
);

insert into users(bio,username)
values('this is my bio','kumar');
