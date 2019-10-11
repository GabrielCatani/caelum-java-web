package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogica implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res){
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		req.setAttribute("lista", contatos);
		
		
		return "lista-contatos.jsp";
	}
}
