package syscom.controller;

import java.sql.SQLException;
import java.util.List;

import syscom.ConnectionFactory;
import syscom.dao.ClienteDao;
import syscom.modelos.Cliente;

public class ClienteController {
	
	private ClienteDao dao;
	
	public ClienteController() {
		try {
			var cn = new ConnectionFactory().getConnectionMySql();
			this.dao = new ClienteDao(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cliente> listarTodos() {
		return this.dao.listarTodos();
	}
	
	public List<Cliente> listarPorStatus(boolean status) {
		return this.dao.listarPorStatus(status);
	}
	
	public Cliente buscarPorId(int id) {
		return this.dao.buscarPorId(id);
	}
	
	public void cadastrar(Cliente cliente) {
		this.dao.cadastrar(cliente);
	}
	
	public void editar(Cliente cliente) {
		this.dao.editar(cliente);
	}
	
	public void deletar(Cliente cliente) {
		this.dao.deletar(cliente);
	}

}
