package it.uniroma3.siw.spring.model;



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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String cognome;
	
	@Getter
	@Setter
	private String numeroDiTelefono;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String cittaDaVisitare;
	
	@Getter
	@Setter
	private String dataInizio;
	
	@Getter
	@Setter
	private String dataFine;
	
	@ManyToOne
	private AgenziaViaggi agenziaViaggi;
	
	public Cliente(String nome, String cognome, String numeroDiTelefono, String email, String cittaDaVisitare, String dataInizio, String dataFine)
	{
		this.nome=nome;
		this.cognome=cognome;
		this.cittaDaVisitare=cittaDaVisitare;
		this.numeroDiTelefono=numeroDiTelefono;
		this.email=email;
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;
	}
}
