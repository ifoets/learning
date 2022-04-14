--create table likes

create table likes
(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

user_id integer not null references users(id) on delete cascade,
post_id integer references posts(id) on delete cascade,
comment_id integer references  comments(id) on delete cascade,

CHECK(
      COALESCE((post_id)::boolean::integer, 0)
      +
      COALESCE((comment_id)::boolean::integer,0)
      =1
),
 UNIQUE(user_id, post_id,comment_id) --single likes on post or comment either per row creatioin as per design

);