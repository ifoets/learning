--open/create/begin transaction
--by keyword
--set balance


begin;

--creating erro in query
select *from adfdfsdfsd;
--error occured
select *from accounts;--curretn trnx is aboured  command is ignored until end of transaction block

rollback;

--now works

select *from accounts;
