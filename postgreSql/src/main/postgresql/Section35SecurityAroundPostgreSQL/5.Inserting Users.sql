--return select the inserted values

insert into users(bio,username)
values('this is my bio','abhi')
returning *;