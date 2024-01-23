CREATE TABLE IF NOT EXISTS currencies (
    id INT PRIMARY KEY,
    "name" VARCHAR(200) NOT NULL,
    code VARCHAR(5) NOT NULL
);

INSERT INTO "currencies" (id, "name", code) VALUES
(1, 'Ariary', 'MGA'),
(2, 'Euro', 'EUR');
