package it.uniroma3.siw.spring.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Itinerario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private String destinazione;
	
	@Getter
	@Setter
	private String descrizione;
	
	@Getter
	@Setter
	private LocalDate periodo;
	
	@Getter
	@Setter
	private LocalDate scadenzaPrenotazione;
	
	@Getter
	@Setter
	private int costoTotale;
	
	@OneToMany(mappedBy="itinerario")
	private List<Giorno> giorno;
	
	@ManyToOne
	private AgenziaViaggi agenziaViaggi;
	
	@ManyToOne
	private Guida guida;
	
	public Itinerario() {
		this.giorno=new ArrayList<>();
	}
}
