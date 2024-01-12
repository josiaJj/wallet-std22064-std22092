CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    balance NUMERIC NOT NULL,
    updated_balance TIMESTAMP DEFAULT current_timestamp,
    account_type VARCHAR(20) NOT NULL,
    currency_id INT,
    FOREIGN KEY (currency_id) REFERENCES currency(id)
);