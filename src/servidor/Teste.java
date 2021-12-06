package servidor;

public class Teste {
	static TesteServer testeServer = new TesteServer();
	static TestesCliente testeCliente = new TestesCliente();
	
	public static void main(String[] args) {
		try {
			testeServer.start();
			testeCliente.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
