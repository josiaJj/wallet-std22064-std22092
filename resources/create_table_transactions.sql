CREATE TABLE IF NOT EXISTS transactions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    label VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL,
    date_time TIMESTAMP DEFAULT current_timestamp,
    transaction_type VARCHAR(10) NOT NULL,
    account_id UUID REFERENCES accounts(id)
);

INSERT INTO transactions (label, amount, transaction_type, account_id) VALUES
('Achat d''un piano', '4000000', 'débit', 'c1fd1d6d-0e80-4e2d-a5f2-72fa6f274de9'),
('Bénéfice affaire bijouts', '10000000', 'crédit', 'c1fd1d6d-0e80-4e2d-a5f2-72fa6f274de9');
