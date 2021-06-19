package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.model.Monumento;
import it.uniroma3.siw.spring.repository.GiornoRepository;
import it.uniroma3.siw.spring.repository.ItinerarioRepository;
import it.uniroma3.siw.spring.repository.MonumentoRepository;

@Service
public class GiornoService {

	@Autowired
	private GiornoRepository giornoRepository;

	@Autowired
	private ItinerarioRepository itinerarioRepository;

	@Autowired
	private MonumentoRepository monumentoRepository; 

	@Transactional
	public Giorno inserisci(Giorno giorno) {
		return giornoRepository.save(giorno);
	}

	@Transactional
	public List<Giorno> tutti() {
		return (List<Giorno>) giornoRepository.findAll();
	}

	@Transactional
	public Giorno giornoPerId(Long id) {
		Optional<Giorno> optional = giornoRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	public void aggiungiItinerario(Giorno giorno, Itinerario itinerario) {
		giorno.setItinerario(itinerario);
		itinerario.setGiorno(giorno);
		this.giornoRepository.save(giorno);
		this.itinerarioRepository.save(itinerario);		
	}

	public void aggiungiMonumento(Giorno giorno, Monumento monumento) {
		giorno.setMonumento(monumento);
		this.giornoRepository.save(giorno);
		monumento.setGiorno(giorno);
		this.monumentoRepository.save(monumento);		
	}

	public void eliminaGiorno(Giorno giorno) {
		List<Monumento> monumenti=giorno.getMonumento();
		for(Monumento monumento:monumenti) {
			monumento.setGiorno(null);
			monumentoRepository.save(monumento);
		}
		giornoRepository.delete(giorno);		
	}
}