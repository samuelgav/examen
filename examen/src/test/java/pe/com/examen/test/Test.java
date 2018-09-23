package pe.com.examen.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.TipoPersona;

public class Test {

	private static AnnotationConfigApplicationContext context;
	private static TipoPersonaDao tipoPersonaDao; 
	private static PersonaDao personaDao;
	private static Test test;
	
	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.scan("pe.com.examen");
		context.refresh();
		tipoPersonaDao=(TipoPersonaDao)context.getBean("tipopersonaDAO");
		personaDao=(PersonaDao)context.getBean("personaDAO");
				
		test=new Test();
		//test.add();
		//test.update();
		//test.delete();
		//test.listarTipoPersona();
		//test.deletePersona();
		test.listarPersona();
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
	
}
