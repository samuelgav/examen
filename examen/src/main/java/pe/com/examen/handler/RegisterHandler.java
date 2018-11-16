package pe.com.examen.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import pe.com.examen.dao.UsuarioDao;
import pe.com.examen.dto.Cart;
import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Usuario;
import pe.com.examen.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UsuarioDao usuarioDao;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUsuario(RegisterModel registerModel,Usuario usuario){
		registerModel.setUsuario(usuario);
	}
	
	public void addBilling(RegisterModel registerModel,Direccion direccion){
		registerModel.setDireccion(direccion);
	}
	
	
	public String validateUsuario(Usuario usuario,MessageContext error){
		String transitionValue="success";
		if(!(usuario.getPassword().equals(usuario.getConfirmarPassword()))){
			error.addMessage(new MessageBuilder().error().source("confirmarPassword").defaultText("Password no coinciden").build());
			transitionValue="failure";
		}
		if(usuarioDao.getByEmail(usuario.getEmail())!=null){
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Correo ya existe!!").build());
			transitionValue="failure";
		}
		
		
		return transitionValue;
	}
	
	
	
	public String saveAll(RegisterModel model){
		String transitionValue="success";
		
		Usuario usuario=model.getUsuario();
		if(usuario.getRol().equals("USER")){
			Cart cart=new Cart();
			cart.setUsuario(usuario);
			usuario.setCart(cart);
		}
		
		//guardar usuario
		usuarioDao.addUsuario(usuario);
		
		//Obtener la direccion
		Direccion direccion=model.getDireccion();
		direccion.setUsuarioId(usuario.getId());
		direccion.setBilling("1");
		direccion.setShipping("1");
		usuarioDao.addDireccion(direccion);
		
		return transitionValue;
	}
}
