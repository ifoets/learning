
--if any vlaue of column is null then count don't consider
select count(user_id) from photos;
--ans 20 where  as 21 row  exists but one user_id is NULL

--if u want to really know the total count of columen then use count(*)

select count(*) from photos;

--when use count then use * rathar then referecing any coulum

select user_id, count(*) form photos group by user_id; --if any user_id null that  also come in consideration