--print name, price of each phones, In addition print the ratio of price against max price of  all phones, rename this price_ratio

select name, price, price/(select max(price) from phones) as price_ratio
from phones;