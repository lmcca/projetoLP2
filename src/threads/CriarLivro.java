package threads;

import java.sql.SQLException;

import controllers.BookController;
import entities.User;

public class CriarLivro extends Thread{
    private BookController bookController;
    private User user;
    private String titulo, autor, sinopse;
    
    public CriarLivro(String titulo,String autor, String sinopse, User user, BookController bookController){
        this.titulo = titulo;
        this.autor = autor;
        this.sinopse = sinopse;
        this.user = user;
        this.bookController = bookController;
    }
    public void run(){
        try {
            bookController.createBook(titulo, autor, sinopse,null,null, this.user);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
