package syscom.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Cliente;

public class ClienteDao {

	private Connection connection;
	
	public ClienteDao(Connection cn) {
		this.connection = cn;
	}
	
	public List<Cliente> listarTodos() {
		var clientes = new ArrayList<Cliente>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM clientes;")) {
			st.execute();
			
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var cliente = new Cliente(rs.getInt("ID_CLIENTE"), rs.getString("NOME"),
						rs.getString("CPF"), rs.getString("EMAIL"),
						rs.getString("TELEFONE"), rs.getDate("DATA_NASCIMENTO"),
						rs.getString("ENDERECO"), rs.getString("BAIRRO"),
						rs.getString("CIDADE"), rs.getString("ESTADO"), rs.getBoolean("status"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public List<Cliente> listarPorStatus(boolean status) {
		var clientes = new ArrayList<Cliente>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM clientes "
				+ "WHERE STATUS=?;")) {
			st.setBoolean(1, status);
			st.execute();
			
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var cliente = new Cliente(rs.getInt("ID_CLIENTE"), rs.getString("NOME"),
						rs.getString("CPF"), rs.getString("EMAIL"),
						rs.getString("TELEFONE"), rs.getDate("DATA_NASCIMENTO"),
						rs.getString("ENDERECO"), rs.getString("BAIRRO"),
						rs.getString("CIDADE"), rs.getString("ESTADO"), rs.getBoolean("status"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public Cliente buscarPorId(int id) {
		Cliente cliente = null;
		
		try(var st = this.connection.prepareStatement("SELECT * FROM clientes "
				+ "WHERE ID_CLIENTE=?;")) {
			st.setInt(1, id);
			st.execute();
			
			var rs = st.getResultSet();
			
			while(rs.next()) {
				cliente = new Cliente(rs.getInt("ID_CLIENTE"), rs.getString("NOME"),
						rs.getString("CPF"), rs.getString("EMAIL"),
						rs.getString("TELEFONE"), rs.getDate("DATA_NASCIMENTO"),
						rs.getString("ENDERECO"), rs.getString("BAIRRO"),
						rs.getString("CIDADE"), rs.getString("ESTADO"), rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void cadastrar(Cliente cliente) {
		try(var st = this.connection.prepareStatement("INSERT INTO clientes "
				+ "(NOME, CPF, EMAIL, TELEFONE, DATA_NASCIMENTO, ENDERECO, BAIRRO, "
				+ "CIDADE, ESTADO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getCpf());
			st.setString(3, cliente.getEmail());
			st.setString(4, cliente.getTelefone());
			st.setDate(5, cliente.getDataNascimento());
			st.setString(6, cliente.getEndereco());
			st.setString(7, cliente.getBairro());
			st.setString(8, cliente.getCidade());
			st.setString(9, cliente.getEstado());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Cliente cliente) {
		try(var st = this.connection.prepareStatement("UPDATE clientes "
				+ "SET NOME = ?, EMAIL = ?, TELEFONE = ?, DATA_NASCIMENTO = ?, "
				+ "ENDERECO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? WHERE ID_CLIENTE = ?;")) {
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getEmail());
			st.setString(3, cliente.getTelefone());
			st.setDate(4, cliente.getDataNascimento());
			st.setString(5, cliente.getEndereco());
			st.setString(6, cliente.getBairro());
			st.setString(7, cliente.getCidade());
			st.setString(8, cliente.getEstado());
			st.setInt(9, cliente.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar(Cliente cliente) {
		try(var st = this.connection.prepareStatement("DELETE FROM clientes "
				+ "WHERE ID_CLIENTE = ?;")) {
			st.setInt(1, cliente.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
