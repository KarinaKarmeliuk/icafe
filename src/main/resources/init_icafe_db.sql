CREATE DATABASE icafe_db;

CREATE TABLE coffee_sorts
(
    id integer NOT NULL PRIMARY KEY,
    sort_name character varying(255) NOT NULL,
    price double precision NOT NULL,
    disabled boolean NOT NULL
);

CREATE TABLE order_items
(
    id integer NOT NULL PRIMARY KEY,
    id_coffee_sort integer NOT NULL,
    quantity integer NOT NULL
);

CREATE TABLE orders
(
    id integer NOT NULL PRIMARY KEY,
    data_time timestamp without time zone NOT NULL,
    total_cost double precision NOT NULL,
    client_name character varying(255) NOT NULL,
    delivery_address character varying(255) NOT NULL
);

INSERT INTO coffee_sorts VALUES (1, 'Arabica', 5.0, 'N');
INSERT INTO coffee_sorts VALUES (2, 'Robusta', 6.5, 'N');
INSERT INTO coffee_sorts VALUES (3, 'Latte', 4.0, 'N');
INSERT INTO coffee_sorts VALUES (4, 'Mocco', 5.5, 'Y');

drop table coffee_sorts;
drop table order_items;
drop table orders;

select * from coffee_sorts;
select * from order_items;
select * from orders;