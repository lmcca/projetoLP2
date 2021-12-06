package defaut;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Font;


public class Marcador1 extends JPanel implements MouseListener{

	JLabel lab = new JLabel("Sobre");
	JLabel sobre = new JLabel();
    ImageIcon livroSobre = new ImageIcon("livroSobre.png");
	
	Marcador1(){
	
		this.addMouseListener(this);
		lab.setVerticalTextPosition(JLabel.TOP);
		lab.setHorizontalTextPosition(JLabel.CENTER); 
		lab.setForeground(Color.black);
		lab.setFont(new Font("Serif", Font.PLAIN,20));
		sobre.setBounds(0,0, 375, 240);
		sobre.setIcon(livroSobre);
		sobre.setVisible(false);
		this.add(lab);
		this.setBounds(150, 110, 50, 40);
		this.setBackground(new Color(247, 247, 7));
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when the mouse button has been clicked (pressed and released) on a component
		//System.out.println("You clicked the mouse");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Invoked when a mouse button has been pressed on a component
		this.setBackground(Color.yellow);
		sobre.setVisible(true);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Invoked when a mouse button has been released on a component
		sobre.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		this.setBounds(150, 100, 50, 50);
		this.setBackground(new Color(247, 223, 7));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component
	    this.setBackground(new Color(247, 247, 7));
	    this.setBounds(150, 110, 50, 40);
	}

}