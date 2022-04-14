--create table posts

CREATE TABLE posts(
id serial primary key,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    url varchar(200) NOT NULL,
    caption varchar(240),
    lat real check(lat is null or (lat>=-90 and lat <=90)),
    lng real check(lng is null or (lng>=-180 and lng<=180)),

    user_id integer not null references users(id) on delete cascade
);