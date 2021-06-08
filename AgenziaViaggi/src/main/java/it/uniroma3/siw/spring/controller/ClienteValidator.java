package it.uniroma3.siw.spring.controller;



import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.qos.logback.classic.Logger;
import it.uniroma3.siw.spring.model.Cliente;



@Component
public class ClienteValidator implements Validator {
 
	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroDiTelefono", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cittaDaVisitare", "required");
		

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Cliente.class.equals(aClass);
	}
}