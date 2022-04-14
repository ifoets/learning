select 2+2; --integer 4

select (2);--integer 2
select (2.0); --numeric 2.0

select (2.0::integer); --integer 2

select (2.0::smallint); --smallint 2

--deep accuracy 100% precise real,double percision, float
select  (1.99999::real-1.99998::read); --1.001358e-05 ->0.00001001358

--precise
select  (1.99999::decimal-1.99998::decimal);--0.00001

select  (1.99999::numeric-1.99998::numeric);--0.00001