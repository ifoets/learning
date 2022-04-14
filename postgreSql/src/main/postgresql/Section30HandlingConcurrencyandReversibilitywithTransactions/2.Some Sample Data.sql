--transaction in db query

--create table account

create table accounts(
id serial primary key,
name varchar(25) not null,
balance integer not null

);

insert into accounts(name, balance)
values('Gia',100)
      ('Alyson',100);