CREATE TABLE IF NOT EXISTS currencies (
    id INT PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    code VARCHAR(3) NOT NULL
);

INSERT INTO "currencies" ("name", code) VALUES
(1, 'Ariary', 'MGA'),
(2, 'Euro', 'EUR');
