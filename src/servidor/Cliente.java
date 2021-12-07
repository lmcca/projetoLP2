package servidor;

import java.io.ObjectInputStream;

import java.net.Socket;

import frontend.GUI;
import models.BookModel;
import models.PurchaseModel;
import models.UserModel;

public class Cliente {
	private static Socket cliente;

	public void cliente() {
		try {
			cliente = new Socket("192.168.1.16", 12345);
			System.out.println(cliente);
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			UserModel userModel = (UserModel) entrada.readObject();
			BookModel bookModel = (BookModel) entrada.readObject();
			PurchaseModel purchaseModel = (PurchaseModel) entrada.readObject();

			new GUI(bookModel, userModel, purchaseModel);

			entrada.close();

			System.out.println("Conexco encerrada");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
