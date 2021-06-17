package it.uniroma3.siw.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Monumento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String titolo;

	private int anno;

	private String descrizione;

	private int orario;

	private String luogo;

	private int prezzoBiglietto;
	
	@ManyToOne
	private Giorno giorno;
	
	
	public Monumento() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getOrario() {
		return orario;
	}


	public void setOrario(int orario) {
		this.orario = orario;
	}


	public String getLuogo() {
		return luogo;
	}


	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}


	public int getPrezzoBiglietto() {
		return prezzoBiglietto;
	}


	public void setPrezzoBiglietto(int prezzoBiglietto) {
		this.prezzoBiglietto = prezzoBiglietto;
	}


	public Giorno getGiorno() {
		return giorno;
	}


	public void setGiorno(Giorno giorno) {
		this.giorno = giorno;
	}
}
