package pe.com.examen.daoimpl;

import java.util.List;

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

	@Override
	public Usuario getByEmail(String email) {
		String sql="FROM Usuario WHERE email =:email";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(sql,Usuario.class).setParameter("email",email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Direccion getBillingDireccion(int usuarioId) {
		String sql="From Direccion WHERE usuarioId = :usuarioId AND billing=:billing";
		try {
			return sessionFactory.getCurrentSession()
				   .createQuery(sql,Direccion.class).setParameter("usuarioId",usuarioId)
				   .setParameter("billing", "1")
				   .getSingleResult();
				   
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Direccion> listShippingDirecciones(int usuarioId) {
		String sql="From Direccion WHERE usuarioId = :usuarioId AND shipping=:shipping";
		try {
			return sessionFactory.getCurrentSession()
				   .createQuery(sql,Direccion.class).setParameter("usuarioId",usuarioId)
				   .setParameter("shipping", "1")
				   .getResultList();
				   
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
