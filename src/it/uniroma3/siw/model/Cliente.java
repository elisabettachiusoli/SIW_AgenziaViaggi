package it.uniroma3.siw.model;

import java.time.LocalDate;

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
	private int numeroDiTelefono;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String citt‡DaVisitare;
	
	@Getter
	@Setter
	private LocalDate periodoDaVisitare;
	
	@ManyToOne
	private AgenziaViaggi agenziaViaggi;

}
