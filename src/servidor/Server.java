package servidor;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import models.BookModel;
import models.PurchaseModel;
import models.UserModel;

public class Server {

    private ServerSocket servidor;

	public void server(){
    	try {
    	      servidor = new ServerSocket(12345);
    	      System.out.println("Servidor ouvindo a porta 12345");
    	      while(true) {
    	    	  
    	    	UserModel userModel = new UserModel();
    	    	BookModel bookModel = new BookModel();
    	    	PurchaseModel purchaseModel = new PurchaseModel();
    	        
    	    	Socket cliente = servidor.accept();
    	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
    	        
    	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
    	        
    	        saida.flush();
    	        saida.writeObject(userModel);
    	        saida.writeObject(bookModel);
    	        saida.writeObject(purchaseModel);
    	        saida.close();
    	        
    	        cliente.close();
    	      }
    	    }
    	    catch(Exception e) {
    	       System.out.println("Erro: " + e.getMessage());
    	    }
    	  }

    }

