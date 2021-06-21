package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Itinerario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String destinazione;

	@Column(length=3000)
	private String descrizione;

	@Column
	private String dataInizio;

	@Column
	private String dataFine;

	@Column
	private String scadenzaPrenotazione;

	@Column
	private int costoTotale;

	@OneToMany(mappedBy="itinerario", cascade=CascadeType.REMOVE)
	private List<Giorno> giorno;

	@ManyToOne
	private AgenziaViaggi agenziaViaggi;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Guida guida;

	public Itinerario() {
		this.giorno=new ArrayList<>();
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

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String date) {
		this.dataInizio = date;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getScadenzaPrenotazione() {
		return scadenzaPrenotazione;
	}

	public void setCostoTotale(int costoTotale) {
		this.costoTotale = costoTotale;
	}

	public int getCostoTotale() {
		return costoTotale;
	}

	public void setScadenzaPrenotazione(String scadenzaPrenotazione) {
		this.scadenzaPrenotazione = scadenzaPrenotazione;
	}

	public List<Giorno> getGiorno() {
		return giorno;
	}

	public void setGiorno(Giorno giorno) {
		this.giorno.add(giorno);
	}

	public void setGuida(Guida guida) {
		this.guida=guida;		
	}

	public Guida getGuida() {
		return this.guida;
	}
}
