CREATE TABLE IF NOT EXISTS currencies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(3) NOT NULL
);

INSERT IGNORE INTO "currency" (name, code) VALUES
    ('Ariary', 'MGA'),
    ('Euro', 'EUR');
