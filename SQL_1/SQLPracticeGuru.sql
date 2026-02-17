--create a product table having fields like
--prod_id,prod_name,prod_desc,price

create table product(
prod_id SERIAL PRIMARY KEY,
prod_name VARCHAR(10),
prod_desc VARCHAR(20),
price NUMERIC(5,2)
);

-- select * from product

-- ALTER TABLE product
-- ADD PRIMARY KEY (product_id);

-- drop table product;

select * from product;

alter table product
alter column prod_category type VARCHAR(20);

 insert into product(prod_name, prod_desc, price,prod_category) values('Meat','Edible stuff',500.20,'Food');
-- update product
-- set prod_category='Food'
-- where prod_id=1;
insert into product(prod_name, prod_desc, price,prod_category) values('Fish','Edible stuff',400.00,'Food');
insert into product(prod_name, prod_desc, price,prod_category) values('Phone','Mobile Phone',100.00,'Electronics');
insert into product(prod_name, prod_desc, price,prod_category) values('Laptop','Gaming Laptop',999.99,'Electronics');

INSERT INTO product(prod_name, prod_desc, price, prod_category) 
VALUES 
('Bread', 'Whole wheat bread', 2.50, 'Food'),
('Milk', 'Organic cow milk', 3.00, 'Food'),
('Headphones', 'Noise-cancelling', 150.00, 'Electronics'),
('Smartwatch', 'Fitness tracker', 199.99, 'Electronics'),
('T-shirt', 'Cotton casuals', 25.00, 'Clothing'),
('Jeans', 'Denim jeans', 50.00, 'Clothing'),
('Sofa', '3-seater sofa', 750.00, 'Furniture'),
('Wood Table', 'Wooden table', 120.00, 'Furniture'),
('Notebook', '200 pages', 5.00, 'Stationery'),
('Pen', 'Gel ink pen', 1.50, 'Stationery');


-- count of each product_category
SELECT prod_category, COUNT(*)
FROM product
GROUP BY prod_category;

--display categories more than 1
SELECT prod_category
FROM product
GROUP BY prod_category
HAVING COUNT(*)>1

--sort based on count ascending order
SELECT prod_category,count(*) as tot_prod
FROM product
GROUP BY prod_category
ORDER BY tot_prod asc

--query to fetch the product having the second highest price
SELECT product.* from product where price=
(SELECT MAX(PRICE) from product
where PRICE<(select MAX(PRICE)
from product));

--update the price of all electronic items so that the new price
--is 10% less than the original price

update product
set price=(price-price*0.1)
where prod_category='Electronics';

select * from product;

--delete the products whose price is less than the average price of all the products

delete from product
where price<(select avg(price)
from product);

select * from product;

--delete the products category wise whose price is less than the average
--price in that specific category

DELETE FROM product p1
WHERE price < (
    SELECT AVG(price)
    FROM product
    WHERE prod_category = p1.prod_category
);

select * from product;
delete from product

--create an orders table having fields as ord_id,ord_date,ord_type
--and prod_id as foreign key , Also ensure that whenever a data changes
--in the parent table,it should get reflected in child table

create table orders
(ord_id SERIAL PRIMARY KEY,
ord_date DATE,
ord_type VARCHAR(10),
prod_id integer,
constraint fk_product
Foreign key (prod_id)
references product(prod_id)
on delete cascade
on update cascade);

drop table orders
select * from orders

INSERT INTO orders (ord_date,ord_type, prod_id) VALUES
('2025-12-18', 'online',47),
('2025-12-09', 'offline',47),
('2025-12-10', 'online',50),
('2025-12-11', 'store',50),
('2025-12-12', 'online',57);

truncate table orders;
select * from orders;

--fetch the product which has the most number of orders
SELECT *
FROM product
WHERE prod_id = (
    SELECT prod_id
    FROM orders
    GROUP BY prod_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);
--delete a product in product table and make sure the order entry is
--also deleting

alter table orders
drop constraint fk_product;

alter table orders
add constraint fk_product
foreign key(prod_id)
references product(prod_id)
on delete cascade
on update cascade

delete from product
where prod_name='Meat';

select * from product;
select * from orders;
