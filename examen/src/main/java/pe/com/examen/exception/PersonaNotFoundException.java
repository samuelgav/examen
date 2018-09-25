package pe.com.examen.exception;

import java.io.Serializable;

public class PersonaNotFoundException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public PersonaNotFoundException(){
		this("Persona no encontrada!");
	}
	
	public PersonaNotFoundException(String message){
		this.message=System.currentTimeMillis()+": "+message; 
	}

	public String getMessage() {
		return message;
	}
		
}
