CREATE TABLE IF NOT EXISTS balance (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    "value" DECIMAL DEFAULT 0,
    update_dateTime TIMESTAMP DEFAULT current_timestamp,
    account_id uuid REFERENCES "accounts"(id) NOT NULL
);