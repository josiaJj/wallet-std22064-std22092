CREATE TABLE IF NOT EXISTS balance (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    "value" FLOAT DEFAULT 0,
    updated_dateTime TIMESTAMP DEFAULT current_timestamp
);

INSERT IGNORE INTO balance("value")
VALUES (250000), (350000);