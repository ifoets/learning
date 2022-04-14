--compute the ship of each item, shipping is maximum of (weight*2, 30)

select name, weight, GREATEST(30, 2*weight) as shipping_cost
 from products;