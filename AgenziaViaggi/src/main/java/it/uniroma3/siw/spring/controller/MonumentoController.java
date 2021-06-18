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
import it.uniroma3.siw.spring.model.Monumento;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.MonumentoService;


@Controller
public class MonumentoController {
	@Autowired
	private MonumentoService monumentoService;
	
    @Autowired
    private MonumentoValidator monumentoValidator;
    @Autowired
	private CredentialsService credentialsService;
        
    @RequestMapping(value="/admin/addMonumento", method = RequestMethod.GET)
    public String addMonumento(Model model) {
    	model.addAttribute("monumento", new Monumento());
        return "monumentoForm";
    }

    @RequestMapping(value = "/monumento/{id}", method = RequestMethod.GET)
    public String getMonumento(@PathVariable("id") Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("monumento", this.monumentoService.monumentoPerId(id));
    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            return "admin/monumento";
        }
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
    @RequestMapping(value="/admin/eliminaMonumento/{id}", method=RequestMethod.POST)
   	public String eliminaMonumento(Model model, @PathVariable("id") Long idMonumento) {
    	Monumento monumento = monumentoService.monumentoPerId(idMonumento);
    	monumentoService.eliminaMonumento(monumento);
   		model.addAttribute("monumento", this.monumentoService.tutti());
   		return "monumenti";
   	}
}
