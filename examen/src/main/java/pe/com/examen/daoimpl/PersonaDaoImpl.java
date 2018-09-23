package pe.com.examen.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dto.Persona;

@Repository("personaDAO")
@Transactional
public class PersonaDaoImpl implements PersonaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Persona> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Persona").getResultList();
	}

	@Override
	public boolean save(Persona persona) {
		try {
			sessionFactory.getCurrentSession().persist(persona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Persona get(int id) {
		return sessionFactory.getCurrentSession().get(Persona.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Persona persona) {
		try {
			sessionFactory.getCurrentSession().update(persona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Persona persona) {
		try {
			sessionFactory.getCurrentSession().delete(persona);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
