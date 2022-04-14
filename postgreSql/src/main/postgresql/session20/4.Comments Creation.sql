--create table comments
create table comments(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
contents varchar(240) not null,

user_id integer not null references users(id) on delete cascade,
post_id integer not null references posts(id) on delete cascade
);