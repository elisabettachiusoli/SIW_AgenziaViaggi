package it.uniroma3.siw.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.GuidaService;
import it.uniroma3.siw.spring.service.ItinerarioService;

@Controller
public class ItinerarioController {
	
	@Autowired
	private ItinerarioService itinerarioService;
	
    @Autowired
    private ItinerarioValidator itinerarioValidator;
    @Autowired
	private GuidaService guidaService;
    @Autowired
	private CredentialsService credentialsService;
        
    @RequestMapping(value="/admin/addItinerario", method = RequestMethod.GET)
    public String addItinerario(Model model) {
    	model.addAttribute("itinerario", new Itinerario());
    	model.addAttribute("guide", this.guidaService.tutti());
        return "itinerarioForm";
    }

    @RequestMapping(value = "/itinerario/{id}", method = RequestMethod.GET)
    public String getItinerario(@PathVariable("id") Long id, Model model) {
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("itinerario", this.itinerarioService.itinerarioPerId(id));
    	model.addAttribute("giorni",  this.itinerarioService.itinerarioPerId(id).getGiorno());
    	model.addAttribute("guida",  this.itinerarioService.itinerarioPerId(id).getGuida());
    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            return "admin/itinerario";
        }
        return "itinerario";
    }

    @RequestMapping(value = "/itinerari", method = RequestMethod.GET)
    public String getItinerari(Model model) {
    		model.addAttribute("itinerario", this.itinerarioService.tutti());
    		return "itinerari";
    }
    
    @RequestMapping(value = "/admin/itinerario", method = RequestMethod.POST)
    public String addItinerario(@ModelAttribute("itinerario") Itinerario itinerario, @RequestParam("guidaSelezionata") final Long idGuida,
    									Model model, BindingResult bindingResult) {
    	this.itinerarioValidator.validate(itinerario, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.itinerarioService.inserisci(itinerario);
        	this.itinerarioService.aggiungiGuida(this.guidaService.guidaPerId(idGuida), itinerario);
            model.addAttribute("itinerario", this.itinerarioService.tutti());
            return "itinerari";
        }
        return "itinerarioForm";
    }
    
    @RequestMapping(value="/admin/eliminaItinerario/{id}", method=RequestMethod.POST)
   	public String eliminaItinerario(Model model, @PathVariable("id") Long idItinerario) {
    	Itinerario itinerario = itinerarioService.itinerarioPerId(idItinerario);
   		itinerarioService.eliminaItinerario(itinerario);
   		model.addAttribute("itinerario", this.itinerarioService.tutti());
   		return "itinerari";
   	}
}
