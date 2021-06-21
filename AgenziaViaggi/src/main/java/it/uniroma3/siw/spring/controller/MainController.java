package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.service.ClienteService;

@Controller
public class MainController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteValidator clienteValidator;

	@RequestMapping(value={"/ ", "/index"}, method = RequestMethod.GET)
	public String Index(Model model) {
		return "index.html";
	}

	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String Form(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "form.html";
	}



	@RequestMapping(value="/informazioni", method = RequestMethod.GET)
	public String getInfo() {
		return "informazioni.html";
	}

	@RequestMapping(value={"/home"}, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
}
