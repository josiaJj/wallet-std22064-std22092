INSERT INTO categories (nom, sens_transaction) VALUES
    ('Salaire', 'ENTREE'),
    ('Dépense restaurant', 'SORTIE'),
    ('Prêt', 'LES_DEUX'),
    ('Autre catégorie crédit', 'ENTREE'),
    ('Autre catégorie débit', 'SORTIE');

INSERT INTO transactions (id_compte, type_transaction, montant, date_transaction, id_categorie)
VALUES
    (1, 'ENTREE', 2000.00, '2024-01-01 08:00:00', 1),
    (1, 'SORTIE', 50.00, '2024-01-02 12:30:00', 2),
    (1, 'ENTREE', 500.00, '2024-01-03 15:45:00', 3),
    (1, 'SORTIE', 200.00, '2024-01-04 18:30:00', 3);

-- Insérer la catégorie "Salaire"
INSERT IGNORE INTO categories (id, name) VALUES (1, 'Salaire');

-- Insérer la catégorie "Autres revenus"
INSERT IGNORE INTO categories (id, name) VALUES (2, 'Autres revenus');

-- Insérer la catégorie "Restaurant"
INSERT IGNORE INTO categories (id, name) VALUES (3, 'Restaurant');

-- Insérer la catégorie "Téléphone et Multimédia"
INSERT IGNORE INTO categories (id, name) VALUES (4, 'Téléphone et Multimédia');

-- Insérer la catégorie "Autres dépenses"
INSERT IGNORE INTO categories (id, name) VALUES (5, 'Autres dépenses');

-- Insérer la catégorie "Prêt"
INSERT IGNORE INTO wallet_categories (id, name) VALUES (6, 'Prêt');
