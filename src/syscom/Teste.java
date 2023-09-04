package syscom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import syscom.modelos.Produto;
import syscom.controller.ProdutoController;
import syscom.dao.ProdutoDao;

public class Teste {

	public static void main(String[] args) {

		var controller = new ProdutoController();
		var produtos = controller.listarTodos();
		System.out.println(produtos);
		
	}

}
