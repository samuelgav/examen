package pe.com.examen.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pe.com.examen.dto.Persona;

public class PersonaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Persona.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Persona persona=(Persona) target;
		if(persona.getFile() ==null || persona.getFile().getOriginalFilename().equals("")){
			errors.rejectValue("file", null, "por favor seleccione un archivo!");
			return;
		}
		if(!(persona.getFile().getContentType().equals("image/jpeg")||persona.getFile().getContentType().equals("image/png")||persona.getFile().getContentType().equals("image/gif"))){
			errors.rejectValue("file", null, "por favor solo seleccione archivo tipo imagen");
		}		
	}
}
