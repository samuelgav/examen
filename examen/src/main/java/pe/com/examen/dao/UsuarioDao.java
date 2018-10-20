package pe.com.examen.dao;

import java.util.List;

import pe.com.examen.dto.Cart;
import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Usuario;

public interface UsuarioDao {
	boolean addUsuario(Usuario usuario);
	Usuario getByEmail(String email);
	
	boolean addDireccion(Direccion direccion);
	Direccion getBillingDireccion(int usuarioId);
	List<Direccion> listShippingDirecciones(int usuarioId);
	
	boolean addCart(Cart cart);
	
}
