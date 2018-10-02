package pe.com.examen.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dto.Categoria;

@Repository("categoriaDAO")
@Transactional
public class CategoriaDaoImpl implements CategoriaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Categoria> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Categoria where estado=:estado").setParameter("estado", "1").getResultList();
	}

	@Override
	public Categoria get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Categoria.class, Integer.valueOf(id));
	}

	@Override
	public boolean create(Categoria categoria) {
		try {
			sessionFactory.getCurrentSession().persist(categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Categoria categoria) {
		try {
			sessionFactory.getCurrentSession().update(categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Categoria categoria) {
		try {
			sessionFactory.getCurrentSession().delete(categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
