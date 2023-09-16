package syscom.modelos;

import java.sql.Date;

import syscom.controller.ClienteController;
import syscom.controller.VendedorController;

public class Venda {
	
	private int id;
	private Cliente cliente;
	private Vendedor vendedor;
	private Date dataVenda;
	private boolean status;
	
	public Venda(int id, Cliente cliente, Vendedor vendedor, Date dataVenda, boolean status) {
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataVenda = dataVenda;
		this.status = status;
	}

	public Venda(Cliente cliente, Vendedor vendedor, Date dataVenda, boolean status) {
		super();
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataVenda = dataVenda;
		this.status = status;
	}
	
	public Venda() {
	}
	
	public Venda(int id, int cliente, int vendedor, Date dataVenda, boolean status) {
		this.id = id;
		this.cliente = new ClienteController().buscarPorId(cliente);
		this.vendedor = new VendedorController().buscarPorId(vendedor);
		this.dataVenda = dataVenda;
		this.status = status;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", vendedor=" + vendedor + ", dataVenda=" + dataVenda
				+ ", status=" + status + "]";
	}

}
