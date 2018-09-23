package pe.com.examen.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.TipoPersona;

@Repository("tipopersonaDAO")
@Transactional
public class TipoPersonaDaoImpl implements TipoPersonaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TipoPersona> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Tipo_Persona").getResultList();
	}

	@Override
	public boolean save(TipoPersona tipoPersona) {
		try {
			sessionFactory.getCurrentSession().persist(tipoPersona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TipoPersona get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(TipoPersona.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(TipoPersona tipoPersona) {
		try {
			sessionFactory.getCurrentSession().update(tipoPersona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(TipoPersona tipoPersona) {
		try {
			sessionFactory.getCurrentSession().delete(tipoPersona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
