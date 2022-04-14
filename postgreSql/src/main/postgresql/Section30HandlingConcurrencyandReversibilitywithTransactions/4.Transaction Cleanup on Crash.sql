--open/create/begin transaction
--by keyword
--set balance
update accounts set balance=100;

begin;

update accounts
set balance=balance-50
where name ='Alyson';

--simulate a crash in tnx
--go to dashboard and close the connection
