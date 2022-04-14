--the primary key column and unique constraint column postgre automatically creat index for them
--but these indexes  are not listed in pgAdmin indexes list

--we can see by this wasy 

	select relname, relkind
	from pg_class 
	where relkind='i';--i for index


--no need to create index on primary key and unique constraint column since by default postgre create it