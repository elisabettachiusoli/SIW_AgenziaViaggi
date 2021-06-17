package it.uniroma3.siw.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.service.ItinerarioService;

@Controller
public class ItinerarioController {
	
	@Autowired
	private ItinerarioService itinerarioService;
	
    @Autowired
    private ItinerarioValidator itinerarioValidator;
        
    @RequestMapping(value="/admin/addItinerario", method = RequestMethod.GET)
    public String addItinerario(Model model) {
    	model.addAttribute("itinerario", new Itinerario());
        return "itinerarioForm";
    }

    @RequestMapping(value = "/itinerario/{id}", method = RequestMethod.GET)
    public String getItinerario(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("itinerario", this.itinerarioService.itinerarioPerId(id));
    	model.addAttribute("giorni",  this.itinerarioService.itinerarioPerId(id).getGiorno());
    	return "itinerario";
    }

    @RequestMapping(value = "/itinerari", method = RequestMethod.GET)
    public String getItinerari(Model model) {
    		model.addAttribute("itinerario", this.itinerarioService.tutti());
    		return "itinerari";
    }
    
    @RequestMapping(value = "/admin/itinerario", method = RequestMethod.POST)
    public String addItinerario(@ModelAttribute("itinerario") Itinerario itinerario, 
    									Model model, BindingResult bindingResult) {
    	this.itinerarioValidator.validate(itinerario, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.itinerarioService.inserisci(itinerario);
            model.addAttribute("itinerario", this.itinerarioService.tutti());
            return "itinerari";
        }
        return "itinerarioForm";
    }
}
