select product_name
from netology.orders
         join netology.customers c on c.id = orders.customer_id
where name = :name