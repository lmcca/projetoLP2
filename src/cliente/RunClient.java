package cliente;

public class RunClient {
    static TestesCliente testeServer = new TestesCliente();

    public static void main(String[] args) {
		try {
			testeServer.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
