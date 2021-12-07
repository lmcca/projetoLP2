package frontend;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

import models.BookModel;
import models.PurchaseModel;
import models.UserModel;

import java.awt.Font;

public class Marcador2 extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookModel bookModel;
	private UserModel userModel;
	private PurchaseModel purchaseModel;

	JPanel login = new JPanel();
	JLabel lab = new JLabel("Login");
	JLabel lvlog = new JLabel();
	ImageIcon livroLogin = new ImageIcon("livroLogin.png");
	JButton butcria;
	JButton butlog;

	Marcador2(BookModel bookModel, UserModel userModel, PurchaseModel purchaseModel) {
		this.purchaseModel = purchaseModel;
		this.bookModel = bookModel;
		this.userModel = userModel;

		this.addMouseListener(this);
		lab.setVerticalTextPosition(JLabel.TOP);
		lab.setHorizontalTextPosition(JLabel.CENTER);
		lab.setForeground(Color.black);
		lab.setFont(new Font("Serif", Font.PLAIN, 20));
		lab.setBounds(0, 0, 50, 40);
		this.add(lab);
		this.setBounds(340, 110, 50, 40);
		this.setBackground(new Color(247, 247, 7));
		this.setVisible(true);

		lvlog.setIcon(livroLogin);
		lvlog.setOpaque(false);
		login.setBounds(-10, -10, 375, 240);
		login.add(lvlog);
		login.setVisible(false);
		login.setBackground(new Color(227, 223, 182));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when the mouse button has been clicked (pressed and released) on a
		// component
		// System.out.println("You clicked the mouse");
		new Login(userModel, bookModel, purchaseModel);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Invoked when a mouse button has been pressed on a component
		this.setBackground(Color.yellow);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Invoked when a mouse button has been released on a component

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		this.setBounds(340, 100, 50, 50);
		this.setBackground(new Color(247, 223, 7));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component

		this.setBackground(new Color(247, 247, 7));
		this.setBounds(340, 110, 50, 40);
	}

}
