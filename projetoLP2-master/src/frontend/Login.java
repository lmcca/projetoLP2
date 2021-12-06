package frontend;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import controllers.BookController;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import models.BookModel;

public class Login extends JFrame implements ActionListener{

	      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JTextField pesquisa;
	      JButton seuInfo;
	      JButton meuLiv;
	      JButton suaArea;
	private BookController bookController;

          Login(BookModel bookModel){
        	  this.bookController = new BookController(bookModel);

        	  ImageIcon logo = new ImageIcon("logo.png");
        	  ImageIcon pesIcon =  new ImageIcon("searchIcon.png");
        	  
        	  JLabel user = new JLabel();
        	  user.setText("   Nome");
        	  user.setFont(new Font("Serif",Font.PLAIN,12));

        	  JLabel search = new JLabel();
        	  search.setIcon(pesIcon);
        	  search.setOpaque(true); 
        	  
        	  seuInfo = new JButton();
        	  seuInfo.setText("Meus Dados");
        	  seuInfo.setFont(new Font("Serif",Font.PLAIN,12));
        	  seuInfo.setBounds(0, 0, 100, 50);
      		  seuInfo.addActionListener(this);
      		  seuInfo.setFocusable(false);
      		  seuInfo.setBackground(new Color(227, 223, 182));
      		
        	  
        	  meuLiv = new JButton();
        	  meuLiv.setText("Meus Livros");
        	  meuLiv.setFont(new Font("Serif",Font.PLAIN,12));
        	  meuLiv.setBounds(0, 0, 100, 50);
      		  meuLiv.addActionListener(this);
      		  meuLiv.setFocusable(false);
      		  meuLiv.setBackground(new Color(227, 223, 182));
      	
      		  
      		  suaArea = new JButton();
      	      suaArea.setText("Livros na Minha Regi�o");
      	      suaArea.setFont(new Font("Serif",Font.PLAIN,12));
      	      suaArea.setBounds(0, 0, 100, 50);
    		  suaArea.addActionListener(this);
    		  suaArea.setFocusable(false);
    		  suaArea.setBackground(new Color(227, 223, 182));
        	 
    		  
        	  pesquisa = new JTextField();
      	      pesquisa.setPreferredSize(new Dimension(100,40));
      	      pesquisa.setFont(new Font("Consolas",Font.PLAIN,12));
      	      pesquisa.setForeground(Color.BLACK);
      	      pesquisa.setBackground(Color.white);
      	      pesquisa.setCaretColor(Color.black);
      	      pesquisa.setText("Pesquise");
      	      
      	      JPanel sub11= new JPanel();
      	      sub11.setLayout(new BorderLayout());
      	      sub11.add(search,BorderLayout.WEST);
      	      sub11.add(pesquisa,BorderLayout.EAST);
        	  
        	  
        	  JPanel panel1 = new JPanel();
        	  panel1.setLayout(new BorderLayout());
        	  panel1.setBackground(new Color(227, 223, 182));
        	  panel1.setPreferredSize(new Dimension(200,50));
        	  panel1.add(sub11,BorderLayout.EAST);
        	  panel1.add(user,BorderLayout.WEST);
        	  
      	      JPanel panel2 = new JPanel();
      	      panel2.setLayout(new GridLayout(5,1));
      	      panel2.setBackground(new Color(227, 223, 182));
      	      panel2.setPreferredSize(new Dimension(150,100));
      	      panel2.add(seuInfo);
      	      panel2.add(suaArea);
      	      panel2.add(meuLiv);
      	      
      	      JPanel panel5 = new JPanel();
      		        	  

      	      panel5.setBackground(Color.blue);		
      	      
      		  panel5.setPreferredSize(new Dimension(100,100));
    
              
              this.setIconImage(logo.getImage());
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setSize(600,500);
              this.setTitle("Login");
              this.getContentPane().setBackground(new Color(227, 223, 182)); 
             
              this.add(panel1,BorderLayout.NORTH);
      		  this.add(panel2,BorderLayout.WEST);
      		  this.add(panel5,BorderLayout.CENTER);
      		  
      		  this.setVisible(true);
              
              
        	  
          }

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				bookController.getBooks();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(e.getSource()==seuInfo) {
				suaArea.setBackground(new Color(227, 223, 182));
				meuLiv.setBackground(new Color(227, 223, 182));
				seuInfo.setBackground(new Color(156, 136, 82));
	
			}	
			if(e.getSource()==meuLiv) {
				
				suaArea.setBackground(new Color(227, 223, 182));
				seuInfo.setBackground(new Color(227, 223, 182));
				meuLiv.setBackground(new Color(156, 136, 82));
				
			}
			if(e.getSource()==suaArea) {
				
				seuInfo.setBackground(new Color(227, 223, 182));
				meuLiv.setBackground(new Color(227, 223, 182));
				suaArea.setBackground(new Color(156, 136, 82));
			
			}
			
		}
		
		

}

