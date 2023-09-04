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
						rs.getString("CATEGORIA"), rs.getDouble("PRECO"), rs.getString("IMAGEM"),
						rs.getBoolean("STATUS"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public List<Produto> listarPorStatus(boolean status) {
		ArrayList<Produto> produtos = new ArrayList();
		
		try (var st = this.connection.prepareStatement("SELECT * FROM produtos "
				+ "WHERE STATUS = ?;")) {
			st.setBoolean(1, status);
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("ID_PRODUTO"), rs.getString("DESCRITOR"),
						rs.getString("CATEGORIA"), rs.getDouble("PRECO"), rs.getString("IMAGEM"),
						rs.getBoolean("STATUS"));
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
				+ "CATEGORIA, PRECO, IMAGEM, STATUS) VALUES(?, ?, ?, ?, ?);")) {
			st.setString(1, produto.getDescritor());
			st.setString(2, produto.getCategoria());
			st.setDouble(3, produto.getPreco());
			st.setString(4, produto.getImagem());
			st.setBoolean(5, produto.getStatus());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Produto buscarPorId(int id) {
		Produto produto = null;
		try (var st = this.connection.prepareStatement("SELECT * FROM produtos "
				+ "WHERE ID_PRODUTO = ?;")) {
			st.setInt(1, id);
			st.execute();
			ResultSet rs = st.getResultSet();
			
			if(rs.next()) {
				produto = new Produto(rs.getInt("ID_PRODUTO"), rs.getString("DESCRITOR"),
						rs.getString("CATEGORIA"), rs.getDouble("PRECO"), rs.getString("IMAGEM"),
						rs.getBoolean("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produto;
	}
	
	public void editar(Produto produto) {
		try(var st = this.connection.prepareStatement("UPDATE produtos SET DESCRITOR = ?, "
				+ "CATEGORIA = ?, PRECO = ?, IMAGEM = ?, STATUS = ? WHERE ID_PRODUTO = ?;")) {
			st.setString(1, produto.getDescritor());
			st.setString(2, produto.getCategoria());
			st.setDouble(3, produto.getPreco());
			st.setString(4, produto.getImagem());
			st.setBoolean(5, produto.getStatus());
			st.setInt(6, produto.getId());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar(Produto produto) {
		try(var st = this.connection.prepareStatement("DELETE FROM produtos WHERE ID_PRODUTO = ?;")) {
			st.setInt(1, produto.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
