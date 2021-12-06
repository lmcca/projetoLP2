package servidor;

public class TesteServer extends Thread{
	public void run() {
		Server server = new Server();
		server.server();
	}
}
