CREATE TABLE IF NOT EXISTS accounts (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    "name" VARCHAR(255) NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    currency_id INT REFERENCES currencies(id)
);