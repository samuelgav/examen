package pe.com.examen.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pe.com.examen.dto.Producto;

public class ProductoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Producto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Producto producto=(Producto) target;
		if(producto.getFile() == null || producto.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "por favor seleccione un archivo!!");
			return;
		}
		if(! (producto.getFile().getContentType().equals("image/jpeg") || 
				producto.getFile().getContentType().equals("image/png")) ||
				producto.getFile().getContentType().equals("image/gif")
			 )
			{
			errors.rejectValue("file", null, "Por favor ingrese archivo tipo imagen!!");
				return;	
			}
		
		
	}

}
