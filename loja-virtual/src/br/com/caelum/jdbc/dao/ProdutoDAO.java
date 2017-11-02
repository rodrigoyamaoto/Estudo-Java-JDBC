package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Produto;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Produto produto) throws SQLException{
		String sql = "insert into Produto (nome, descricao) values(?, ?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, produto.getName());
			statement.setString(2,produto.getDescricao());
			statement.execute();
		}
	}
	
	public List<Produto> findAll() throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "select * from Produto";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			
			try(ResultSet rs = statement.getResultSet()){
				while(rs.next()) {
					Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}
