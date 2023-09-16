package syscom.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Vendedor;

public class VendedorDao {
	
	private Connection connection;
	
	public VendedorDao(Connection cn) {
		this.connection = cn;
	}
	
	public List<Vendedor> listarTodos() {
		var vendedores = new ArrayList<Vendedor>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendedores;")) {
			st.execute();
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var vendedor = new Vendedor(rs.getInt("ID_VENDEDOR"), rs.getString("NOME"),
						rs.getDate("DATA_NASCIMENTO"), rs.getString("EMAIL"),
						rs.getString("CPF"), rs.getBoolean("STATUS"));
				vendedores.add(vendedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendedores;
	}
	
	public List<Vendedor> listarPorStatus(boolean status) {
		var vendedores = new ArrayList<Vendedor>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendedores "
				+ "WHERE STATUS = ?;")) {
			st.setBoolean(1, status);
			st.execute();
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var vendedor = new Vendedor(rs.getInt("ID_VENDEDOR"), rs.getString("NOME"),
						rs.getDate("DATA_NASCIMENTO"), rs.getString("EMAIL"),
						rs.getString("CPF"), rs.getBoolean("STATUS"));
				vendedores.add(vendedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendedores;
	}
	
	public Vendedor buscarPorId(int id) {
		Vendedor vendedor = null;
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendedores "
				+ "WHERE ID_VENDEDOR = ?;")) {
			st.setInt(1, id);
			st.execute();
			
			var rs = st.getResultSet();
			
			while(rs.next()) {
				vendedor = new Vendedor(rs.getInt("ID_VENDEDOR"), rs.getString("NOME"),
						rs.getDate("DATA_NASCIMENTO"), rs.getString("EMAIL"),
						rs.getString("CPF"), rs.getBoolean("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendedor;
	}
	
	public void cadastrar(Vendedor vendedor) {
		try(var st = this.connection.prepareStatement("INSERT INTO vendedores (NOME, "
				+ "DATA_NASCIMENTO, EMAIL, CPF) VALUES(?, ?, ?, ?);")) {
			st.setString(1, vendedor.getNome());
			st.setDate(2, vendedor.getData_nascimento());
			st.setString(3, vendedor.getEmail());
			st.setString(4, vendedor.getCpf());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Vendedor vendedor) {
		try(var st = this.connection.prepareStatement("UPDATE vendedores SET NOME = ?, "
				+ "DATA_NASCIMENTO = ?, EMAIL = ?, STATUS = ? WHERE ID_VENDEDOR = ?;")) {
			st.setString(1, vendedor.getNome());
			st.setDate(2, vendedor.getData_nascimento());
			st.setString(3, vendedor.getEmail());
			st.setBoolean(4, vendedor.getStatus());
			st.setInt(5, vendedor.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar(Vendedor vendedor) {
		try(var st = this.connection.prepareStatement("DELETE FROM vendedores "
				+ "WHERE ID_VENDEDOR = ?")) {
			st.setInt(1, vendedor.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
