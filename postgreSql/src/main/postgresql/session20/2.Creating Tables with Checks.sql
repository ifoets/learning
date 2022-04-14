--create table users

create table users(
id serial primary key,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	username varchar(30) NOT NULL,
	bio varchar(400),
	avatar varchar(200),
	phone varchar(25),
	email varchar(40),
	password varchar(50),
    status varchar(15),
	CHECK(COALESCE(email,phone) IS NOT NULL)
);