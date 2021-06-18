package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.service.GiornoService;

@Component
public class GiornoValidator implements Validator {
	@Autowired
	private GiornoService giornoService;
	
    private static final Logger logger = LoggerFactory.getLogger(GiornoValidator.class);
    
    @Override
	public void validate(Object o, Errors errors) {
		

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			/*if (this.giornoService.alreadyExists((Giorno)o)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}*/
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Giorno.class.equals(aClass);
	}
}