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

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.model.Guida;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.GuidaService;

@Controller
public class GuidaController {
	@Autowired
	private GuidaService guidaService;
	
    @Autowired
    private GuidaValidator guidaValidator;
    @Autowired
	private CredentialsService credentialsService;
        
    @RequestMapping(value="/admin/addGuida", method = RequestMethod.GET)
    public String addGuida(Model model) {
    	model.addAttribute("guida", new Guida());
        return "guidaForm";
    }

    @RequestMapping(value = "/guida/{id}", method = RequestMethod.GET)
    public String getGuida(@PathVariable("id") Long id, Model model) {
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("guida", this.guidaService.guidaPerId(id));
    	model.addAttribute("itinerari", this.guidaService.guidaPerId(id).getItinerari());
    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            return "admin/guida";
        }
        return "guida";
    }

    @RequestMapping(value = "/guideTeam", method = RequestMethod.GET)
    public String getGuide(Model model) {
    		model.addAttribute("guida", this.guidaService.tutti());
    		return "guideTeam";
    }
    
    @RequestMapping(value = "/admin/guida", method = RequestMethod.POST)
    public String addGuida(@ModelAttribute("guida") Guida guida, 
    									Model model, BindingResult bindingResult) {
    	this.guidaValidator.validate(guida, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.guidaService.inserisci(guida);
            model.addAttribute("guida", this.guidaService.tutti());
            return "guideTeam";
        }
        return "guidaForm";
    }
    @RequestMapping(value="/admin/eliminaGuida/{id}", method=RequestMethod.POST)
   	public String eliminaGuida(Model model, @PathVariable("id") Long idGuida) {
   		Guida guida = guidaService.guidaPerId(idGuida);
   		guidaService.eliminaGuida(guida);
   		model.addAttribute("guida", this.guidaService.tutti());
   		return "guideTeam";
   	}
}
