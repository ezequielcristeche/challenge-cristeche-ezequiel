DROP TABLE listings if exists CASCADE;

CREATE TABLE listings (
  id UUID NOT NULL,
  owner_id UUID NOT NULL,
  name VARCHAR(60) NOT NULL,
  slug VARCHAR(60) NOT NULL,
  description VARCHAR(256) NOT NULL,
  adults INT(11) NOT NULL,
  childrens INT(11) NOT NULL,
  is_pets_allowed BOOLEAN NOT NULL,
  base_price DECIMAL(10,4) NOT NULL,
  cleaning_fee DECIMAL(10,4) NOT NULL,
  image_url VARCHAR(256) NOT NULL,
  weekly_discount DECIMAL(10,4) NOT NULL,
  monthly_discount DECIMAL(10,4) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT listings_users_fk FOREIGN KEY (owner_id) REFERENCES users (id));


INSERT INTO listings (id, owner_id, name, slug, description, adults, childrens, is_pets_allowed, base_price, cleaning_fee, image_url, weekly_discount, monthly_discount)
VALUES('d8fc6289-d2de-4331-bec2-d1ae86286a94','d701748f-6c54-4b01-90e6-d701748f0822','Listado creado','Listado creado','Listado Test', 5, 6, true, 100.50, 15.50, '/image.ffff', 10.10, 10.50);