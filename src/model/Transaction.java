package model;

import java.text.DecimalFormat;
import java.util.Date;

public class Transaction {
    private int id ;
    private int id_compte;
    private String type_transaction;
    private Double montant ;
    private Date date_transaction ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public String getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        this.type_transaction = type_transaction;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(Date date_transaction) {
        this.date_transaction = date_transaction;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Transaction{" +
                "id=" + id +
                ", id_compte=" + id_compte +
                ", type_transaction='" + type_transaction + '\'' +
                ", montant=" + df.format(montant) +
                ", date_transaction=" + date_transaction +
                '}';
    }
}


