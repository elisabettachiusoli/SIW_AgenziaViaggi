package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Guida;
import it.uniroma3.siw.spring.repository.GuidaRepository;


@Service
public class GuidaService {
	@Autowired
	private GuidaRepository guidaRepository; 
	
	@Transactional
	public Guida inserisci(Guida guida) {
		return guidaRepository.save(guida);
	}

	@Transactional
	public List<Guida> tutti() {
		return (List<Guida>) guidaRepository.findAll();
	}
	
	@Transactional
	public List<Guida> guidePerNomeECognome(String nome, String cognome) {
		return guidaRepository.findByNomeAndCognome(nome, cognome);
	}

	@Transactional
	public Guida guidaPerId(Long id) {
		Optional<Guida> optional = guidaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Guida guida) {
		List<Guida> guide = this.guidaRepository.findByNome(guida.getNome());
		if (guide.size() > 0)
			return true;
		else 
			return false;
	}
}
