drop table product;
CREATE TABLE PRODUCT (oid CHAR(16) FOR BIT DATA, description VARCHAR(2048) NOT NULL, image BLOB(2147483647), inventory_qty INTEGER, price FLOAT, product_name VARCHAR(35) NOT NULL UNIQUE, PRIMARY KEY (oid))
