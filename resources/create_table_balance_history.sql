CREATE TABLE IF NOT EXISTS balance_history (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    "value" DECIMAL DEFAULT 0,
    updateDateTime TIMESTAMP DEFAULT current_timestamp,
    accountId uuid REFERENCES "account"(id) NOT NULL
);