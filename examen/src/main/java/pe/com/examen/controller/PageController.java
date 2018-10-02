package pe.com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dto.Categoria;
import pe.com.examen.dto.Persona;
import pe.com.examen.exception.PersonaNotFoundException;



@Controller
public class PageController {
	
	@Autowired
	private PersonaDao personaDAO;
	
	@Autowired
	private CategoriaDao categoriaDAO;
	
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value="/login")
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value = "/show/all/tipopersona")
	public ModelAndView showAllTipoPersonas() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("userClickAllTipoPersona",true);
		return mv;				
	}
	
	@RequestMapping(value = "/show/all/personas")
	public ModelAndView showAllPersonas() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("userClickAllPersona",true);
		return mv;				
	}
	
	@RequestMapping(value="/show/{idpersona}/persona")
	public ModelAndView showSinglePersona(@PathVariable int idpersona) throws PersonaNotFoundException{
		ModelAndView mv=new ModelAndView("page");
		Persona persona=personaDAO.get(idpersona);
		if(persona ==null) throw new PersonaNotFoundException();
		//mv.addObject("title", persona.getNombres());
		if(persona.getSexo().equals("M")){
			mv.addObject("sexo", "Masculino");
		}else{
			mv.addObject("sexo", "Femenino");
		}
		mv.addObject("persona", persona);
		mv.addObject("userClickShowPersona", true);
		return mv;
	}
	
	@RequestMapping(value="/show/all/producto")
	public ModelAndView showAllProductos(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("categorias", categoriaDAO.list());
		mv.addObject("userClickAllProductos",true);
		return mv;		
	}
	
	@RequestMapping(value="/show/categoria/{id}/productos")
	public ModelAndView showProductosPorCategoria(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("page");
		Categoria categoria=null;
		categoria=categoriaDAO.get(id);
		mv.addObject("categorias", categoriaDAO.list());
		mv.addObject("categoria", categoria);
		mv.addObject("userClickCategoriaProductos", true);
		return mv;
	}
}
