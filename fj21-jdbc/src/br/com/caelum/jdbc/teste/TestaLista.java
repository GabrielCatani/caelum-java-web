package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.DAO.ContatoDAO;
import br.com.caelum.jdbc.DAO.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) throws DAOException, SQLException {
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos)
		{
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEmail());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data de Nascimento: " + sdf.format(contato.getDataNascimento().getTime()) + "\n");
		}
		
		ContatoDAO dao1 = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato = dao1.getContato("Jonas");
		
		System.out.println(contato.getNome() + contato.getId());

	}

}
