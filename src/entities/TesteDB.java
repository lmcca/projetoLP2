package entities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient  Connection conexao;
	
	public TesteDB() {};
	
	public Connection call() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String usuario = "sa";
		String senha = "codehashi";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=DoacaoDeLivros" +
		                       ";user=" + usuario + ";password=" + senha + ";";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    conexao = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
		    // Erro caso o driver JDBC não foi instalado
		    e.printStackTrace();
		} catch (SQLException e) {
		    // Erro caso haja problemas para se conectar ao banco de dados
		    e.printStackTrace();
		}
		return conexao;
	}
	
	public void cloceConnection() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
