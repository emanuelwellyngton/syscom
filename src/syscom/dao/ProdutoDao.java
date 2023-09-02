package syscom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Produto;

public class ProdutoDao {

	private Connection connection;
	
	public ProdutoDao(Connection cn) {
		this.connection = cn;
	}
	
	public List<Produto> listarTodos() {
		ArrayList<Produto> produtos = new ArrayList();
		
		try (var st = this.connection.prepareStatement("SELECT * FROM produtos;")) {
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("ID_PRODUTO"), rs.getString("DESCRITOR"),
						rs.getString("CATEGORIA"), rs.getDouble("PRECO"), rs.getString("IMAGEM"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public void cadastrar(Produto produto) {
		try(var st = this.connection.prepareStatement("INSERT INTO produtos(DESCRITOR,"
				+ "CATEGORIA, PRECO, IMAGEM) VALUES(?, ?, ?, ?);")) {
			st.setString(1, produto.getDescritor());
			st.setString(2, produto.getCategoria());
			st.setDouble(3, produto.getPreco());
			st.setString(4, produto.getImagem());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
