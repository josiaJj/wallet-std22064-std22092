CREATE TABLE IF NOT EXISTS currency_value (
    id BIGSERIAL PRIMARY KEY,
    currency_src INT REFERENCES currencies(id),
    currency_dest INT REFERENCES currencies(id),
    amount DECIMAL NOT NULL,
    date_effect TIMESTAMP DEFAULT current_timestamp
);

INSERT IGNORE INTO "currency_value" (currency_source, currency_destination, amount) VALUES
(2, 1, 1_300),
(2, 1, 6_700);