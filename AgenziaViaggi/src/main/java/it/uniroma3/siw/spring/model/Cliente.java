package it.uniroma3.siw.spring.model;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cliente extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int numeroDiTelefono;
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
	
	public int getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	
	public void setNumeroDiTelefono(int numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
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
