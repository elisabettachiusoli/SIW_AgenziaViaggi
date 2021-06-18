package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Guida;
import it.uniroma3.siw.spring.model.Itinerario;
import it.uniroma3.siw.spring.repository.GuidaRepository;
import it.uniroma3.siw.spring.repository.ItinerarioRepository;

@Service
public class ItinerarioService {
	
	@Autowired
	private ItinerarioRepository itinerarioRepository;
	@Autowired
	private GuidaRepository guidaRepository; 
	
	@Transactional
	public Itinerario inserisci(Itinerario itinerario) {
		return itinerarioRepository.save(itinerario);
	}

	@Transactional
	public List<Itinerario> tutti() {
		return (List<Itinerario>) itinerarioRepository.findAll();
	}
	
	@Transactional
	public List<Itinerario> guidePerNomeEDestinazione(String nome, String destinazione) {
		return itinerarioRepository.findByNomeAndDestinazione(nome, destinazione);
	}

	@Transactional
	public Itinerario itinerarioPerId(Long id) {
		Optional<Itinerario> optional = itinerarioRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Itinerario itinerario) {
		List<Itinerario> itinerari = this.itinerarioRepository.findByNome(itinerario.getNome());
		if (itinerari.size() > 0)
			return true;
		else 
			return false;
	}
	
	public void aggiungiGuida(Guida guida, Itinerario itinerario) {
		itinerario.setGuida(guida);
		guida.setItinerari(itinerario);
        this.itinerarioRepository.save(itinerario);
        this.guidaRepository.save(guida);
	}
	
	@Transactional
	public void eliminaItinerario(Itinerario itinerario) {
		itinerarioRepository.delete(itinerario);
	}
}
