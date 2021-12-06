package models;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import entities.Book;
import entities.Purchase;
import entities.User;
import sql.PurchaseSql;

public class PurchaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PurchaseSql purchaseSql = new PurchaseSql();
	
	public Purchase createPurchase(Book book, User purchased) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Purchase purchase = new Purchase(UUID.randomUUID().toString(), book, purchased,LocalDateTime.now(), null);
		
		purchaseSql.createPurchase(purchase);
		
		return purchase;
	}
	
	public Purchase getPurchaseById(String purchaseId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return purchaseSql.getPurchaseById(purchaseId);
	}
	
	public ArrayList<Purchase> getAllPurchases(String purchasedId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		return purchaseSql.getAllPurchases(purchasedId);
	}
	
	public boolean deletePurchase(String purchaseId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return purchaseSql.deletePurchase(purchaseId);
	}
}
