--date
select ('nov-19-1980'::date); --data 1980-11-19
select ('nov 19, 1980'::date); --data 1980-11-19
select ('1980 nov 19'::date); --data 1980-11-19
select ('1980 november 19'::date); --data 1980-11-19

--time without time zone
select('1:23'::time);--time (time without time Zone) 01:23:00
select('1:23 PM'::time);--time (time without time Zone) 13:23:00
select('1:23 PM'::time without time Zone);--time (time without time Zone) 13:23:00
select('1:23:20 PM'::time);--time (time without time Zone) 13:23:20

--time with time zone @ explanation screen short
