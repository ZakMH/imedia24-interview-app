INSERT INTO "category" VALUES
(100, 'Electronics', NULL),
(200, 'Laptops', 100),
(300, 'Smartphones', 100),
(400, 'Clothing', NULL),
(500, 'Men''s Clothing', 400),
(600, 'Women''s Clothing', 400);

INSERT INTO "product" VALUES
(1000, 'MacBook Pro', '/img/mac.jpg', 1999.99),
(2000, 'iPhone 12', '/img/iphone.jpg', 1099.99),
(3000, 'Samsung Galaxy S21', '/img/samsung.jpg', 899.99),
(4000, 'Levi''s Jeans', '/img/levis.jpg', 79.99),
(5000, 'Nike Shoes', '/img/nike.jpg', 129.99);

INSERT INTO "product_parent_category" VALUES
(1000, 200),
(2000, 300),
(3000, 300),
(4000, 500),
(5000, 600);