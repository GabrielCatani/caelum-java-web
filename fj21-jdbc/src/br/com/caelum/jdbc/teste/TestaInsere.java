package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.DAO.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("Jonas");
		contato.setEmail("gabriel@algumacoisa.com");
		contato.setEndereco("Av. Chegou!");
		
		Calendar data = Calendar.getInstance();
		data.set(1989, 00, 25);
		contato.setDataNascimento(data);
		
		ContatoDAO dao = new ContatoDAO();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado!");

	}

}
