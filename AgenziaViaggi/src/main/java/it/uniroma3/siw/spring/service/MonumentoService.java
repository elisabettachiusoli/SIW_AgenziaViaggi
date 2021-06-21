package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Monumento;
import it.uniroma3.siw.spring.repository.GiornoRepository;
import it.uniroma3.siw.spring.repository.MonumentoRepository;


@Service
public class MonumentoService {

	@Autowired
	private MonumentoRepository monumentoRepository;
	@Autowired	
	private GiornoRepository giornoRepository; 

	@Transactional
	public Monumento inserisci(Monumento monumento) {
		return monumentoRepository.save(monumento);
	}

	@Transactional
	public List<Monumento> tutti() {
		return (List<Monumento>) monumentoRepository.findAll();
	}

	@Transactional
	public List<Monumento> monumentoPerTitolo(String titolo) {
		return monumentoRepository.findByTitolo(titolo);
	}

	@Transactional
	public Monumento monumentoPerId(Long id) {
		Optional<Monumento> optional = monumentoRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Monumento monumento) {
		List<Monumento> monumenti = this.monumentoRepository.findByTitolo(monumento.getTitolo());
		if (monumenti.size() > 0)
			return true;
		else 
			return false;
	}

	public void eliminaMonumento(Monumento monumento) {
		if(monumento.getGiorno()!=null) {
		monumento.getGiorno().getMonumento().remove(monumento);
		giornoRepository.save(monumento.getGiorno());
		}
		monumentoRepository.delete(monumento);

	}
}