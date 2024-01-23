CREATE TABLE IF NOT EXISTS accounts (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    "name" VARCHAR(255) NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance_id UUID REFERENCES balance(id),
    currency_id INT REFERENCES currencies(id)
);

INSERT INTO accounts("name", account_type, balance_id, currency_id) VALUES
('Compte courant', 'Banque', '27ca835a-b532-4903-a302-4fdf90f5a631', 1),
('Compte épargne', 'Espèce', '30420c9c-72f6-4022-9f03-33703ffacd50', 2);