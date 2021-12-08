package frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import controllers.BookController;
import controllers.PurchaseController;
import entities.User;
import threads.ExcluirLivro;
import threads.PegarLivro;

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
			ExcluirLivro excluir = new ExcluirLivro(bookId, bookController);
			excluir.start();
		}

		if (e.getSource() == pegarLivro) {
			PegarLivro pegarLivro = new PegarLivro(user, bookController, purchaseController, bookId);
			pegarLivro.start();
		}
		
	}

}