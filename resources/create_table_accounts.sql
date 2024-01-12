CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP DEFAULT current_timestamp;
    balance NUMERIC NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    currency_id INT,
    FOREIGN KEY (currency_id) REFERENCES currency(id)
);