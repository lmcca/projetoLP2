package sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entities.TesteDB;
import entities.User;

public class UserSql implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean createUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "INSERT INTO [dbo].[User]\r\n"
				+ "           ([id]\r\n"
				+ "           ,[email]\r\n"
				+ "           ,[name]\r\n"
				+ "           ,[password]\r\n"
				+ "           ,[address]\r\n"
				+ "           ,[createdAt]\r\n"
				+ "           ,[updatedAt])\r\n"
				+ "     VALUES\r\n"
				+ "           (?,\r\n"
				+ "           ?,\r\n"
				+ "           ?,\r\n"
				+ "           ?,\r\n"
				+ "           ?,\r\n"
				+ "           ?,\r\n"
				+ "           ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, user.getId());
		statement.setObject(2, user.getEmail());
		statement.setObject(3, user.getName());
		statement.setObject(4, user.getPassword());
		statement.setObject(5, user.getAddress());
		statement.setObject(6, user.getCreatedAt());
		statement.setObject(7, null);
		
		return !statement.execute();
	}
	
	public User getUserByEmail(String emailUser) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		User user = null;
		String sql = "SELECT [id]\r\n"
				+ "      ,[email]\r\n"
				+ "      ,[name]\r\n"
				+ "      ,[password]\r\n"
				+ "      ,[address]\r\n"
				+ "      ,[createdAt]\r\n"
				+ "      ,[updatedAt]\r\n"
				+ "  FROM [dbo].[User]\r\n"
				+ "  WHERE email=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, emailUser);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString(1);
			String email = rs.getString(2);
			String name = rs.getString(3);
			String address = rs.getString(5);
			LocalDate createdAt= LocalDate.parse(rs.getString(6).split(" ")[0]);
			LocalDate updatedAt = null;
			
			if (rs.getString(7) != null){
				updatedAt = LocalDate.parse(rs.getString(7).split(" ")[0]);
			}
			
			 user = new User(id, null, email, name, address, createdAt, updatedAt);
			
			
		}
		
		return user;
	}
	
	public User getUserById(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		User user = null;
		String sql = "SELECT [id]\r\n"
				+ "      ,[email]\r\n"
				+ "      ,[name]\r\n"
				+ "      ,[password]\r\n"
				+ "      ,[address]\r\n"
				+ "      ,[createdAt]\r\n"
				+ "      ,[updatedAt]\r\n"
				+ "  FROM [dbo].[User]\r\n"
				+ "  WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, userId);
		
		ResultSet rs = statement.executeQuery();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:nn:ss");
		while(rs.next()) {
			String id = rs.getString(1);
			String email = rs.getString(2);
			String name = rs.getString(3);
			String address = rs.getString(5);
			System.out.println(rs.getString(6));
			LocalDate createdAt = LocalDate.parse(rs.getString(6).split(" ")[0]) ;
			LocalDate updatedAt = null;
			
			if (rs.getString(7) != null){
				updatedAt = LocalDate.parse(rs.getString(7).split(" ")[0]) ;
			}
			
			 user = new User(id, null, email, name, address, createdAt, updatedAt);
			
			
		}
		
		return user;
	}
	
	public ArrayList<User> getAllUsers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT [id]\r\n"
				+ "      ,[email]\r\n"
				+ "      ,[name]\r\n"
				+ "      ,[password]\r\n"
				+ "      ,[address]\r\n"
				+ "      ,[createdAt]\r\n"
				+ "      ,[updatedAt]\r\n"
				+ "  FROM [dbo].[User]\r\n"
				+ "GO";
		
		ResultSet rs = connection.prepareStatement(sql).executeQuery();
		
		while(rs.next()) {
			String id = rs.getString(1);
			String email = rs.getString(2);
			String name = rs.getString(3);
			String address = rs.getString(5);
			LocalDate createdAt= LocalDate.parse(rs.getString(6).split(" ")[0]);
			LocalDate updatedAt = null;
			
			if (rs.getString(7) != null){
				updatedAt = LocalDate.parse(rs.getString(7).split(" ")[0]);
			}
			
			User user = new User(id, null, email, name, address, createdAt, updatedAt);
			users.add(user);
			
		}
		
		return users;
	}

	
	public boolean updateUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "UPDATE [dbo].[User]\r\n"
				+ "   SET [email] =?\r\n"
				+ "      ,[name] =?\r\n"
				+ "      ,[address] =?\r\n"
				+"		 ,[updatedAt] =?\r\n"
				+ " WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, user.getEmail());
		statement.setObject(2, user.getName());
		statement.setObject(3, user.getAddress());
		statement.setObject(4, user.getUpdatedAt());
		statement.setObject(5, user.getId());
		return !statement.execute();
	
	}
	
	public boolean deleteUser(String id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection connection = new TesteDB().call(); 
		String sql = "DELETE FROM [dbo].[User]\r\n"
				+ "WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, id);
		return !statement.execute();
	}

}


