package syscom.controller;

import java.sql.SQLException;
import java.util.List;

import syscom.ConnectionFactory;
import syscom.dao.ProdutoDao;
import syscom.modelos.Produto;

public class ProdutoController {
	
	private ProdutoDao produtoDao;
	
	public ProdutoController() {
		try {
			var connection = new ConnectionFactory().getConnectionMySql();
			this.produtoDao = new ProdutoDao(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarTodos() {
		return this.produtoDao.listarTodos();
	}
	
	public List<Produto> listarPorStatus(boolean status) {
		return this.produtoDao.listarPorStatus(status);
	}
	
	public void cadastrar(Produto produto) {
		this.produtoDao.cadastrar(produto);
	}
	
	public Produto buscarPorId(int id) {
		return this.produtoDao.buscarPorId(id);
	}
	
	public void editar(Produto produto) {
		this.produtoDao.editar(produto);
	}
	
	public void deletar(Produto produto) {
		this.produtoDao.deletar(produto);
	}

}
