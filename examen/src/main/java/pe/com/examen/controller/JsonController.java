package pe.com.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.ProductoDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.Producto;
import pe.com.examen.dto.TipoPersona;

@Controller
@RequestMapping("/json/data")
public class JsonController {

	@Autowired
	private TipoPersonaDao tipopersonaDAO;
	
	@Autowired
	private PersonaDao personaDAO;
	
	@Autowired
	private CategoriaDao categoriaDAO;
	
	@Autowired
	private ProductoDao productoDAO;
		
	@RequestMapping("/all/tipopersona")
	@ResponseBody
	public List<TipoPersona> getAllTipPersonas() {			
			return tipopersonaDAO.list();					
	}
	
	
	@RequestMapping("/admin/all/productos")
	@ResponseBody
	public List<Producto> getAllProductosList(){
		return productoDAO.list();
	}
	
	@RequestMapping("/all/persona")
	@ResponseBody
	public List<Persona> getAllPersonas() {			
			return personaDAO.list();					
	}
	
	@RequestMapping("/all/productos")
	@ResponseBody
	public List<Producto> getAllProductos() {			
			return productoDAO.listProductosActivos();					
	}
	
	@RequestMapping("/categoria/{id}/productos")
	@ResponseBody
	public List<Producto> getProductosPorCategorias(@PathVariable int id) {			
			return productoDAO.listProductosPorCategoria(id);					
	}
}













