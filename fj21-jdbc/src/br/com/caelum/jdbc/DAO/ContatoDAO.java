package br.com.caelum.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	
	private Connection connection;
	
	public ContatoDAO() throws DAOException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos" +
					"(nome, email, endereco, dataNascimento)" + 
				 " values(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
	
		
		stmt.execute();
		stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contato> getLista() throws DAOException{
		String sql = "select * from contatos";
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		

		
		while(rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			
			Calendar dataCalendar = Calendar.getInstance();
			dataCalendar.setTime(rs.getDate("dataNascimento"));
			
			contato.setDataNascimento(dataCalendar);
			
			contatos.add(contato);
			
		
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return contatos;

	}
	

	public Contato getContato(String nome) throws DAOException, SQLException {
		String sql = "select * from contatos where nome like ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nome);

		ResultSet rs = ps.executeQuery();

		Contato contato = new Contato();
		rs.first();
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setId(rs.getLong("id"));
		contato.setEndereco(rs.getString("endereco"));
		
		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.setTime(rs.getDate("dataNascimento"));
		
		contato.setDataNascimento(dataCalendar);
		
		return contato;
		
	}
}