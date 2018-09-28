package pe.com.examen.exception;

import java.io.Serializable;

public class ProductoNotFoundException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductoNotFoundException(){
		this("Producto no habilitado!");
	}
	
	public ProductoNotFoundException(String message){
		this.message=System.currentTimeMillis()+": "+message;
	}

	public String getMessage() {
		return message;
	}

	
}
