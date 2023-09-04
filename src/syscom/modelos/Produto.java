package syscom.modelos;

public class Produto {
	
	private int id;
	private String descritor;
	private String categoria;
	private double preco;
	private String imagem;
	private boolean status;
	
	public Produto(int id, String descritor, String categoria, double preco,
			String imagem, boolean status) {
		this.id = id;
		this.descritor = descritor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
		this.status = status;
	}
	
	public Produto(String descritor, String categoria, double preco, String imagem,
			boolean status) {
		this.descritor = descritor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
		this.status = status;
	}
	
	public String getDescritor() {
		return descritor;
	}
	
	public void setDescritor(String descritor) {
		this.descritor = descritor;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descritor=" + descritor + ", categoria=" + categoria + "preco=" + preco +", imagem=" + imagem
				+ ", status=" + status + "]";
	}

}
