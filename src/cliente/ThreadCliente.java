package cliente;

public class ThreadCliente extends Thread{
	public void run() {
		Cliente cliente = new Cliente();
		cliente.cliente();
	}
}
