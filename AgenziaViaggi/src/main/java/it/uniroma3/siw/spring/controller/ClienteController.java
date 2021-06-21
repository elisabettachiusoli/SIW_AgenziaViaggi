package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteValidator clienteValidator;
	@Autowired
	private ClienteService clienteService;
	

	@RequestMapping(value="/cliente", method = RequestMethod.POST)
	public String newCliente(@ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult) {
		this.clienteValidator.validate(cliente, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.clienteService.inserisci(cliente);
			return "dati.html";
		}
		return "form.html";
	}
	@RequestMapping(value="/clienti", method = RequestMethod.GET)
	public String newCliente(Model model) {
     model.addAttribute("clienti",clienteService.tutti());
     return "clienti.html";
	}
	
	@RequestMapping(value="/admin/eliminaCliente/{id}", method=RequestMethod.POST)
	public String eliminaCliente(Model model, @PathVariable("id") Long idCliente) {
		Cliente cliente = clienteService.clientePerId(idCliente);
		clienteService.eliminaCliente(cliente);
		model.addAttribute("clienti", this.clienteService.tutti());
		return "clienti";
	}
}
