package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.BookController;
import entities.User;

public class AddLiv extends JFrame implements ActionListener{
	private BookController bookController;
	private User user; 
	       JTextField titulotex,autortex, sinopsetex;
	       JLabel titlab,autlab,sinlab;
	       JButton adicionar;
	AddLiv(BookController bookController, User user){
		this.bookController = bookController;
		this.user = user;

		adicionar = new JButton();
		adicionar.setText("Adicionar Livro");
  	    adicionar.setFont(new Font("Serif",Font.PLAIN,20));
  	    adicionar.setBounds(0, 0, 60, 50);
		adicionar.addActionListener(this);
		adicionar.setFocusable(false);
		
		titlab = new JLabel("Digite o T�tulo");
		autlab = new JLabel("Digite o Autor(a)");
		sinlab = new JLabel("Digite a sinopse");
		
		titulotex = new JTextField();
		titulotex.setPreferredSize(new Dimension(200,30));
		titulotex.setFont(new Font("Serif",Font.PLAIN,12));
   	 
		autortex= new JTextField();
		autortex.setPreferredSize(new Dimension(200,30));
	    autortex.setFont(new Font("Serif",Font.PLAIN,12));
	 
	    sinopsetex = new JTextField();
	    sinopsetex.setPreferredSize(new Dimension(200,100));
	    sinopsetex.setFont(new Font("Serif",Font.PLAIN,12));
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		this.setSize(400,300);
        this.setTitle("Adicione Livro");
        this.getContentPane().setBackground(new Color(227, 223, 182));
        this.add(titlab);
        this.add(titulotex);
        this.add(autlab);
        this.add(autortex);
        this.add(sinlab);
        this.add(sinopsetex);
        this.add(adicionar);
        this.setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==adicionar) {
			try {
				bookController.createBook(titulotex.getText(), autortex.getText(), sinopsetex.getText(),null,null, this.user);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}	
	}

}
