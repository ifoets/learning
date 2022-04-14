--open/create/begin transaction
--by keyword
begin;

update accounts
set balance=balance-50
where name ='Alyson';

--select *from accounts;

update accounts
 set balance=balance+50
where name ='Gia';

commit;--end the tnx