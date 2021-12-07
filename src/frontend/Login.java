package frontend;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import controllers.UserController;
import entities.User;
import models.BookModel;
import models.PurchaseModel;
import models.UserModel;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Login implements ActionListener {
	private UserController userController;
	private BookModel bookModel;
	private PurchaseModel purchaseModel;

	JLabel Npossui, usual, userlab, senhalab, maillab, ceplab, normu, norms;
	JTextField novUser, novSenha, novMail, novCEP, nLog, nSen;
	JFrame telalog;
	JPanel criaLog, normLog;
	JButton subCria, sublog;

	Login(UserModel userModel, BookModel bookModel, PurchaseModel purchaseModel) {
		this.userController = new UserController(userModel);
		this.purchaseModel = purchaseModel;
		this.bookModel = bookModel;

		// labels
		Npossui = new JLabel(" N�o possui uma conta?Crie J�!");
		Npossui.setFont(new Font("Serif", Font.PLAIN, 20));
		usual = new JLabel(" Tem uma conta? Fa�a seu login:");
		usual.setFont(new Font("Serif", Font.PLAIN, 20));
		userlab = new JLabel(" Digite o nome de usu�rio:");
		senhalab = new JLabel(" Digite a sua senha:");
		maillab = new JLabel(" Digite o seu email: ");
		ceplab = new JLabel(" Digite o seu CEP: ");
		normu = new JLabel(" Digite o nome de usu�rio:");
		norms = new JLabel(" Digite a sua senha:");

		// textfields
		novUser = new JTextField();
		novUser.setPreferredSize(new Dimension(140, 30));
		novUser.setFont(new Font("Serif", Font.PLAIN, 12));

		novSenha = new JTextField();
		novSenha.setPreferredSize(new Dimension(150, 30));
		novSenha.setFont(new Font("Serif", Font.PLAIN, 12));

		novMail = new JTextField();
		novMail.setPreferredSize(new Dimension(150, 30));
		novMail.setFont(new Font("Serif", Font.PLAIN, 12));

		novCEP = new JTextField();
		novCEP.setPreferredSize(new Dimension(150, 30));
		novCEP.setFont(new Font("Serif", Font.PLAIN, 12));

		nLog = new JTextField();
		nLog.setPreferredSize(new Dimension(150, 30));
		nLog.setFont(new Font("Serif", Font.PLAIN, 12));

		nSen = new JTextField();
		nSen.setPreferredSize(new Dimension(150, 30));
		nSen.setFont(new Font("Serif", Font.PLAIN, 12));

		// butoes
		subCria = new JButton();
		subCria.addActionListener(this);
		subCria.setPreferredSize(new Dimension(70, 30));
		subCria.setText("Submit");
		subCria.setFont(new Font("Serif", Font.PLAIN, 12));

		sublog = new JButton();
		sublog.addActionListener(this);
		sublog.setPreferredSize(new Dimension(70, 30));
		sublog.setText("Submit");
		sublog.setFont(new Font("Serif", Font.PLAIN, 12));

		// paineis
		criaLog = new JPanel();
		criaLog.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 5));
		criaLog.setBackground(new Color(199, 180, 129));
		criaLog.setPreferredSize(new Dimension(300, 500));
		criaLog.add(Npossui);
		criaLog.add(userlab);
		criaLog.add(novUser);
		criaLog.add(senhalab);
		criaLog.add(novSenha);
		criaLog.add(maillab);
		criaLog.add(novMail);
		criaLog.add(ceplab);
		criaLog.add(novCEP);
		criaLog.add(subCria);

		normLog = new JPanel();
		normLog.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
		normLog.add(usual);
		normLog.add(normu);
		normLog.add(nLog);
		normLog.add(norms);
		normLog.add(nSen);
		normLog.add(sublog);
		normLog.setBackground(new Color(227, 223, 182));
		normLog.setPreferredSize(new Dimension(285, 500));

		// frame
		telalog = new JFrame();

		telalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telalog.setLayout(new BorderLayout());
		telalog.setSize(600, 300);
		telalog.add(criaLog, BorderLayout.WEST);
		telalog.add(normLog, BorderLayout.EAST);
		telalog.setResizable(false);
		telalog.getContentPane().setBackground(Color.black);
		telalog.setTitle("Login");
		telalog.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == subCria) {
			try {
				User user = userController.createUser(novMail.getText(), novUser.getText(), novSenha.getText(),
						novCEP.getText());
				System.out.println("user criado");
				new Home(bookModel, user, purchaseModel);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == sublog) {
			try {
				User user = userController.getUserByEmail(nLog.getText());
				System.out.println("user encontrado");
				new Home(bookModel, user, purchaseModel);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
