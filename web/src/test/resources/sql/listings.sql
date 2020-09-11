DROP TABLE listings if exists CASCADE;

CREATE TABLE listings (
  id UUID NOT NULL,
  owner_id UUID NOT NULL,
  name VARCHAR(60) NOT NULL,
  slug VARCHAR(60) NOT NULL,
  description VARCHAR(256) NOT NULL,
  adults VARCHAR(60) NOT NULL,
  children VARCHAR(60) NOT NULL,
  is_pets_allowed BOOLEAN NOT NULL,
  base_price DECIMAL(10,4) NOT NULL,
  cleaning_fee DECIMAL(10,4) NOT NULL,
  image_url VARCHAR(256) NOT NULL,
  weekly_discount DECIMAL(10,4) NOT NULL,
  monthly_discount DECIMAL(10,4) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (owner_id) REFERENCES users (id));