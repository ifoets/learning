--diffrent types of column must match then only union can bhee applyed

select name, price from products

--can union with.. since after name both have different folumn price, wight
select name, weight from products

--belwo also not work
select name from products 
union --can't union since column not matching
select price from products1

--belwo also not work also
select name from products 
union --can't union since column not matching
select price as name from products1