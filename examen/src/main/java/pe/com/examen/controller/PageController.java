package pe.com.examen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class PageController {
	
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
	
	
}
