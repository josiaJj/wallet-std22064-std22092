CREATE FUNCTION sommeParCategorie(
    IN compteID int,
    IN dateDebut DATETIME,
    IN dateFin DATETIME
)
RETURNS TABLE (categorie VARCHAR(255), somme DECIMAL(10, 2))
BEGIN
    DECLARE sommeParCategorie TABLE (categorie VARCHAR(255), somme DECIMAL(10, 2));

    SELECT c.nom_categorie, COALESCE(SUM(t.montant), 0) as somme
    FROM categories c
    LEFT JOIN transactions t ON c.id_categorie = t.id_categorie
                           AND t.date_transaction BETWEEN dateDebut AND dateFin
                           AND t.id_compte = compteID
    GROUP BY c.nom_categorie;

    RETURN sommeParCategorie;
    INSERT INTO sommeParCategorie (categorie, somme)
END;
