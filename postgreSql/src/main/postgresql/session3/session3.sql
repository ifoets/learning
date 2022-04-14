create table users
(
	id serial primary key,
	username varchar(50)
);

INSERT INTO  users(username)
             values('kumar'),
             ('abhi'),
             ('suman'),
             ('raj');
			 
			 
CREATE TABLE photos(
id serial PRIMARY KEY,
  url VARCHAR(200),
  user_id INTEGER REFERENCES users(ID) on delete cascade
);

INSERT INTO photos(url, user_id)
            VALUES('http://one.jpg',4);
INSERT INTO photos(url, user_id)
VALUES('http://xyz.jpg',4);
			
INSERT INTO photos(url, user_id)
VALUES('http://two.jpg',1),
('http://24.jpg',1),
('http://56.jpg',2),
('http://25.jpg',3),
('http://88.jpg',1);

--list of all photos detials associated with user for each

select url, username from photos join users on users.id=photos.user_id;

	
CREATE TABLE boats(
id SERIAL PRIMARY KEY,
name VARCHAR(50) 
);

INSERT INTO boats (name)
            VALUES('XXX'),
            ('YYY');
            
CREATE table crew_memebers(
ID SERIAL PRIMARY key,
  name VARCHAR(50),
  boat_id INTEGER REFERENCES boats(id)
);
		INSERT INTO crew_memebers(name,boat_id)
					values('abhi',1),('kumar',1),('suman',2);
					
--fetch  all crew_memebers associated  with boat that have id 1

select *from crew_memebers where boat_id=1;


