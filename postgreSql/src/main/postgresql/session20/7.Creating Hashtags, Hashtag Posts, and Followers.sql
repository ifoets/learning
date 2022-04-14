--create table hashtags, hashtag posts and followers

--photo hashtags

create table hashtags
(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
title varchar not null unique
);

--create table caption tags

create table hashtags_posts
(
id serial primary key,
hashtag_id integer not null references hashtags(id) on delete cascade,
post_id integer not null references posts(id) on delete cascade,
unique(hashtag_id, post_id)
);

--create table followers

create table followers
(
id serial primary key,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
leader_id integer not null references users(id) on delete cascade,
follower_id integer not null references users(id) on delete cascade,
unique(leader_id,follower_id)
);


