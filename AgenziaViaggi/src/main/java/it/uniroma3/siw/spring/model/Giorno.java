package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Giorno {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private int numeroGiornoDiVisita;

	@Column
	private String zona;

	@Column
	private String descrizione;

	@Column
	private int costoGiornata;

	@Column
	private int durata;

	@ManyToOne
	private Itinerario itinerario;

	@OneToMany
	private List<Monumento> monumenti;

	public Giorno() {
		this.monumenti=new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNumeroGiornoDiVisita() {
		return numeroGiornoDiVisita;
	}

	public void setNumeroGiornoDiVisita(int numeroGiornoDiVisita) {
		this.numeroGiornoDiVisita = numeroGiornoDiVisita;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getCostoGiornata() {
		return costoGiornata;
	}

	public void setCostoGiornata(int costoGiornata) {
		this.costoGiornata = costoGiornata;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public List<Monumento> getMonumento() {
		return monumenti;
	}

	public void setMonumento(Monumento monumento) {
		this.monumenti.add(monumento);
	}	
}