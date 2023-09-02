package syscom.controller;

import java.sql.SQLException;
import java.util.List;

import syscom.ConnectionFactory;
import syscom.dao.ProdutoDao;
import syscom.modelos.Produto;

public class ProdutoController {
	
	private ProdutoDao produtoDao;
	
	public ProdutoController() {
		try(var connection = new ConnectionFactory().getConnectionMySql()) {
			this.produtoDao = new ProdutoDao(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarTodos() {
		return this.produtoDao.listarTodos();
	}

}
