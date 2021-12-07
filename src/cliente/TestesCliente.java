package cliente;

public class TestesCliente extends Thread{
	public void run() {
		Cliente cliente = new Cliente();
		cliente.cliente();
	}
}
