package br.com.caelum.mvc.logica;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
//Setar atributos para passar para JSP!
public class MostraContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		Contato contato = new Contato();
		String idString =  req.getParameter("id");
		Long id = Long.parseLong(idString);
		
		ContatoDao dao = new ContatoDao();
		try {
			contato = dao.getContato(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("contato", contato);
		return "altera-contato.jsp";
	}

}
