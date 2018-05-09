package br.com.caelum.jdbc.dao;


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
	
	public ContatoDAO() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adciona(Contato contato){
		String sql = "insert into contatos "+
				"(nome, email, endereco, dataNascimento)" +
				"values(?,?,?,?)";
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista(){
		
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from contatos");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
				
			}
			rs.close();
			stmt.close();
			return contatos;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public Contato findById(Long Id) throws SQLException
	{
		Contato contato = new Contato();
		
		PreparedStatement stmt = this.connection.prepareStatement("Select * from contatos where id =?");
		stmt.setLong(1, Id);
		
		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		
		stmt.close();
		rs.close();
		
		return contato;
	}

	public void update(Contato contato) throws SQLException
	{
		PreparedStatement stmt = this.connection.prepareStatement("update contatos set nome=?, email=?, endereco=?, "
	+"dataNascimento=? where id=?");
		stmt.setString(1,contato.getNome());
		stmt.setString(2,contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());
		
		stmt.execute();
		stmt.close();
	}

	public void remove(Contato contato)
	{
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

	
	
