--first migration
--do
create table comments(
id serial primary key,
	created_at timestamp with  time zone,
	updated_at timestamp with  time zone,
	contents varchar(240)
);

