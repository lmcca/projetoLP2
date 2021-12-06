package defaut;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Log implements ActionListener{
	       JLabel Npossui,usual,userlab,senhalab,maillab,ceplab,normu,norms;
	       JTextField novUser,novSenha,novMail,novCEP,nLog,nSen;
	       JFrame telalog;
	       JPanel criaLog, normLog;
	       JButton subCria,subLog;
	
	     Log(){
	    	 
	    	 //labels
	    	 Npossui = new JLabel(" Não possui uma conta?Crie Já!");
	    	 Npossui.setFont(new Font("Serif",Font.PLAIN,20)); 
	    	 usual = new JLabel(" Tem uma conta? Faça seu login:");
	    	 usual.setFont(new Font("Serif",Font.PLAIN,20)); 
	    	 userlab = new JLabel(" Digite o nome de usuário:");
	    	 senhalab = new JLabel(" Digite a sua senha:");
	    	 maillab = new JLabel(" Digite o seu email: ");
	    	 ceplab = new JLabel(" Digite o seu CEP: ");
	    	 normu = new JLabel(" Digite o nome de usuário:");
	    	 norms = new JLabel(" Digite a sua senha:");
	    	 
	    	 
	    	 //textfields
	    	 novUser = new JTextField();
	    	 novUser.setPreferredSize(new Dimension(140,30));
	    	 novUser.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 novSenha = new JTextField();
	    	 novSenha.setPreferredSize(new Dimension(150,30));
	    	 novSenha.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 novMail = new JTextField();
	    	 novMail.setPreferredSize(new Dimension(150,30));
	    	 novMail.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 novCEP = new JTextField();
	    	 novCEP.setPreferredSize(new Dimension(150,30));
	    	 novCEP.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 nLog = new JTextField();
	    	 nLog.setPreferredSize(new Dimension(150,30));
	    	 nLog.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 nSen = new JTextField();
	    	 nSen.setPreferredSize(new Dimension(150,30));
	    	 nSen.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 
	    	 //butoes
	    	 subCria = new JButton();
	    	 subCria.addActionListener(this);
	    	 subCria.setPreferredSize(new Dimension(70,30));
	    	 subCria.setText("Submit");
	    	 subCria.setFont(new Font("Serif",Font.PLAIN,12));
	    	 	    	 
	    	 subLog = new JButton();
	    	 subLog.addActionListener(this);
	    	 subLog.setPreferredSize(new Dimension(70,30));
	    	 subLog.setText("Submit");
	    	 subLog.setFont(new Font("Serif",Font.PLAIN,12));
	    	 
	    	 
	    	 //paineis
	    	 criaLog = new JPanel();
	    	 criaLog.setLayout(new FlowLayout(FlowLayout.LEFT,1,5));
	    	 criaLog.setBackground(new Color(199, 180, 129));
	    	 criaLog.setPreferredSize(new Dimension(300,500));
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
	    	 normLog.setLayout(new FlowLayout(FlowLayout.LEFT,15,5));
	    	 normLog.add(usual);
	    	 normLog.add(normu);
	    	 normLog.add(nLog);
	    	 normLog.add(norms);
	    	 normLog.add(nSen);
	    	 normLog.add(subLog);
	    	 normLog.setBackground(new Color(227, 223, 182));
	    	 normLog.setPreferredSize(new Dimension(285,500));
	    	 
	    	 
	    	 //frame
	    	 telalog = new JFrame();
	    	 
	    	 telalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	 telalog.setLayout(new BorderLayout());
	    	 telalog.setSize(600,300);
	    	 telalog.add(criaLog,BorderLayout.WEST);
	    	 telalog.add(normLog,BorderLayout.EAST);
	    	 telalog.setResizable(false);
	    	 telalog.getContentPane().setBackground(Color.black);
	    	 telalog.setTitle("Login");
	    	 telalog.setVisible(true);
	    	 
	    	 
	     }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            if(e.getSource()==subCria) {
            	subCria.setBackground(new Color(156, 136, 82));
            	Login bla =new Login();
			
			
			}
            if(e.getSource()==subLog) {
	
            	new Login();
            }
			
		}

}
