package syscom.controller;

import java.sql.SQLException;
import java.util.List;

import syscom.ConnectionFactory;
import syscom.dao.VendaDao;
import syscom.modelos.Venda;

public class VendaController {
	
	private VendaDao dao;
	
	public VendaController() {
		try {
			var cn = new ConnectionFactory().getConnectionMySql();
			this.dao = new VendaDao(cn);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Venda> listarTodos() {
		return this.dao.listarTodos();
	}
	
	public List<Venda> listarPorStatus(boolean status) {
		return this.dao.listarPorStatus(status);
	}

}
