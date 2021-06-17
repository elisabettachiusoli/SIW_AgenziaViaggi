package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Giorno;
import it.uniroma3.siw.spring.repository.GiornoRepository;

@Service
public class GiornoService {

	@Autowired
	private GiornoRepository giornoRepository; 
	
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

}
