package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Monumento;

public interface MonumentoRepository extends CrudRepository<Monumento, Long> {
	
	public List<Monumento> findByTitolo(String titolo);
}
