package pe.com.examen.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.examen.dao.TestDao;
import pe.com.examen.dto.Test;

@Repository("testDAO")
@Transactional
public class TestDaoImpl implements TestDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Test test) {
	try {
		sessionFactory.getCurrentSession().persist(test);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	}

}
