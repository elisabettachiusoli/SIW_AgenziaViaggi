package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.service.ItinerarioService;


@Component
public class ItinerarioValidator implements Validator {
	@Autowired
	private ItinerarioService itinerarioService;
	
    private static final Logger logger = LoggerFactory.getLogger(ItinerarioValidator.class);
    
    @Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destinazione", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.itinerarioService.alreadyExists((Itinerario)o)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Itinerario.class.equals(aClass);
	}
}
