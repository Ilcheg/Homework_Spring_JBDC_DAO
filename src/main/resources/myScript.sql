SELECT
    product_name
FROM
    netology.orders
        INNER JOIN
    customers c ON orders.customer_id = c.id
WHERE
        name = :name;