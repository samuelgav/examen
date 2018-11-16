package pe.com.examen.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.ProductoDao;
import pe.com.examen.dao.TestDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dao.UsuarioDao;
import pe.com.examen.dto.Cart;
import pe.com.examen.dto.Categoria;
import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.Producto;
import pe.com.examen.dto.Test;
import pe.com.examen.dto.TipoPersona;
import pe.com.examen.dto.Usuario;

public class Testeador {

	private static AnnotationConfigApplicationContext context;
	private static TipoPersonaDao tipoPersonaDao; 
	private static PersonaDao personaDao;
	private static CategoriaDao categoriaDao;
	private static ProductoDao productoDao;
	private static UsuarioDao usuarioDao;
	private static TestDao testDao;
	private static Testeador test;
	private final Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.scan("pe.com.examen");
		context.refresh();
		tipoPersonaDao=(TipoPersonaDao)context.getBean("tipopersonaDAO");
		personaDao=(PersonaDao)context.getBean("personaDAO");
		categoriaDao=(CategoriaDao)context.getBean("categoriaDAO");
		productoDao=(ProductoDao)context.getBean("productoDAO");
		usuarioDao=(UsuarioDao)context.getBean("usuarioDAO");
		testDao=(TestDao)context.getBean("testDAO");
		
		test=new Testeador();
		test.MayorMenor();
		//test.add();
		//test.update();
		//test.delete();
		//test.listarTipoPersona();
		//test.deletePersona();
		//test.listarPersona();
		//test.createCategoria();
		//test.listCategoria();
		//test.updateProducto();
		//test.listarProducto();
		//test.testAdd();
		//test.addTest();
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
			System.out.println("ID: "+producto.getId()+" Nombre: "+producto.getNombre()+" Codigo: "+producto.getCodigo()+ " Cantidad:"+producto.getCantidad()+ " Estado: "+producto.getEstado());
		}
	}
	
	
	public void add(){
		TipoPersona tp=new TipoPersona();
		tp.setDescripcion("ave");
		tipoPersonaDao.save(tp);
	}
	
	
	public void addTest(){
		Test t=new Test();
		t.setDescripcion("test 2");
		testDao.save(t);
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
	
	public void testAdd(){
		
		Usuario usuario=new Usuario();
		usuario.setNombres("Nombre 1");
		usuario.setApellidos("Apellido 1");
		usuario.setEmail("nombre1@gmail.com");
		usuario.setNumeroContacto("999999999");
		usuario.setEstado("1");
		usuario.setRol("USER");
		usuario.setPassword("12345");
				
		if(usuario.getRol().equals("USER")){
			Cart cart=new Cart();
			cart.setUsuario(usuario);
			usuario.setCart(cart);
		}
		
		usuarioDao.addUsuario(usuario);
						
	/*	Direccion direccion=new Direccion();
		direccion.setDireccionLineaUno("Lurigancho");
		direccion.setDireccionLineaDos("Chosica");
		direccion.setCiudad("Lima");
		direccion.setEstado("Lima");
		direccion.setPais("Peru");
		direccion.setCodigoPostal("051");
		direccion.setShipping("1");
		
		direccion.setUsuarioId(usuario.getId());
		direccion.setBilling("1");
		
		usuarioDao.addDireccion(direccion);*/
		}
	
	
		public void MayorMenor(){
			int mayor,menor,numero;
			System.out.println("Ingrese cantidad de numero: ");
			int cant=Integer.parseInt(sc.nextLine());
			System.out.println();
			System.out.println("Ingrese un numero:");
			numero=Integer.parseInt(sc.nextLine());
			mayor=numero;
			menor=mayor;
			for(int i=2;i<=cant;i++){
				System.out.println("Ingrese un numero: ");
				numero=Integer.parseInt(sc.nextLine());
				if(numero>mayor) mayor=numero;
				if(numero<menor) menor=numero;
			}
			System.out.println("El numero mayor es: "+mayor);
			System.out.println("El numero menor es: "+menor);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
