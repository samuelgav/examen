package pe.com.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.TipoPersona;

@Controller
@RequestMapping("/json/data")
public class PersonaController {

	@Autowired
	private TipoPersonaDao tipopersonaDAO;
	
	@Autowired
	private PersonaDao personaDAO;
	
		
	@RequestMapping("/all/tipopersona")
	@ResponseBody
	public List<TipoPersona> getAllTipPersonas() {			
			return tipopersonaDAO.list();					
	}
	
	@RequestMapping("/all/persona")
	@ResponseBody
	public List<Persona> getAllPersonas() {			
			return personaDAO.list();					
	}
	
}













