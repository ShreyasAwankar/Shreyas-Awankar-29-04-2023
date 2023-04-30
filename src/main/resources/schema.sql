CREATE TABLE customer (
	id BIGINT not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	mobile_number varchar(15) not null
);
ALTER TABLE customer ADD CONSTRAINT customer_uk1 UNIQUE (mobile_number);

CREATE SEQUENCE customer_seq
START WITH 5
INCREMENT BY 1;

CREATE TABLE mobile_numbers (
	id BIGINT  ,
	mobile_number varchar(15) not null,
	PRIMARY KEY (id)
);
ALTER TABLE customer ADD CONSTRAINT mobile_number_uk1 UNIQUE (mobile_number);

