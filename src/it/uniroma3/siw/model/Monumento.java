package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Monumento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Getter
	@Setter
	private String titolo;
	
	@Getter
	@Setter
	private int anno;
	
	@Getter
	@Setter
	private String descrizione;
	@Getter
	@Setter
	private int orario;
	
	@Getter
	@Setter
	private String luogo;
	@Getter
	@Setter
	private int prezzoBiglietto;
	
	@ManyToOne
	private Giorno giorno;
	
	
	public Monumento() {
		
	}
}
