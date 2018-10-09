package pe.com.examen.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.UsuarioDao;
import pe.com.examen.dto.Cart;
import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Usuario;

@Repository("usuarioDAO")
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUsuario(Usuario usuario) {
		try {
			sessionFactory.getCurrentSession().persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addDireccion(Direccion direccion) {
		try {
			sessionFactory.getCurrentSession().persist(direccion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
