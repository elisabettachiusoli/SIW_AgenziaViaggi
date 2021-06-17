package it.uniroma3.siw.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.UserService;

@Component
public class Inizializzazione implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CredentialsService credentialService;
	
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
	}
}
