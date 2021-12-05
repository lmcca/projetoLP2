package models;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import entities.Book;
import entities.Purchase;
import entities.User;
import sql.PurchaseSql;

public class PurchaseModel {
	private PurchaseSql purchaseSql = new PurchaseSql();
	
	public Purchase createPurchase(Book book, User purchased) throws SQLException {
		Purchase purchase = new Purchase(UUID.randomUUID().toString(), book, purchased,LocalDateTime.now(), null);
		
		purchaseSql.createPurchase(purchase);
		
		return purchase;
	}
	
	public Purchase getPurchaseById(String purchaseId) throws SQLException {
		return purchaseSql.getPurchaseById(purchaseId);
	}
	
	public ArrayList<Purchase> getAllPurchases(String purchasedId) throws SQLException{
		return purchaseSql.getAllPurchases(purchasedId);
	}
	
	public boolean deletePurchase(String purchaseId) throws SQLException {
		return purchaseSql.deletePurchase(purchaseId);
	}
}
