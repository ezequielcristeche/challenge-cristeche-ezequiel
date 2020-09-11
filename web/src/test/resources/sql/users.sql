DROP TABLE users if exists CASCADE;

CREATE TABLE users (
     id UUID NOT NULL,
     name VARCHAR(60) NOT NULL,
     email VARCHAR(256) NOT NULL,
     password VARCHAR(60) NOT NULL,
     PRIMARY KEY (id));

INSERT INTO users (id, name, email, password)
VALUES ('d701748f-6c54-4b01-90e6-d701748f0822', 'ezequiel', 'eze@gmail.com', '1234');