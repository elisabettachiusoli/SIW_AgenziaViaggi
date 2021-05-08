package it.uniroma3.siw.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.sun.javafx.collections.MappingChange.Map;

public class ClienteValidator {


	public boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String numTel = request.getParameter("numTel");
		String email = request.getParameter("email");
		String citta = request.getParameter("citta");
		String dataInizio = request.getParameter("dataInizio");
		String dataFine = request.getParameter("dataFine");

		if(!nome.equals("") && !cognome.equals("") && !numTel.equals("") && !email.equals("") && !citta.equals("") && !dataInizio.equals("") && !dataFine.equals("")) {

			return true;

		}else {
			return false;
		}
	}
}
