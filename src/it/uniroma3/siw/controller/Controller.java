package it.uniroma3.siw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.siw.model.Cliente;


@WebServlet("/controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID=1L;
	private Cliente cliente;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri e li salvo in varibili locali
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String numTel = request.getParameter("numTel");
		String email = request.getParameter("email");
		String citta = request.getParameter("citta");
		String dataInizio = request.getParameter("dataInizio");
		String dataFine = request.getParameter("dataFine");
		String nextPage = null;
		String comando;
		comando=request.getParameter("submit");
		ClienteValidator validator=new ClienteValidator();
		HttpSession session=request.getSession();
		if(comando.equals("Prenota consulenza")) {
			if(validator.validate(request)) {

				cliente=new Cliente(nome, cognome, numTel, email, citta, dataInizio, dataFine);
				session.setAttribute("cliente", cliente);
				nextPage="/datiDaInserire.jps";
			}else {
				nextPage="/home.jps";
			}
		}	
		// gestione dell'inoltro
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 

	}
}