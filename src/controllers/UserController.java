package controllers;

import java.sql.SQLException;

import entities.User;
import models.UserModel;

public class UserController {
    private UserModel userModel;

    public UserController(UserModel userModel){
        this.userModel = userModel;
    }

    public User createUser(String email, String name, String password, String address) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        return userModel.createUser(email, name, password, address);
    }

    public User getUserByEmail(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        return userModel.getUserByEmail(email);
    }

    public User getUserById(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        return userModel.getUserById(id);
    }

    public void updatedUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
         userModel.updatedUser(user);
    }

    public void deleteUser(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        userModel.deleteUser(id);
    }
    
}
