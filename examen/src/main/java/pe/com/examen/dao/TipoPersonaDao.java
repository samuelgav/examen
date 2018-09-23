package pe.com.examen.dao;

import java.util.List;

import pe.com.examen.dto.TipoPersona;

public interface TipoPersonaDao {

	List<TipoPersona> list();
	boolean save(TipoPersona tipoPersona);
	TipoPersona get(int id);
	boolean update(TipoPersona tipoPersona);
	boolean delete(TipoPersona tipoPersona);
	
}
