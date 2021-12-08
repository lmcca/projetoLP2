package threads;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import controllers.BookController;

public class ExcluirLivro extends Thread{
    private String bookId;
    private BookController bookController;

    public ExcluirLivro(String bookId, BookController bookController){
        this.bookId = bookId;
        this.bookController = bookController;
    }
    
    @Override
    public void run() {
        try {
            this.bookController.deleteBook(bookId);
            JOptionPane.showMessageDialog(null, "Livro foi excluido com sucesso!");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
        }
    }
}
