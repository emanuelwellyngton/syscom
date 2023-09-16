package syscom;

import syscom.controller.VendaController;

public class Teste {

	public static void main(String[] args) {
		
		var vendas = new VendaController().listarPorStatus(true);
		System.out.println(vendas);
		
	}

}
