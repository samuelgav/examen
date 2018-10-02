package pe.com.examen.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.ProductoDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.Categoria;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.Producto;
import pe.com.examen.dto.TipoPersona;

public class Test {

	private static AnnotationConfigApplicationContext context;
	private static TipoPersonaDao tipoPersonaDao; 
	private static PersonaDao personaDao;
	private static CategoriaDao categoriaDao;
	private static ProductoDao productoDao;
	private static Test test;
	
	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.scan("pe.com.examen");
		context.refresh();
		tipoPersonaDao=(TipoPersonaDao)context.getBean("tipopersonaDAO");
		personaDao=(PersonaDao)context.getBean("personaDAO");
		categoriaDao=(CategoriaDao)context.getBean("categoriaDAO");
		productoDao=(ProductoDao)context.getBean("productoDAO");
		
		test=new Test();
		//test.add();
		//test.update();
		//test.delete();
		//test.listarTipoPersona();
		//test.deletePersona();
		//test.listarPersona();
		//test.createCategoria();
		//test.listCategoria();
		test.updateProducto();
		test.listarProducto();
	}
	
	public void listarTipoPersona(){
		List<TipoPersona> list=tipoPersonaDao.list();
		for (TipoPersona tipoPersona : list) {
			System.out.println("ID: "+tipoPersona.getId()+" Nombre: "+tipoPersona.getDescripcion());
		}
	}
	
	public void listarPersona(){
		List<Persona> list=personaDao.list();
		for (Persona Persona : list) {
			System.out.println("ID: "+Persona.getIdpersona()+" Nombre: "+Persona.getNombres()+ " Tipo Persona: "+Persona.getTipoPersona().getDescripcion());
		}
	}
	
	public void listarProducto(){
		List<Producto> list=productoDao.list();
		for (Producto producto : list) {
			System.out.println("ID: "+producto.getId()+" Nombre: "+producto.getNombre()+ " Cantidad:"+producto.getCantidad()+ " Estado: "+producto.getEstado());
		}
	}
	
	
	public void add(){
		TipoPersona tp=new TipoPersona();
		tp.setDescripcion("ave");
		tipoPersonaDao.save(tp);
	}
	
	public void update(){
		TipoPersona tp=new TipoPersona();
		tp=tipoPersonaDao.get(1);
		tp.setDescripcion("ave maria");
		tipoPersonaDao.update(tp);
	}
	
	public void updateProducto(){
		Producto tp=new Producto();
		tp=productoDao.get(7);
		tp.setCantidad(10);
		productoDao.update(tp);
	}
	
	
	public void delete(){
		TipoPersona tp=new TipoPersona();
		tp=tipoPersonaDao.get(102);
		tipoPersonaDao.delete(tp);
	}
	
	public void deletePersona(){
		Persona p=new Persona();
		p=personaDao.get(44);
		personaDao.delete(p);
	}
	
	public void createCategoria(){
		Categoria categoria=new Categoria();
		categoria.setNombre("ropas");
		categoria.setDescripcion("deportivas");
		categoria.setEstado("1");
		categoriaDao.create(categoria);
	}
	
	public void listCategoria(){
		List<Categoria> list=categoriaDao.list();
		for (Categoria categoria : list) {
			System.out.println("Id: "+categoria.getId()+" Nombre: "+categoria.getNombre());
		}
	}
}
