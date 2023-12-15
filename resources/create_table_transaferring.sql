CREATE TABLE IF NOT EXISTS transferring (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    amount DECIMAL DEFAULT 0,
    datetime TIMESTAMP DEFAULT current_timestamp,
    accountId1 uuid REFERENCES accounts(id) NOT NULL,
    accountId2 uuid REFERENCES accounts(id) NOT NULL
);