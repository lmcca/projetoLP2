package models;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;
import entities.User;
import sql.UserSql;

public class UserModel {
	UserSql userSql = new UserSql();
	
	public User createUser(String email, String name, String password, String address) throws SQLException {
	
		User user = new User(UUID.randomUUID().toString(), email, name, password, address, LocalDateTime.now(), null);
			
		userSql.createUser(user);
		
		return user;
	}
	
	public User getUserByEmail(String userEmail) throws SQLException {
		return userSql.getUserByEmail(userEmail);
	}
	
	public User getUserById(String userId) throws SQLException {
		return userSql.getUserById(userId);
	}
	
	public boolean updatedUser(User user) throws SQLException {
		return userSql.updateUser(user);
	}
	
	public boolean deleteUser(String userId) throws SQLException {
		return userSql.deleteUser(userId);
	}	
}
