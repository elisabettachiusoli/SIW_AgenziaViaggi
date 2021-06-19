package it.uniroma3.siw.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.model.Guida;
import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.model.Monumento;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.GiornoService;
import it.uniroma3.siw.spring.service.GuidaService;
import it.uniroma3.siw.spring.service.ItinerarioService;
import it.uniroma3.siw.spring.service.MonumentoService;
import it.uniroma3.siw.spring.service.UserService;

@Component
public class Inizializzazione implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserService userService;

	@Autowired
	private CredentialsService credentialService;

	@Autowired
	private ItinerarioService itinerarioService;

	@Autowired
	private GiornoService giornoService;

	@Autowired
	private MonumentoService monumentoService;

	@Autowired
	private GuidaService guidaService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User user1 = new User();
		user1.setNome("user1");
		user1.setCognome("user1");
		userService.salvaUser(user1);

		Credentials credentials1 = new Credentials();
		credentials1.setUsername("admin");
		credentials1.setRole("ADMIN");
		credentials1.setPassword("admin");
		credentials1.setUser(user1);
		credentialService.saveCredentials2(credentials1);

		User user2 = new User();
		user2.setNome("user2");
		user2.setCognome("user2");
		userService.salvaUser(user2);

		Credentials credentials2 = new Credentials();
		credentials2.setUsername("default");
		credentials2.setPassword("default");
		credentials2.setRole("DEFAULT");
		credentials2.setUser(user2);
		credentialService.saveCredentials2(credentials2);

		Giorno giorno1 = new Giorno();
		giornoService.inserisci(giorno1);

		Monumento monumento1= new Monumento();
		monumento1.setAnno(1999);
		monumento1.setDescrizione("Nel complesso l’Isola dei musei di Berlino è una grandiosa opera d’arte: cinque musei di fama mondiale dell’epoca prussiana, con l’aggiunta della moderna James-Simon-Galerie, formano una straordinaria area museale");
		monumento1.setGiorno(giorno1);
		monumento1.setLuogo("BodestraBe 1-3, 10178 Berlin, Germania");
		monumento1.setTitolo("L'isola dei musei");
		monumento1.setOrario(10);
		monumento1.setPrezzoBiglietto(18);
		monumento1.setFile("https://images.musement.com/cover/0050/79/berlin-museum-island-jpg_header-4978821.jpeg?q=50&fit=crop&auto=format&w=1024&h=400");
		monumentoService.inserisci(monumento1);

		Monumento monumento2= new Monumento();
		monumento2.setAnno(1791);
		monumento2.setDescrizione("È il monumento più famoso di Berlino ed è conosciuto in tutto il mondo come simbolo della città stessa e dell’intera Germania.");
		monumento2.setGiorno(giorno1);
		monumento2.setLuogo("Pariser Platz");
		monumento2.setTitolo("Porta di Brandeburgo");
		monumento2.setFile("https://mywowo.net/media/images/cache/berlino_porta_brandeburgo_01_presentazione_jpg_1200_630_cover_85.jpg");
		monumentoService.inserisci(monumento2);

		Guida guida1=new Guida();
		guida1.setCognome("Rossi");
		guida1.setNome("Matteo");
		guida1.setEmail("matteo.rossi@gmail.com");
		guida1.setMatricola(0526);
		guida1.setNumeroDiTelefono(33947);


		Itinerario itinerario1= new Itinerario();
		itinerario1.setCostoTotale(400);
		itinerario1.setDataFine("13-07-2021");
		itinerario1.setDataInizio("20-07-2021");
		itinerario1.setScadenzaPrenotazione("13-05-2021");
		itinerario1.setDestinazione("Berlino");
		itinerario1.setGiorno(giorno1);
		itinerario1.setNome("A spasso per Berlino");
		itinerario1.setDescrizione("Un nuovissimo itinerario alla scoperta dei più bei monumenti di Berlino");
		itinerario1.setGuida(guida1);
		guida1.setItinerari(itinerario1);
		itinerarioService.inserisci(itinerario1);
		guidaService.inserisci(guida1);

		giorno1.setCostoGiornata(40);
		giorno1.setDescrizione("Restaurant Maximilians Berlin, FriedrichstraBe 185-190 ");
		giorno1.setDurata(3);
		giorno1.setItinerario(itinerario1);
		giorno1.setNumeroGiornoDiVisita(1);
		giorno1.setZona("quartiere Museumsinsel e Mitte");
		giorno1.setMonumento(monumento1);
		giorno1.setMonumento(monumento2);
		giornoService.inserisci(giorno1);		
	}
}
