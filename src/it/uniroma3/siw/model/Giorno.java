package it.uniroma3.siw.model;

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
public class Giorno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Getter
	@Setter
	private int numeroGiornoDiVisita;
	
	@Getter
	@Setter
	private String zona;
	
	@Getter
	@Setter
	private int costoGiornata;
	
	@Getter
	@Setter
	private int durata;
	
	@ManyToOne
	private Itinerario itinerario;
	
	
	@OneToMany(mappedBy="giorno")
	private List<Monumento> monumenti;
	
	public Giorno() {
		this.monumenti=new ArrayList<>();
	}
}
