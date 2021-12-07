package frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

import controllers.BookController;
import controllers.PurchaseController;
import entities.Book;
import entities.User;

public class Livro extends JPanel implements ActionListener {
	JLabel titulo, sinopse, autor, cep, contato;
	JButton excluirLivro;
	JButton pegarLivro;

	private BookController bookController;
	private PurchaseController purchaseController;
	private String bookId;
	private User user;
	
	Livro(String tituloBook, String sinopseBook, String autorBook, String cepBook, String contatoBook, boolean deleteBook, String bookId, BookController bookController, PurchaseController purchaseController, User user) {
		this.bookController = bookController;
		this.bookId = bookId;
		this.purchaseController = purchaseController;
		this.user = user;
		
		excluirLivro = new JButton();
		excluirLivro.setText("Excluir livro");
		excluirLivro.addActionListener(this);
		excluirLivro.setFont(new Font("Serif", Font.PLAIN, 10));
		excluirLivro.setFocusable(false);
		excluirLivro.setBounds(0, 0, 10, 20);

		pegarLivro = new JButton();
		pegarLivro.setText("Pegar livro");
		pegarLivro.addActionListener(this);
		pegarLivro.setFont(new Font("Serif", Font.PLAIN, 10));
		pegarLivro.setFocusable(false);
		pegarLivro.setBounds(0, 0, 10, 20);

		this.setLayout(new GridLayout(2, 3, 1, 1));		

		titulo = new JLabel("Titulo:" + tituloBook);
		autor = new JLabel("Autor:" + autorBook);
		
		sinopse = new JLabel("Sinopse:" + sinopseBook);
		contato = new JLabel("Contato:" + contatoBook);
		cep = new JLabel("CEP:" + cepBook);
		

		this.setBackground(new Color(255,255,255));

		this.add(titulo);
		this.add(autor);
		
		System.out.println(deleteBook);
		
		if(deleteBook){this.add(excluirLivro);}else{
			this.add(pegarLivro);
		}
		
		this.add(sinopse);
		this.add(contato);
		this.add(cep);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == excluirLivro) {
			try {
				this.bookController.deleteBook(bookId);
				JOptionPane.showMessageDialog(null, "Livro foi excluido com sucesso!");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
			}
		}

		if (e.getSource() == pegarLivro) {
			try {
				Book book = this.bookController.getBookById(bookId);
				
				
				if(Objects.isNull(book)){
					JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
				}else{
					System.out.println("aaaaaaaaaaa");
					try{
						if(book.getPurchased()){
							JOptionPane.showMessageDialog(null, "Ops, esse livro ja foi pego, atualize sua tela!");
						}else{
							book.setPurchased(true);
							book.setUpdatedAt(LocalDateTime.now());
							bookController.updateBook(book);
							this.purchaseController.createPurchase(book, user);
						}
					}catch(NullPointerException e2){
						JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
					}
						
				}
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ops, esse livro foi excluido, atualize sua tela!");
			}
		}
		
	}

}