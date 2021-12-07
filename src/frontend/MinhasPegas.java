package frontend;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MinhasPegas extends JPanel{
    JLabel titulo, cep, contato;

    MinhasPegas(String tituloBook, String cepBook, String contatoBook) {
		titulo = new JLabel("Titulo:" + tituloBook);
		contato = new JLabel("Contato:" + contatoBook);
		cep = new JLabel("CEP:" + cepBook);

        this.setLayout(new GridLayout(2, 2, 1, 1));	

        this.setBackground(new Color(255,255,255));

		this.add(titulo);
		this.add(contato);
        this.add(cep);
	}
}
