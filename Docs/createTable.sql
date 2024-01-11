CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_compte INT NOT NULL,
    type_transaction VARCHAR(50) NOT NULL,
    montant DECIMAL(10, 2) NOT NULL,
    date_transaction DATETIME NOT NULL,
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) UNIQUE NOT NULL
);

ALTER TABLE transactions
ADD COLUMN id_categorie INT UNIQUE,
ADD CONSTRAINT fk_categorie FOREIGN KEY (id_categorie) REFERENCES categories(id);

ALTER TABLE categories
ADD COLUMN sens_transaction VARCHAR(50) NOT NULL CHECK (sens_transaction IN ('ENTREE', 'SORTIE', 'LES_DEUX'));
