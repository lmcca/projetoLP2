package frontend;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Livro extends JPanel {
	JLabel titulo, sinopse, autor, contato;

	Livro(String tituloBook, String sinopseBook, String autorBook, String contatoBook) {
		titulo = new JLabel("Titulo:" + tituloBook);
		autor = new JLabel("Autor:" + autorBook);
		contato = new JLabel("Contato:" + contatoBook);
		sinopse = new JLabel("Sinopse:" + sinopseBook);
		this.setBackground(new Color(8, 103, 136));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		this.add(titulo);
		this.add(autor);
		this.add(sinopse);
		this.add(contato);
	}

}