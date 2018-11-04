package pe.com.examen.handler;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		usuarioDao.addDireccion(direccion);
		
		return transitionValue;
	}
}
