package frontend;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class livro extends JPanel{
	  JLabel titulo,ID,sinopse,autor; 
	 livro(){
		 titulo=new JLabel("Titulo:"+"Titulo");
		 autor=new JLabel("Autor:"+"Autor");
		 ID=new JLabel("ID:"+"ID");
		 sinopse=new JLabel("Sinopse:"+"Sinopse");
		 this.setBackground(new Color(0, 168, 150));
		 this.add(titulo);
		 this.add(autor);
		 this.add(ID);
		 this.add(sinopse);
	 }

}
