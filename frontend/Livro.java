package frontend;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Livro extends JPanel{
	  JLabel titulo,ID,sinopse,autor,contato; 
	 Livro(){
		 titulo=new JLabel("Titulo:"+"Titulo");
		 autor=new JLabel("Autor:"+"Autor");
		 ID=new JLabel("ID:"+"ID");
		 contato=new JLabel("Contato:"+"Contato");
		 sinopse=new JLabel("Sinopse:"+"Sinopse");
		 this.setBackground(new Color(8, 103, 136));
		 this.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		 this.add(titulo);
		 this.add(autor);
		 this.add(ID);		 
		 this.add(sinopse);
		 this.add(contato);
	 }

}
