package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Itinerario;

public interface ItinerarioRepository extends CrudRepository<Itinerario, Long> {

	public List<Itinerario> findByNome(String nome);
}