package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Guida;

public interface GuidaRepository extends CrudRepository<Guida, Long> {
	public List<Guida> findByNome(String nome);
	
	public List<Guida> findByNomeAndCognome(String nome, String cognome);
}
