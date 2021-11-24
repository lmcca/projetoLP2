package doacaodelivros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDB{
	
	public static void main(String[] args) {
		String usuario = "sa";
		String senha = "codehashi";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=DoacaoDeLivros" +
		                       ";user=" + usuario + ";password=" + senha + ";";
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection conexao = DriverManager.getConnection(url);
		    System.out.println(conexao.getCatalog());
		    
		} catch (ClassNotFoundException e) {
		    // Erro caso o driver JDBC não foi instalado
		    e.printStackTrace();
		} catch (SQLException e) {
		    // Erro caso haja problemas para se conectar ao banco de dados
		    e.printStackTrace();
		}
	}
}
