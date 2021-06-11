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
	
   // @Autowired
    //private ItinerarioValidator itinerarioValidator;
        
    @RequestMapping(value="/itinerarioForm1", method = RequestMethod.GET)
    public String addProdotto(Model model) {
    	model.addAttribute("itinerario", new Itinerario());
        return "itinerarioForm";
    }

    @RequestMapping(value = "/itinerario/{id}", method = RequestMethod.GET)
    public String getItinerario(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("itinerario", this.itinerarioService.itinerarioPerId(id));
    	return "itinerario";
    }

    @RequestMapping(value = "/itinerario", method = RequestMethod.GET)
    public String getItinerari(Model model) {
    		model.addAttribute("itinerari", this.itinerarioService.tutti());
    		return "itinerari.html";
    }
    
    @RequestMapping(value = "/itinerarioForm", method = RequestMethod.POST)
    public String addProdotto(@ModelAttribute("itinerario") Itinerario itinerario, 
    									Model model, BindingResult bindingResult) {
    	//this.prodottoValidator.validate(prodotto, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.itinerarioService.inserisci(itinerario);
            model.addAttribute("itinerari", this.itinerarioService.tutti());
            return "itinerari.html";
        }
        return "itinerarioForm.html";
    }
}
