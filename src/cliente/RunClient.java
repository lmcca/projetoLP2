package cliente;

public class RunClient {
    static ThreadCliente testeServer = new ThreadCliente();

    public static void main(String[] args) {
		try {
			testeServer.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
