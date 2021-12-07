package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Book;
import entities.Purchase;
import entities.User;
import models.PurchaseModel;

public class PurchaseController {
    private PurchaseModel purchaseModel;

    public PurchaseController(PurchaseModel purchaseModel) {
        this.purchaseModel = purchaseModel;
    }

    public ArrayList<Purchase> getPurchase(String userId)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ArrayList<Purchase> purchase = new ArrayList<>();
        purchase = purchaseModel.getAllPurchases(userId);
        return purchase;
    }

    public Purchase createPurchase(Book book, User purchased)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return purchaseModel.createPurchase(book, purchased);
    }

    public void deletePurchase(String userId)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        purchaseModel.deletePurchase(userId);

    }
}
