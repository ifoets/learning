
--ie the round value

select (12.8981330902::integer)--integer 13
select (12.5981330902::integer)--integer 13

select (12.4981330902::integer)--integer 12


select ('abhimanyukuar'::char(3))--character abh

select ('a'::char(3))--character a with 2 space right to a	

select ('abhimanyukuar'::varchar(3))--character abh

select ('a'::varchar(3))--character a but no any extra space on right of a 

select ('abhimanyukuar'::text)--text abhimanyukuar