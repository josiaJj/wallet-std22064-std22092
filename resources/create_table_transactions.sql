CREATE TABLE IF NOT EXISTS transactions (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    account_id INT REFERENCES accounts(id)
);
