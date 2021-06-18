package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.service.GiornoService;
import it.uniroma3.siw.spring.service.ItinerarioService;
import it.uniroma3.siw.spring.service.MonumentoService;

@Controller
public class GiornoController {
	@Autowired
	private GiornoService giornoService;
	@Autowired
	private ItinerarioService itinerarioService;
	
    @Autowired
    private GiornoValidator giornoValidator;
    @Autowired
	private MonumentoService monumentoService;
        
    @RequestMapping(value="/admin/addGiorno", method = RequestMethod.GET)
    public String addGiorno(Model model) {
    	model.addAttribute("giorno", new Giorno());
    	model.addAttribute("itinerari", this.itinerarioService.tutti());
    	model.addAttribute("monumenti", this.monumentoService.tutti());
        return "giornoForm";
    }

    @RequestMapping(value = "/giorno/{id}", method = RequestMethod.GET)
    public String getGiorno(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("giorno", this.giornoService.giornoPerId(id));
    	model.addAttribute("monumenti", this.giornoService.giornoPerId(id).getMonumento());
    	return "giorno";
    }

    
    @RequestMapping(value = "/admin/giorno", method = RequestMethod.POST)
    public String addGuida(@ModelAttribute("giorno") Giorno giorno,  @RequestParam("itinerarioSelezionato") final Long idItinerario, 
    		                           @RequestParam("monumentoSelezionato") final List<Long> idMonumento,
    									Model model, BindingResult bindingResult) {
    	this.giornoValidator.validate(giorno, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.giornoService.inserisci(giorno);
        	this.giornoService.aggiungiItinerario(giorno, this.itinerarioService.itinerarioPerId(idItinerario));
        	for( Long id: idMonumento) {
        	this.giornoService.aggiungiMonumento(giorno, this.monumentoService.monumentoPerId(id));
        	}
            model.addAttribute("giorno", this.giornoService.tutti());
            model.addAttribute("itinerario", this.itinerarioService.tutti());
            return "itinerari";
        }
        return "giornoForm";
    }
}