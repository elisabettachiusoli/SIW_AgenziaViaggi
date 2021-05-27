package it.uniroma3.siw.spring.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItinerarioController {
	
	
	   @RequestMapping(value="/itinerario", method = RequestMethod.GET)
	    public String getItinerario() {
		   
	        return "itinerario.html";
	    }
	   
	   @RequestMapping(value="/guida", method = RequestMethod.GET)
	    public String getGuida() {
	        return "guida.html";
	    }
	   
	   @RequestMapping(value="/monumento", method = RequestMethod.GET)
	    public String getMonumento() {
	    	
	        return "monumento.html";
	    }
	   @RequestMapping(value="/giorno", method = RequestMethod.GET)
	    public String getGiorno() {
	        return "giorno.html";
	    }
	   @RequestMapping(value="/guideTeam", method = RequestMethod.GET)
	    public String getGuide() {
	        return "guideTeam.html";
	    }
	   @RequestMapping(value="/informazioni", method = RequestMethod.GET)
	    public String getInfo() {
	        return "informazioni.html";
	    }

}
