
--select ('true'::boolearn)--booolean true
select ('y'::BOOLEAN);--booolean true
select ('t'::BOOLEAN);--booolean true
select (1::BOOLEAN);--booolean true

select ('no'::BOOLEAN);--booolean false
select ('f'::BOOLEAN);--booolean false
select ('n'::BOOLEAN);--booolean false
select (0::BOOLEAN);--booolean false

select (null::BOOLEAN);--booolean nulls