package com.basededatos.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.basededatos.domain.Usuario;

@Component
public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return Usuario.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object userObj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "", "El apellido es un campo requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "El clave es un campo requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "", "El nombre es un campo requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "El Email es un campo requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreUsuario", "", "El usuario es un campo requerido.");
		
	}
	

}
