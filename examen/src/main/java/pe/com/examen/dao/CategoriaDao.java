package pe.com.examen.dao;

import java.util.List;

import pe.com.examen.dto.Categoria;

public interface CategoriaDao {
	
	List<Categoria> list();
	Categoria get(int id);
	boolean create(Categoria categoria);
	boolean update(Categoria categoria);
	boolean delete(Categoria categoria);
	
	
	
}
