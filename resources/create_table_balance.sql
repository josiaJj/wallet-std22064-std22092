CREATE TABLE IF NOT EXISTS balance (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    "value" DECIMAL DEFAULT 0,
    updateDateTime TIMESTAMP DEFAULT current_timestamp,
    account_id SERIAL REFERENCES "accounts"(id) NOT NULL
);