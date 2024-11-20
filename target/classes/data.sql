INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Soups');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Pasta');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Meats');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Salads');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Desserts');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Drinks');
INSERT INTO categories VALUES (nextval('categories_id_seq'), 'Alcohol');


INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Tomato Soup', 9.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Fish Soup', 14.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Lentil Soup', 9.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Bean Soup', 10.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Vegetable Soup', 11.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Chicken Soup', 13.99, current_timestamp, 1);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Mushroom Soup', 12.99, current_timestamp, 1);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Spaghetti Bolognese', 14.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Penne alla Vodka', 13.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Fettuccine Alfredo', 15.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Ricotta and Spinach Ravioli', 16.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Gnocchi Sorrentina', 14.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Tagliatelle with Pesto Sauce', 17.99, current_timestamp, 2);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Lasagne al Forno', 18.99, current_timestamp, 2);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Sewed Sal', 14.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Baked Pork Poin with Garlic', 17.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Stewed Chicken in Tomato Sauce', 16.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Roasted Leg of Lamb', 19.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Stewed Rabbit', 18.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Sausages Stewed with Beans', 15.99, current_timestamp, 3);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Roasted Duck', 20.99, current_timestamp, 3);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Caprese Salad', 16.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Caesar Salad', 18.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Nicoise Salad', 19.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Melon and Prosciutto Salad', 17.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Pasta Salad', 15.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Grilled Chicken Salad', 21.99, current_timestamp, 4);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Mushroom and Arugula Salad', 20.99, current_timestamp, 4);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Cheesecake', 12.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Apple Pie', 11.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Gingerbread', 10.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Brownie', 9.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Lemon Curd Tart', 13.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Chocolate Cake', 12.99, current_timestamp, 5);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Strawberry Shortcake', 14.99, current_timestamp, 5);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Water', 0.99, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Tea (black/green)', 2.99, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Latte', 5.99, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Espresso', 2.49, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Cappuccino', 4.49, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Juice (orange/apple)', 3.49, current_timestamp, 6);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Fizzy drink(cola/pepsi/fanta/sprite)', 2.99, current_timestamp, 6);

INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'White wine', 16.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Red wine', 18.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Vodka', 14.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Whiskey', 22.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Stout', 12.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Pale ale', 11.99, current_timestamp, 7);
INSERT INTO dishes VALUES (nextval('dishes_id_seq'), 'Bitter beer', 11.99, current_timestamp, 7);


SELECT * FROM categories;
SELECT * FROM dishes;
