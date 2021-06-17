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
public class Guida {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;

	private String cognome;
	
	private int numeroDiTelefono;

	private String email;
	
	private int matricola;
	
	@OneToMany(mappedBy="guida")
	private List<Itinerario> itinerari;
	
	public Guida() {
		this.itinerari=new ArrayList<>();
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(int numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	public void setItinerari(Itinerario itinerario1) {
		this.itinerari.add(itinerario1);
	}

}
