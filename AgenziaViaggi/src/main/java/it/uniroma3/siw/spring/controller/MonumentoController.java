package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.uniroma3.siw.spring.model.Monumento;
import it.uniroma3.siw.spring.service.MonumentoService;


@Controller
public class MonumentoController {
	@Autowired
	private MonumentoService monumentoService;
	
    @Autowired
    private MonumentoValidator monumentoValidator;
        
    @RequestMapping(value="/admin/addMonumento", method = RequestMethod.GET)
    public String addMonumento(Model model) {
    	model.addAttribute("monumento", new Monumento());
        return "monumentoForm";
    }

    @RequestMapping(value = "/monumento/{id}", method = RequestMethod.GET)
    public String getMonumento(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("monumento", this.monumentoService.monumentoPerId(id));
    	return "monumento";
    }

    @RequestMapping(value = "/monumenti", method = RequestMethod.GET)
    public String getMonumenti(Model model) {
    		model.addAttribute("monumento", this.monumentoService.tutti());
    		return "monumenti";
    }
    
    @RequestMapping(value = "/admin/monumento", method = RequestMethod.POST)
    public String addMonumento(@ModelAttribute("monumento") Monumento monumento, 
    									Model model, BindingResult bindingResult) {
    	this.monumentoValidator.validate(monumento, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.monumentoService.inserisci(monumento);
            model.addAttribute("monumento", this.monumentoService.tutti());
            return "monumenti";
        }
        return "monumentoForm";
    }
}
