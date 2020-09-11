DROP TABLE special_prices IF EXISTS CASCADE;

CREATE TABLE special_prices (
    id UUID NOT NULL,
    listing_id UUID NOT NULL,
    special_price_date TIMESTAMP NOT NULL,
    price DECIMAL (10,4) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT special_prices_listings_fk FOREIGN KEY (listing_id) REFERENCES listings (id) ON DELETE CASCADE);


INSERT INTO special_prices (id, listing_id, special_price_date, price)
VALUES ('da7032aa-9c69-49bf-887f-c72c1131de35', 'd8fc6289-d2de-4331-bec2-d1ae86286a94', '2020-09-11', 108.56);