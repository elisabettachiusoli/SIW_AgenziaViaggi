package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AgenziaViaggi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String citta;
	
	@Getter
	@Setter
	private String indirizzo;
	
	@OneToMany(mappedBy="agenziaViaggi")
	private List<Itinerario> itinerari;
	
	@OneToMany(mappedBy="agenziaViaggi")
	private List<Cliente> clienti;
	
	
	public AgenziaViaggi() {
		this.itinerari=new ArrayList<>();
		this.clienti=new ArrayList<>();
	}

}
