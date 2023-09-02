package syscom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Produto;
import syscom.controller.ProdutoController;
import syscom.dao.ProdutoDao;

public class Teste {

	public static void main(String[] args) {
		
		var produto = new Produto("Bermuda Masculina Estampada", "Bermuda Masculina",
				50.99, null);

		try {
			var cn = new ConnectionFactory().getConnectionMySql();
			new ProdutoDao(cn).cadastrar(produto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
