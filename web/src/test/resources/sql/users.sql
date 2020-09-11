DROP TABLE users if exists CASCADE;

CREATE TABLE users (
     id UUID NOT NULL,
     name VARCHAR(60) NOT NULL,
     email VARCHAR(60) NOT NULL,
     password VARCHAR(60) NOT NULL,
     PRIMARY KEY (id));