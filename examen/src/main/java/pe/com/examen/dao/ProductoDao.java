package pe.com.examen.dao;

import java.util.List;

import pe.com.examen.dto.Producto;

public interface ProductoDao {
	
	List<Producto> list();
	boolean save(Producto producto);
	Producto get(int id);
	boolean update(Producto producto);
	boolean delete(Producto producto);

}
