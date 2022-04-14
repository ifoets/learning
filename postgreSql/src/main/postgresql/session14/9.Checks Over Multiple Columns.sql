--multiple column check

create table orders
(
	id serial primary key,
	name varchar(50) not null,
	created_at timestamp not null,
	est_delivery  timestamp not null,
	check(created_at<est_delivery)
);

--added
insert into orders (name, created_at,est_delivery)
  values('Shirt','2000-nov-20 01:00AM', '2000-nov-21 01:00AM');

--unable to add due to constraint
insert into orders (name, created_at,est_delivery)
  values('Shirt','2000-nov-20 01:00AM', '2000-nov-10 01:00AM')