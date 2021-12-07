package sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import entities.Book;
import entities.Purchase;
import entities.TesteDB;
import entities.User;

public class PurchaseSql implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean createPurchase(Purchase purchase) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "INSERT INTO [dbo].[Purchase]\r\n"
				+ "           ([idP]\r\n"
				+ "           ,[book]\r\n"
				+ "           ,[purchaseBy]\r\n"
				+ "           ,[createdAtP]\r\n"
				+ "           ,[updatedAtP]\r\n"
				+ "     VALUES\r\n"
				+ "           (?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,null\r\n)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, purchase.getId());
		statement.setObject(2, purchase.getBook().getId());
		statement.setObject(6, purchase.getPurchased().getId());
		statement.setObject(7, Timestamp.valueOf(purchase.getCreatedAt()));
		statement.setObject(8, null);
		
		return !statement.execute();
	}
	
	private Purchase fromToPurchase(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		UserSql userSql = new UserSql();
		BookSql bookSql = new BookSql();
		
		String id = rs.getString(1);
		Book book = bookSql.getBookById(rs.getString(2));
		User purchased = userSql.getUserById(rs.getString(3));
		
		LocalDate d = LocalDate.parse(rs.getString(4).split(" ")[0]);
		LocalTime l = LocalTime.parse(rs.getString(4).split(" ")[1]);
		
		LocalDateTime createdAt= LocalDateTime.of(d,l);
		LocalDateTime updatedAt = null;
					
		if (rs.getString(5) != null){
			d = LocalDate.parse(rs.getString(5).split(" ")[0]);
			l = LocalTime.parse(rs.getString(5).split(" ")[1]);
			updatedAt = LocalDateTime.of(d,l);
		}
		
		Purchase purchase = new Purchase(id, book, purchased, createdAt, updatedAt);
		return purchase;
	}
	
	public Purchase getPurchaseById(String purchaseId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		
		String sql = "SELECT [idP]\r\n"
				+ "           ,[book]\r\n"
				+ "           ,[purchased]\r\n"
				+ "           ,[createdAtP]\r\n"
				+ "           ,[updatedAtP]\r\n"
				+ "  FROM [dbo].[Purchase]\r\n"
				+ "  WHERE idP=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, purchaseId);
		
		return fromToPurchase(statement.executeQuery());
	}
	
	public ArrayList<Purchase> getAllPurchases(String purchasedId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		String sql = "SELECT [idP]\r\n"
				+ "           ,[bookId]\r\n"
				+ "           ,[purchasedId]\r\n"
				+ "           ,[createdAtP]\r\n"
				+ "           ,[updatedAtP]\r\n"
				+ "  FROM [dbo].[Purchased]\r\n"
				+ "  WHERE purchasedId=?\r\n";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1,purchasedId);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Purchase purchase = fromToPurchase(rs);
			
			if(purchase != null) {
				purchases.add(purchase);
			}
			
		}
		
		return purchases;
	}
	
	public boolean deletePurchase(String id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		
		String sql = "DELETE FROM [dbo].[Purchase]\r\n"
				+ "WHERE idP=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, id);
		return !statement.execute();
	}
}
