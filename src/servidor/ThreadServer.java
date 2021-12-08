package servidor;

public class ThreadServer extends Thread{
	public void run() {
		Server server = new Server();
		server.server();
	}
}
