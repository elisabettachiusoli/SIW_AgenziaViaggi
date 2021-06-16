package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.uniroma3.siw.spring.model.Guida;
import it.uniroma3.siw.spring.service.GuidaService;

@Controller
public class GuidaController {
	@Autowired
	private GuidaService guidaService;
	
    @Autowired
    private GuidaValidator guidaValidator;
        
    @RequestMapping(value="/admin/guida", method = RequestMethod.GET)
    public String addGuida(Model model) {
    	model.addAttribute("guida", new Guida());
        return "guidaForm";
    }

    @RequestMapping(value = "/guida/{id}", method = RequestMethod.GET)
    public String getGuida(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("guida", this.guidaService.guidaPerId(id));
    	return "guida";
    }

    @RequestMapping(value = "/guideTeam", method = RequestMethod.GET)
    public String getGuide(Model model) {
    		model.addAttribute("guide", this.guidaService.tutti());
    		return "guideTeam";
    }
    
    @RequestMapping(value = "/admin/guida", method = RequestMethod.POST)
    public String addGuida(@ModelAttribute("guida") Guida guida, 
    									Model model, BindingResult bindingResult) {
    	this.guidaValidator.validate(guida, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.guidaService.inserisci(guida);
            model.addAttribute("guide", this.guidaService.tutti());
            return "guideTeam";
        }
        return "guidaForm";
    }
}
