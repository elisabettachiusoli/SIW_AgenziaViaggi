package it.uniroma3.siw.spring.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	private String nome;

	private String destinazione;

	private String descrizione;

	private Date dataInizio;

	private Date dataFine;

	private Date scadenzaPrenotazione;
	
	private int costoTotale;
	
	@OneToMany(mappedBy="itinerario")
	private List<Giorno> giorni;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AgenziaViaggi agenziaViaggi;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Guida guida;
	
	public Itinerario() {
		this.giorni=new ArrayList<>();
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDestinazione() {
		return destinazione;
	}
	
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(Date date) {
		this.dataInizio = date;
	}
	public Date getDataFine() {
		return dataFine;
	}
	
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Date getScadenzaPrenotazione() {
		return scadenzaPrenotazione;
	}
	
	public void setCostoTotale(int costoTotale) {
		this.costoTotale = costoTotale;
	}
	public int getCostoTotale() {
		return costoTotale;
	}
	
	public void setScadenzaPrenotazione(Date scadenzaPrenotazione) {
		this.scadenzaPrenotazione = scadenzaPrenotazione;
	}
	public List<Giorno> getGiorno() {
		return giorni;
	}
	
	public void setGiorno(Giorno giorno) {
		this.giorni.add(giorno);
	}


}
