package frontend;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import controllers.BookController;
import controllers.PurchaseController;
import entities.Book;
import entities.Purchase;
import entities.User;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import models.BookModel;
import models.PurchaseModel;

public class Home extends JFrame implements ActionListener {

	/**
	* 
	*/
	JPanel panel5, panel3, panel4, panel6;
	JPanel sub51;
	JPanel sub511;
	JPanel sub513;
	JPanel subMinhasPegas;
	private static final long serialVersionUID = 1L;
	JTextField pesquisa;
	JButton seuInfo;
	JButton meuLiv;
	JButton criaLivro;
	JButton suaArea;
	JButton minhasPegas;
	JPanel sub512;
	JButton excluirLivro;

	private BookController bookController;
	private PurchaseController purchaseController;
	private User userE;
	private ArrayList<Book> livrosMeuCep=new ArrayList<Book>();;
	private ArrayList<Book> meusLivros = new ArrayList<Book>();
	private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
	
	Home(BookModel bookModel, User userE, PurchaseModel purchaseModel) {
		this.userE = userE;
		this.bookController = new BookController(bookModel);
		this.purchaseController = new PurchaseController(purchaseModel);

		updateMyBooks();
		updateBooksByCep();
		updatePurchases();

		ImageIcon logo = new ImageIcon("logo.png");
		ImageIcon pesIcon = new ImageIcon("searchIcon.png");
		
		JLabel user = new JLabel();
		user.setText("     Projeto De Linguagem de Programação II");
		user.setFont(new Font("Serif", Font.PLAIN, 15));
		user.setBounds(100, 300, 250, 250);

		JLabel search = new JLabel();
		search.setIcon(pesIcon);
		search.setOpaque(true);

		JLabel dadosNome = new JLabel();
		dadosNome.setText("Nome de Usuário:" + this.userE.getName());
		dadosNome.setFont(new Font("Serif", Font.PLAIN, 30));

		JLabel dadosCont = new JLabel();
		dadosCont.setText("Contato:" + this.userE.getEmail());
		dadosCont.setFont(new Font("Serif", Font.PLAIN, 30));

		JLabel dadosLoc = new JLabel();
		dadosLoc.setText("Localizacão:" + this.userE.getAddress());
		dadosLoc.setFont(new Font("Serif", Font.PLAIN, 30));

		excluirLivro = new JButton();
		excluirLivro.setText("Excluir livro");
		excluirLivro.addActionListener(this);
		excluirLivro.setFont(new Font("Serif", Font.PLAIN, 10));
		excluirLivro.setFocusable(false);
		excluirLivro.setBounds(0, 0, 10, 20);

		criaLivro = new JButton();
		criaLivro.setText("Adicionar livro");
		criaLivro.addActionListener(this);
		criaLivro.setFont(new Font("Serif", Font.PLAIN, 20));
		criaLivro.setFocusable(false);
		criaLivro.setBounds(0, 0, 40, 50);

		seuInfo = new JButton();
		seuInfo.setText("Meus Dados");
		seuInfo.setFont(new Font("Serif", Font.PLAIN, 20));
		seuInfo.setBounds(0, 0, 100, 50);
		seuInfo.addActionListener(this);
		seuInfo.setFocusable(false);
		seuInfo.setBackground(new Color(156, 136, 82));

		minhasPegas = new JButton();
		minhasPegas.setText("Minhas Pegas");
		minhasPegas.setFont(new Font("Serif", Font.PLAIN, 20));
		minhasPegas.setBounds(0, 0, 100, 50);
		minhasPegas.addActionListener(this);
		minhasPegas.setFocusable(false);
		minhasPegas.setBackground(new Color(227, 223, 182));

		meuLiv = new JButton();
		meuLiv.setText("Meus Livros");
		meuLiv.setFont(new Font("Serif", Font.PLAIN, 12));
		meuLiv.setBounds(0, 0, 100, 50);
		meuLiv.addActionListener(this);
		meuLiv.setFocusable(false);
		meuLiv.setBackground(new Color(227, 223, 182));

		suaArea = new JButton();
		suaArea.setText("Livros na Minha Regiao");
		suaArea.setFont(new Font("Serif", Font.PLAIN, 10));
		suaArea.setBounds(0, 0, 100, 50);
		suaArea.addActionListener(this);
		suaArea.setFocusable(false);
		suaArea.setBackground(new Color(227, 223, 182));

		pesquisa = new JTextField();
		pesquisa.setPreferredSize(new Dimension(100, 40));
		pesquisa.setFont(new Font("Consolas", Font.PLAIN, 12));
		pesquisa.setForeground(Color.BLACK);
		pesquisa.setBackground(Color.white);
		pesquisa.setCaretColor(Color.black);
		pesquisa.setText("Pesquise");

		// Paineis

		sub511 = new JPanel();
		sub511.add(dadosNome);
		sub511.setBackground(new Color(0, 168, 150));

		sub512 = new JPanel();
		sub512.add(dadosCont);
		sub512.setBackground(new Color(0, 168, 150));

		sub513 = new JPanel();
		sub513.add(dadosLoc);
		sub513.setBackground(new Color(0, 168, 150));

		sub51 = new JPanel();
		sub51.setLayout(new GridLayout(3, 1, 4, 4));
		sub51.add(sub511);
		sub51.add(sub512);
		sub51.add(sub513);
		sub51.setBackground(new Color(0, 168, 150));

		JPanel sub11 = new JPanel();
		sub11.setLayout(new BorderLayout());
		sub11.add(search, BorderLayout.WEST);
		sub11.add(pesquisa, BorderLayout.EAST);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setBackground(new Color(227, 223, 182));
		panel1.setPreferredSize(new Dimension(200, 50));
		panel1.add(sub11, BorderLayout.EAST);
		panel1.add(user, BorderLayout.WEST);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 1));
		panel2.setBackground(new Color(227, 223, 182));
		panel2.setPreferredSize(new Dimension(150, 100));
		panel2.add(seuInfo);
		panel2.add(suaArea);
		panel2.add(meuLiv);
		panel2.add(minhasPegas);

		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3, 2, 5, 5));
		panel3.setBackground(new Color(0, 168, 150));
		panel3.setPreferredSize(new Dimension(100, 100));
		for(int i = 0; i < meusLivros.size(); i++){
			Book book = meusLivros.get(i);
			System.out.println(book.getCreatedBy().getId());
			System.out.println(this.userE.getId());
			panel3.add(new Livro(book.getTitle(), book.getSinopse(), book.getAuthor(), book.getCreatedBy().getAddress(), book.getCreatedBy().getEmail(), book.getCreatedBy().getId().equals(this.userE.getId()), book.getId(), this.bookController, this.purchaseController, this.userE));
		}
		panel3.add(criaLivro);

		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3, 2, 5, 5));
		panel4.setBackground(new Color(0, 168, 150));
		panel4.setPreferredSize(new Dimension(100, 100));

		for(int i = 0; i < livrosMeuCep.size(); i++){
			Book book = livrosMeuCep.get(i);
			panel4.add(new Livro(book.getTitle(), book.getSinopse(), book.getAuthor(), book.getCreatedBy().getAddress(), book.getCreatedBy().getEmail(), book.getCreatedBy().getId().equals(this.userE.getId()), book.getId(), this.bookController, this.purchaseController, this.userE));
		}

		panel6 = new JPanel();
		panel6.setLayout(new GridLayout(3, 2, 5, 5));
		panel6.setBackground(new Color(0, 168, 150));
		panel6.setPreferredSize(new Dimension(100, 100));

		for(int i = 0; i < purchases.size(); i++){
			Purchase purchase = purchases.get(i);
			panel6.add(new MinhasPegas(purchase.getBook().getTitle(), purchase.getPurchased().getAddress(), purchase.getPurchased().getEmail()));
		}
		

		panel5 = new JPanel();
		panel5.setBackground(new Color(0, 168, 150));
		panel5.setPreferredSize(new Dimension(100, 100));
		panel5.add(sub51);

		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setTitle("Login");
		this.getContentPane().setBackground(new Color(227, 223, 182));

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.WEST);
		this.add(panel5, BorderLayout.CENTER);

		this.setVisible(true);

	}

	private void updateBooksByCep(){
		try {
			livrosMeuCep = bookController.getBooksByCep(this.userE.getAddress());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updatePurchases(){
		try {
			purchases = purchaseController.getPurchase(userE.getId());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateMyBooks(){
		try {
			meusLivros = bookController.getBooksByUser(this.userE.getId());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * try {
		 * bookController.getBooks();
		 * } catch (InstantiationException | IllegalAccessException |
		 * ClassNotFoundException | SQLException e1) {
		 * // TODO Auto-generated catch block
		 * e1.printStackTrace();
		 * }
		 */
		if (e.getSource() == criaLivro) {
			new AddLiv(this.bookController, this.userE);
			this.revalidate();
			this.repaint();
		}

		if (e.getSource() == minhasPegas) {
			suaArea.setBackground(new Color(227, 223, 182));
			meuLiv.setBackground(new Color(227, 223, 182));
			seuInfo.setBackground(new Color(227, 223, 182));
			minhasPegas.setBackground(new Color(156, 136, 82));

			this.getContentPane().remove(panel3);
			this.getContentPane().remove(panel4);
			this.getContentPane().remove(panel5);
			this.add(panel6);
			this.revalidate();
			this.repaint();
		}

		if (e.getSource() == seuInfo) {
			suaArea.setBackground(new Color(227, 223, 182));
			meuLiv.setBackground(new Color(227, 223, 182));
			minhasPegas.setBackground(new Color(227, 223, 182));
			seuInfo.setBackground(new Color(156, 136, 82));

			this.getContentPane().remove(panel3);
			this.getContentPane().remove(panel4);
			this.getContentPane().remove(panel6);
			this.add(panel5);
			this.revalidate();
			this.repaint();
		}
		if (e.getSource() == meuLiv) {

			suaArea.setBackground(new Color(227, 223, 182));
			seuInfo.setBackground(new Color(227, 223, 182));
			minhasPegas.setBackground(new Color(227, 223, 182));
			meuLiv.setBackground(new Color(156, 136, 82));
			this.getContentPane().remove(panel5);
			this.getContentPane().remove(panel4);
			this.getContentPane().remove(panel6);
			this.add(panel3);
			this.revalidate();
			this.repaint();

		}

		if (e.getSource() == excluirLivro) {
				updateBooksByCep();
				updateMyBooks();
		}

		if (e.getSource() == suaArea) {

			seuInfo.setBackground(new Color(227, 223, 182));
			meuLiv.setBackground(new Color(227, 223, 182));
			suaArea.setBackground(new Color(156, 136, 82));
			minhasPegas.setBackground(new Color(227, 223, 182));
			this.getContentPane().remove(panel3);
			this.getContentPane().remove(panel5);
			this.getContentPane().remove(panel6);
			this.add(panel4);
			this.revalidate();
			this.repaint();

		}

	}

}