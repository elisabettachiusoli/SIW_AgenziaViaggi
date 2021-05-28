package it.uniroma3.siw.spring.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private int numeroDiTelefono;
	private String email;
	private String cittaDaVisitare;
	private Date dataInizio;
	private Date dataFine;
	
	@ManyToOne
	private AgenziaViaggi agenziaViaggi;
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
	
	public String getCittaDaVisitare() {
		return cittaDaVisitare;
	}
	
	public void setCittaDaVisitare(String cittaDaVisitare) {
		this.cittaDaVisitare = cittaDaVisitare;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
