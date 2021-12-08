package threads;

import entities.Book;
import entities.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.swing.JOptionPane;

import controllers.BookController;
import controllers.PurchaseController;


public class PegarLivro extends Thread{
    private BookController bookController;
    private PurchaseController purchaseController;
    private String bookId;
    private User user;

    public PegarLivro(User user, BookController bookController, PurchaseController purchaseController, String bookId){
        this.bookController = bookController;
        this.purchaseController = purchaseController;
        this.bookId = bookId;
        this.user = user;
    }

    @Override
    public void run() {
       
            try{
                Book book = this.bookController.getBookById(bookId);
				if(Objects.isNull(book)){
					JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
				}else{
					
						if(book.getPurchased()){
							JOptionPane.showMessageDialog(null, "Ops, esse livro ja foi pego, atualize sua tela!");
						}else{
							book.setPurchased(true);
							book.setUpdatedAt(LocalDateTime.now());
							bookController.updateBook(book);
							this.purchaseController.createPurchase(book, user);
                            JOptionPane.showMessageDialog(null, "livro pego com sucesso, entre em contato com o dono do livro pelo email: " + book.getCreatedBy().getEmail());
						}
					
						
				}
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
			}
    }
}
