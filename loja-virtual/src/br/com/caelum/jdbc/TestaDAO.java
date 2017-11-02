package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ProdutoDAO;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaDAO {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection connection = new ConnectionPool().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			//Insert
			Produto som = new Produto("Som", "Caixas de som de alta potencia");
			produtoDAO.insert(som);
			
			//Lista todos
			List<Produto> produtos = new ArrayList<>();
			produtos = produtoDAO.findAll();
			
			for(Produto produto : produtos) {
				System.out.println(produto.toString());
			}
		}

	}

}
