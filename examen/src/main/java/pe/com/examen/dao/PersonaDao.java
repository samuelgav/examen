package pe.com.examen.dao;

import java.util.List;

import pe.com.examen.dto.Persona;

public interface PersonaDao {

	List<Persona> list();
	boolean save(Persona persona);
	Persona get(int id);
	boolean update(Persona persona);
	boolean delete(Persona persona);
}
