package threads;

import java.sql.SQLException;

import controllers.UserController;

public class CriarUser {
    private UserController userController;
    String email, nome, cep, senha;

    public CriarUser(String email, String nome, String cep, String senha, UserController userController){
        this.email = email;
        this.cep = cep;
        this.nome = nome;
        this.senha = senha;
        this.userController = userController;
    }
    
    public void run(){
        try {
             userController.createUser(email, nome, senha,
                    cep);
            System.out.println("user criado");
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
