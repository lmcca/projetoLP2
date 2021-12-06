package servidor;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.time.LocalDateTime;

import entities.Book;
import entities.User;
import models.BookModel;
import models.PurchaseModel;
import models.UserModel;

public class Cliente {
	private static Socket cliente;

	public void cliente() {
	    try {
	      cliente = new Socket("192.168.1.16",12345);
	      System.out.println(cliente);
	      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
	      
	      UserModel userModel = (UserModel)entrada.readObject();
	      BookModel bookModel = (BookModel)entrada.readObject();
	      PurchaseModel purchaseModel = (PurchaseModel)entrada.readObject();
	      
	      //User user = userModel.createUser("testederrota@teste.com", "derrota", "123456", "58033460");
	      User user = userModel.getUserById("C3C6E891-56C2-4E97-BBB2-2944B492E3B8");
	      Book book =  bookModel.getBookById("D9CCEFCA-C211-4143-93CF-5584590877D8");
	      
	      System.out.println(book.toString());
	      
	      entrada.close();
	      
	      System.out.println("Conexão encerrada");
	    }
	    catch(Exception e) {
	      System.out.println(e.getMessage());
	    }
	  }
}
