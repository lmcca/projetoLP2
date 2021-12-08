package servidor;

public class RunServer {
    static ThreadServer testeServer = new ThreadServer();

    public static void main(String[] args) {
		try {
			testeServer.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
