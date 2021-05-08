package it.uniroma3.siw.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

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
	private String citt‡DaVisitare;
	
	@Getter
	@Setter
	private String dataInizio;
	
	@Getter
	@Setter
	private String dataFine;
	
	@ManyToOne
	private AgenziaViaggi agenziaViaggi;
	
	public Cliente(String nome, String cognome, String numeroDiTelefono, String email, String citt‡DaVisitare, String dataInizio, String dataFine)
	{
		this.nome=nome;
		this.cognome=cognome;
		this.citt‡DaVisitare=citt‡DaVisitare;
		this.numeroDiTelefono=numeroDiTelefono;
		this.email=email;
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;
	}
}
