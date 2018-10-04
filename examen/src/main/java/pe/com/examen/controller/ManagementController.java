package pe.com.examen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.com.examen.dao.CategoriaDao;
import pe.com.examen.dao.PersonaDao;
import pe.com.examen.dao.ProductoDao;
import pe.com.examen.dao.TipoPersonaDao;
import pe.com.examen.dto.Categoria;
import pe.com.examen.dto.Persona;
import pe.com.examen.dto.Producto;
import pe.com.examen.dto.TipoPersona;
import pe.com.examen.model.Response;
import pe.com.examen.util.FileUtil;
import pe.com.examen.validator.PersonaValidator;
import pe.com.examen.validator.ProductoValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired 
	private TipoPersonaDao tipopersonaDAO;
	
	@Autowired
	private PersonaDao personaDAO;
	
	@Autowired
	private ProductoDao productoDAO;
	
	@Autowired
	private CategoriaDao categoriaDAO;
		
	@RequestMapping(value="/tipopersona")
	public ModelAndView manageTipoPersona(@RequestParam(name="success",required=false)String success){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickAddOrUpdateTipoPersona",true);
		mv.addObject("tipopersona", new TipoPersona());
		if(success !=null){
			if(success.equals("tipopersona")){
				mv.addObject("message", "Tipo Persona guardado exitosamente!!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/persona")
	public ModelAndView managePersona(@RequestParam(name="success",required=false)String success){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickAddOrUpdatePersona", true);
		mv.addObject("persona", new Persona());
		if(success !=null){
			if(success.equals("persona")){
			mv.addObject("message", "Persona guardado Exitosamente!");
			}
		}
		return mv;
	}
	
	
	@RequestMapping(value="/producto")
	public ModelAndView manageProducto(@RequestParam(name="success",required=false)String success){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickAdministrarProducto", true);
		Producto producto=new Producto();
		producto.setUsuarioId(1);
		producto.setEstado("1");
		mv.addObject("producto", producto);
		if(success != null) {
			if(success.equals("producto")){
				mv.addObject("message", "Producto Enviado correctamente!");
			}	
			else if (success.equals("categoria")) {
				mv.addObject("message", "Categoria Enviado correctamente!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/{id}/producto")
	public ModelAndView manageProductoEdit(@PathVariable int id){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickAdministrarProducto", true);
		mv.addObject("producto", productoDAO.get(id));
		return mv;
	}
	
	
	
	@RequestMapping(value="/producto",method=RequestMethod.POST)
	public String managePostProducto(@Valid @ModelAttribute("producto") Producto producto,BindingResult
									results,Model model,HttpServletRequest request){
		if(producto.getId()==0){
			new ProductoValidator().validate(producto, results);
		}
		else{
			if(!producto.getFile().getOriginalFilename().equals("")){
				new ProductoValidator().validate(producto, results);
			}
		}
		
		if(results.hasErrors()){
			model.addAttribute("message", "Fallo al enviar datos!!");
			model.addAttribute("userClickAdministrarProducto", true);
			return "page";
		}
		
		if(producto.getId()==0){
			productoDAO.save(producto);
		}else{
			productoDAO.update(producto);
		}
		
		if(!producto.getFile().getOriginalFilename().equals("")){
			FileUtil.uploadFile(request, producto.getFile(), producto.getCodigo());
		}
		
		return "redirect:/manage/producto?success=producto";
	}
	
	
	
	@RequestMapping(value="/categoria",method=RequestMethod.POST)
	public String managePostCategoria(@ModelAttribute("categoria") Categoria categoria,HttpServletRequest request){
		categoriaDAO.create(categoria);
		return "redirect:"+request.getHeader("Referer")+"?success=categoria";
	}
	
	
	@ModelAttribute("categorias")
	public List<Categoria> modeloCategorias(){
		return categoriaDAO.list();
	}
	
	@ModelAttribute("categoria")
	public Categoria modeloCategoria(){
		return new Categoria();
	}
	
	
	
	
	@RequestMapping("/{id}/tipopersona")
	public ModelAndView manageTipoPersonaEdit(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("userClickAddOrUpdateTipoPersona",true);				
		mv.addObject("tipopersona", tipopersonaDAO.get(id));			
		return mv;
		
	}
	
	@RequestMapping("/{idpersona}/persona")
	public ModelAndView managePersonaEdit(@PathVariable int idpersona) {		

		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("userClickAddOrUpdatePersona",true);				
		mv.addObject("persona", personaDAO.get(idpersona));			
		return mv;
		
	}
	
	@RequestMapping(value="/tipopersona",method=RequestMethod.POST)
	public String ManagePostTipoPersona(@Valid @ModelAttribute("tipopersona") TipoPersona tipoPersona,
										BindingResult results, Model model){
		if(results.hasErrors()) {
			model.addAttribute("message", "Fallo al realizar Operacion, llene todos los campos!!");
			model.addAttribute("userClickAddOrUpdateTipoPersona",true);
			return "page";
		}		
		if(tipoPersona.getId() == 0 ) {
			tipopersonaDAO.save(tipoPersona);
		}
		else {
			tipopersonaDAO.update(tipoPersona);
		}		
		return "redirect:/manage/tipopersona?success=tipopersona";
	}
	
	
	@RequestMapping(value="/persona",method=RequestMethod.POST)
	public String ManagePostPersona(@Valid @ModelAttribute("persona") Persona persona,
										BindingResult results, Model model,HttpServletRequest request){
			
		if(persona.getIdpersona()==0){
			new PersonaValidator().validate(persona, results);
		}else{
			if(!persona.getFile().getOriginalFilename().equals("")){
				new PersonaValidator().validate(persona, results);
			}
		}
				
		if(results.hasErrors()) {
			model.addAttribute("message", "Fallo al realizar Operacion, llene todos los campos!!");
			model.addAttribute("userClickAddOrUpdatePersona",true);
			return "page";
		}
		
		
		if(persona.getIdpersona() == 0 ) {
			personaDAO.save(persona);
		}
		else {
			personaDAO.update(persona);
		}	
		
		if(!persona.getFile().getOriginalFilename().equals("")){
			FileUtil.uploadFile(request, persona.getFile(), persona.getNombres());
		}
		
		
		return "redirect:/manage/persona?success=persona";
	}
	
	
	
	@RequestMapping(value = "/{id}/delete", method=RequestMethod.POST)
	@ResponseBody
	public Response DeleteTipoPersona(@PathVariable int id) {		
		TipoPersona tipoPersona = tipopersonaDAO.get(id);
		Response response=null;
		if(tipopersonaDAO.delete(tipoPersona)){
			response=new Response("success", "Tipo Persona eliminado correctamente!!");
		}else{
			response=new Response("error", "Error al eliminar Tipo Persona!!");
		}
		return response;
	}
	
	@RequestMapping(value = "/persona/{idpersona}/delete", method=RequestMethod.POST)
	@ResponseBody
	public Response DeletePersona(@PathVariable int idpersona) {		
		Persona persona = personaDAO.get(idpersona);
		Response response=null;
		if(personaDAO.delete(persona)){
			response=new Response("success", "Persona eliminado correctamente!!");
		}else{
			response=new Response("error", "Error al eliminar Persona!!");
		}
		return response;
	}
	
	@ModelAttribute("tipopersonas")
	public List<TipoPersona> modelTipoPersonas(){
		return tipopersonaDAO.list();
	}
	
	
	
	@RequestMapping(value = "/producto/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {
		Producto producto=productoDAO.get(id);
		String estado=producto.getEstado();
		String mensaje="";		
		if(estado.equals("1")){
			producto.setEstado("0");
			mensaje="Producto desactivado correctamente";
		}else if(estado.equals("0")){
			producto.setEstado("1");
			mensaje="Producto activado correctamente";
		}
		productoDAO.update(producto);
		return mensaje;
		
	}	
}
