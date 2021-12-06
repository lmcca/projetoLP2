package models;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import entities.User;
import sql.UserSql;

public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserSql userSql = new UserSql();
	
	public User createUser(String email, String name, String password, String address) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		User user = new User(UUID.randomUUID().toString(), email, name, password, address, LocalDate.now(), null);
			
		userSql.createUser(user);
		
		return user;
	}
	
	public User getUserByEmail(String userEmail) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return userSql.getUserByEmail(userEmail);

	}
	
	public User getUserById(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return userSql.getUserById(userId);
	}
	
	public boolean updatedUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return userSql.updateUser(user);
	}
	
	public boolean deleteUser(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return userSql.deleteUser(userId);
	}	
}
