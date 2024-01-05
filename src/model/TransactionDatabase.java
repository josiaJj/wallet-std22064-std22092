package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDatabase {
    private List<Categorie> categories = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addCategory(int categoryId, String categoryName) {
        Categorie category = new Categorie();
        category.setId(categoryId);
        category.setNom(categoryName);
        categories.add(category);
    }

    public void addTransaction(int id, int id_compte, String type_transaction, Double montant, Date date_transaction, int categoryId) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setId_compte(id_compte);
        transaction.setType_transaction(type_transaction);
        transaction.setMontant(montant);
        transaction.setDate_transaction(date_transaction);
        transactions.add(transaction);
    }

    public static void main(String[] args) {
        TransactionDatabase database = new TransactionDatabase();

        // Ajouter des catégories
        database.addCategory(1, "Salaire");
        database.addCategory(2, "Autres revenus");
        database.addCategory(3, "Restaurant");
        database.addCategory(4, "Téléphone et Multimédia");
        database.addCategory(5, "Autres dépenses");
        database.addCategory(6, "Prêt");

        // Ajouter des transactions
        database.addTransaction(1, 123, "Dépense", 50.0, new Date(), 3);  // Exemple de transaction


        // Afficher les catégories et les transactions
        System.out.println("Categories: " + database.categories);
        System.out.println("Transactions: " + database.transactions);
    }
}
