CREATE TABLE IF NOT EXISTS transactions (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    account_id VARCHAR(50) REFERENCES accounts(id)
);

INSERT INTO transactions (label, amount, date_time, transaction_type, account_id)
VALUES ("Prêt bancaire", "10000")
