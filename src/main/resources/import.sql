DROP TABLE Products IF EXISTS;
CREATE TABLE Products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO Products (title, price) VALUES ('Fax', 15000), ('Phone', 20000), ('TVset', 80000);
