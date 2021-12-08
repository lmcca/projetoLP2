package threads;

import java.sql.SQLException;

import controllers.UserController;

public class LoginUser {
    private UserController userController;
    String email,  senha;

    public LoginUser(String email, String senha, UserController userController){
        this.email = email;
        this.senha = senha;
        this.userController = userController;
    }
    
    public void run(){
        try {
             userController.getUserByEmail(email);
            System.out.println("user criado");
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
