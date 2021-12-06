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
import entities.TesteDB;
import entities.User;

public class BookSql implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean createBook(Book book) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "INSERT INTO [dbo].[Book]\r\n"
				+ "           ([id]\r\n"
				+ "           ,[title]\r\n"
				+ "           ,[author]\r\n"
				+ "           ,[sinopse]\r\n"
				+ "           ,[cover]\r\n"
				+ "           ,[lauchAt]\r\n"
				+ "           ,[createdAt]\r\n"
				+ "           ,[updatedAt]\r\n"
				+ "           ,[createdBy])\r\n"
				+ "     VALUES\r\n"
				+ "           (?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,?\r\n"
				+ "           ,null\r\n"
				+ "           ,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setObject(1, book.getId());
		statement.setObject(2, book.getTitle());
		statement.setObject(3, book.getAuthor());
		statement.setObject(4, book.getSinopse());
		statement.setObject(5, book.getCover());
		statement.setObject(6, Timestamp.valueOf(book.getCreatedAt()));
		statement.setObject(7, Timestamp.valueOf(book.getCreatedAt()));
		//statement.setObject(8, null);
		statement.setObject(8, book.getCreatedBy().getId());
		
		return !statement.execute();
	}
	
	private Book fromToBook(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Book book = null;
		while(rs.next()) {
			UserSql userSql = new UserSql();
			String id = rs.getString(1);
			String title = rs.getString(2);
			String author = rs.getString(3);
			String sinopse = rs.getString(4);
			String cover = rs.getString(5);
			User createdBy = userSql.getUserById(rs.getString(9));

			
			LocalDate d = LocalDate.parse(rs.getString(6).split(" ")[0]);
			LocalTime l = LocalTime.parse(rs.getString(6).split(" ")[1]);
			LocalDateTime lauchAt = LocalDateTime.of(d, l);
			
			d = LocalDate.parse(rs.getString(7).split(" ")[0]);
			l = LocalTime.parse(rs.getString(7).split(" ")[1]);
			
			LocalDateTime createdAt= LocalDateTime.of(d,l);
			LocalDateTime updatedAt = null;
						
			if (rs.getString(8) != null){
				d = LocalDate.parse(rs.getString(8).split(" ")[0]);
				l = LocalTime.parse(rs.getString(8).split(" ")[1]);
				updatedAt = LocalDateTime.of(d,l);
			}
			
			 book = new Book(id, title, author, sinopse, cover, lauchAt, createdAt, updatedAt, createdBy);
			
		}return book;
	}
	
	public Book getBookById(String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "SELECT [id]\r\n"
				+ "           ,[title]\r\n"
				+ "           ,[author]\r\n"
				+ "           ,[sinopse]\r\n"
				+ "           ,[cover]\r\n"
				+ "           ,[lauchAt]\r\n"
				+ "           ,[createdAt]\r\n"
				+ "           ,[updatedAt]\r\n"
				+ "           ,[createdBy]\r\n"
				+ "  FROM [dbo].[Book]\r\n"
				+ "  WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, bookId);

		return fromToBook(statement.executeQuery());
	}
	
	public ArrayList<Book> getBooksByTitle(String bookTitle) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "SELECT [id]\r\n"
				+ "           ,[title]\r\n"
				+ "           ,[author]\r\n"
				+ "           ,[sinopse]\r\n"
				+ "           ,[cover]\r\n"
				+ "           ,[lauchAt]\r\n"
				+ "           ,[createdAt]\r\n"
				+ "           ,[updatedAt]\r\n"
				+ "           ,[createdBy])\r\n"
				+ "  FROM [dbo].[Book]\r\n"
				+ "  WHERE title=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, bookTitle);
		
		ResultSet rs = connection.prepareStatement(sql).executeQuery();
		
		while(rs.next()) {
			Book book = fromToBook(rs);
			if(book != null) {
				books.add(book);
			}
		}
		return books;
	}
	
	public ArrayList<Book> getAllBooks() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "SELECT [id]\r\n"
				+ "           ,[title]\r\n"
				+ "           ,[author]\r\n"
				+ "           ,[sinopse]\r\n"
				+ "           ,[cover]\r\n"
				+ "           ,[lauchAt]\r\n"
				+ "           ,[createdAt]\r\n"
				+ "           ,[updatedAt]\r\n"
				+ "           ,[createdBy])\r\n"
				+ "  FROM [dbo].[Book]\r\n";
		
		ResultSet rs = connection.prepareStatement(sql).executeQuery();
		
		while(rs.next()) {
			UserSql userSql = new UserSql();
			String id = rs.getString(1);
			String title = rs.getString(2);
			String author = rs.getString(3);
			String sinopse = rs.getString(4);
			String cover = rs.getString(5);
			LocalDateTime lauchAt = LocalDateTime.parse(rs.getString(6).split(" ")[0]);
			LocalDateTime createdAt= LocalDateTime.parse(rs.getString(7).split(" ")[0]);
			LocalDateTime updatedAt = null;
			User createdBy = userSql.getUserById(rs.getString(9));
			
			if (rs.getString(8) != null){
				updatedAt = LocalDateTime.parse(rs.getString(8).split(" ")[0]);
			}
			
			Book book = new Book(id, title, author, sinopse, cover, lauchAt, createdAt, updatedAt, createdBy);
			books.add(book);
			
		}
		
		return books;
	}

	
	public boolean updateBook(Book book) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "UPDATE [dbo].[Book]\r\n"
				+ "SET [title]=?\r\n"
				+ "           ,[author]=?\r\n"
				+ "           ,[sinopse]=?\r\n"
				+ "           ,[cover]=?\r\n"
				+ "           ,[lauchAt]=?\r\n"
				+ "           ,[updatedAt]=?\r\n"
				+ "WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setObject(1, book.getTitle());
		statement.setObject(2, book.getAuthor());
		statement.setObject(3, book.getSinopse());
		statement.setObject(4, book.getCover());
		statement.setObject(5, book.getDateLauch());
		statement.setObject(6, book.getUpdatedAt());
		statement.setObject(7, book.getId());
		return !statement.execute();
	
	}
	
	public boolean deleteBook(String id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "DELETE FROM [dbo].[Book]\r\n"
				+ "WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, id);
		return !statement.execute();
	}
}
