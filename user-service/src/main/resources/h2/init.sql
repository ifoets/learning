CREATE TABLE users (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(30) NOT NULL,
     balance INT,
     PRIMARY KEY (id)
);

create table userTransaction(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    user_id MEDIUMINT NOT NULL,
    amount MEDIUMINT,
    transaction_date timestamp,
     PRIMARY KEY(id),
    foreign key (user_id) references users (id) on delete cascade
);
