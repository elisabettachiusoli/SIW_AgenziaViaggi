package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.service.GiornoService;

@Controller
public class GiornoController {
	@Autowired
	private GiornoService giornoService;
	
    @Autowired
    private GiornoValidator giornoValidator;
        
    @RequestMapping(value="/admin/addGiorno", method = RequestMethod.GET)
    public String addGiorno(Model model) {
    	model.addAttribute("giorno", new Giorno());
        return "giornoForm";
    }

    @RequestMapping(value = "/giorno/{id}", method = RequestMethod.GET)
    public String getGiorno(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("giorno", this.giornoService.giornoPerId(id));
    	return "giorno";
    }

    @RequestMapping(value = "/giorni", method = RequestMethod.GET)
    public String getGiorno(Model model) {
    		model.addAttribute("giorno", this.giornoService.tutti());
    		return "giorni";
    }
    
    @RequestMapping(value = "/admin/giorno", method = RequestMethod.POST)
    public String addGuida(@ModelAttribute("giorno") Giorno giorno, 
    									Model model, BindingResult bindingResult) {
    	this.giornoValidator.validate(giorno, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.giornoService.inserisci(giorno);
            model.addAttribute("giorno", this.giornoService.tutti());
            return "giorni";
        }
        return "giornoForm";
    }
}