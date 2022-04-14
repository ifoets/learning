--list
select least(1,2,3,0);

--all product on sale, price is the list of the products price*0.5 or 400

select name, price ,least(price*0.5, 400) 
from products;