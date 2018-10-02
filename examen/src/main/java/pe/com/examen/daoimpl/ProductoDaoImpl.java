package pe.com.examen.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.ProductoDao;
import pe.com.examen.dto.Producto;

@Repository("productoDAO")
@Transactional
public class ProductoDaoImpl implements ProductoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Producto> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Producto",Producto.class).getResultList();
	}

	@Override
	public boolean save(Producto producto) {
		try {
			sessionFactory.getCurrentSession().persist(producto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Producto get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Producto.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Producto producto) {
		try {
			sessionFactory.getCurrentSession().update(producto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Producto producto) {
		try {
			sessionFactory.getCurrentSession().delete(producto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Producto> listProductosActivos() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Producto where estado=:estado",Producto.class).setParameter("estado","1").getResultList();
	}

	@Override
	public List<Producto> listProductosPorCategoria(int categoriaId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Producto where estado=:estado AND categoriaId=:categoriaId",Producto.class).setParameter("estado","1").setParameter("categoriaId",categoriaId ).getResultList();
	}

}
