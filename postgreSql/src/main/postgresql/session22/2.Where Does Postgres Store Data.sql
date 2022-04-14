--where the data store in hard drive

show data_directory;  --C:\Program Files\PostgreSQL\14\data


--it give the names of all databses and the corresponding folder where these are stored
select oid, datname
from pg_database;


--this gives all the objects in our database

select *from pg_class;