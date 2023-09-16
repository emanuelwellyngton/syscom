package syscom.controller;

import java.sql.SQLException;
import java.util.List;

import syscom.ConnectionFactory;
import syscom.dao.VendedorDao;
import syscom.modelos.Vendedor;

public class VendedorController {
	
	private VendedorDao dao;
	
	public VendedorController() {
		try {
			var cn = new ConnectionFactory().getConnectionMySql();
			this.dao = new VendedorDao(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Vendedor> listarTodos(){
		return this.dao.listarTodos();
	}
	
	public List<Vendedor> listarPorStatus(boolean status) {
		return this.dao.listarPorStatus(status);
	}
	
	public Vendedor buscarPorId(int id) {
		return this.dao.buscarPorId(id);
	}
	
	public void cadastrar(Vendedor vendedor) {
		this.dao.cadastrar(vendedor);
	}
	
	public void editar(Vendedor vendedor) {
		this.dao.editar(vendedor);
	}
	
	public void deletar(Vendedor vendedor) {
		this.dao.deletar(vendedor);
	}

}
