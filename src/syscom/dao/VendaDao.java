package syscom.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Venda;

public class VendaDao {
	
	private Connection connection;
	
	public VendaDao(Connection cn) {
		this.connection = cn;
	}
	
	public List<Venda> listarTodos() {
		var vendas = new ArrayList<Venda>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendas;")) {
			st.execute();
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var venda = new Venda(rs.getInt("ID_VENDA"), rs.getInt("ID_CLIENTE"),
						rs.getInt("ID_VENDEDOR"), rs.getDate("DATA_VENDA"),
						rs.getBoolean("STATUS"));
				vendas.add(venda);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendas;
	}
	
	public List<Venda> listarPorStatus(boolean status) {
		var vendas = new ArrayList<Venda>();
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendas "
				+ "WHERE STATUS = ?;")) {
			st.setBoolean(1, status);
			st.execute();
			var rs = st.getResultSet();
			
			while(rs.next()) {
				var venda = new Venda(rs.getInt("ID_VENDA"), rs.getInt("ID_CLIENTE"),
						rs.getInt("ID_VENDEDOR"), rs.getDate("DATA_VENDA"),
						rs.getBoolean("STATUS"));
				vendas.add(venda);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendas;
	}
	
	public Venda buscaPorId(int id) {
		Venda venda = null;
		
		try(var st = this.connection.prepareStatement("SELECT * FROM vendas "
				+ "WHERE ID_VENDA = ?;")) {
			st.setInt(1, id);
			st.execute();
			var rs = st.getResultSet();
			
			while(rs.next()) {
				venda = new Venda(rs.getInt("ID_VENDA"), rs.getInt("ID_CLIENTE"),
						rs.getInt("ID_VENDEDOR"), rs.getDate("DATA_VENDA"),
						rs.getBoolean("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return venda;
	}

}
