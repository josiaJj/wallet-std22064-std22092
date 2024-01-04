
CREATE FUNCTION calculerSommeTransactions(
    IN compteID INT,
    IN dateDebut DATETIME,
    IN dateFin DATETIME
)
RETURNS DECIMAL(10, 2)
BEGIN
    DECLARE somme DECIMAL(10, 2);

    SELECT SUM(CASE WHEN type_transaction = 'ENTREE' THEN montant ELSE -montant END)
    INTO somme
    FROM transactions
    WHERE id_compte = compteID
      AND date_transaction BETWEEN dateDebut AND dateFin;

    IF somme IS NULL THEN
        SET somme = 0;
    END IF;

    RETURN somme;
END;