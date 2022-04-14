--create table Tags and Caption Tags

--photo tags

create table photo_tags
(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    
user_id integer not null references users(id) on delete cascade,
post_id integer not null references posts(id) on delete cascade,
x integer not null,
y integer not null,
unique(user_id,post_id)
);

--create table caption tags

create table caption_tags
(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
   
user_id integer not null references users(id) on delete cascade,
post_id integer not null references posts(id) on delete cascade,
unique(user_id,post_id)
);

