package defaut;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.*;

public class GUI {

		
		JLabel label1;

	    GUI(){
		

	    
	    ImageIcon logo = new ImageIcon("logo.png");
	    ImageIcon livro = new ImageIcon("livro.png");
	    
	    JLabel label1 = new JLabel();
	    label1.setIcon(livro);
	    label1.setBounds(0, 0, 375, 240);
	    
	    Marcador1 sobre = new Marcador1();
	    Marcador2 login = new Marcador2();
	    
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setBounds(100, 150, 375, 240);
	    layeredPane.add(label1, Integer.valueOf(0));
		layeredPane.add(sobre.sobre, Integer.valueOf(1));
		layeredPane.add(login.login, Integer.valueOf(1));
	 
		
		
	    
	    JFrame frame = new JFrame("JLayeredPane");
	    
	    frame.setIconImage(logo.getImage());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(layeredPane);
	    frame.add(sobre);
	    frame.add(login);
		frame.setLayout(null);
	    frame.setTitle("Projeto LP2");
	    frame.setResizable(false);
	    frame.setSize(600,500);
	    frame.setVisible(true);
	    frame.getContentPane().setBackground(new Color(227, 223, 182)); 
	    
	  }
	}
