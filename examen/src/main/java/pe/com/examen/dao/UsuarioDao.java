package pe.com.examen.dao;

import pe.com.examen.dto.Cart;
import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Usuario;

public interface UsuarioDao {
	boolean addUsuario(Usuario usuario);
	boolean addDireccion(Direccion direccion);
	boolean addCart(Cart cart);
}
