package syscom.modelos;

public class Produto {
	
	private int id;
	private String descritor;
	private String categoria;
	private double preco;
	private String imagem;
	
	public Produto(int id, String descritor, String categoria, double preco, String imagem) {
		this.id = id;
		this.descritor = descritor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
	}
	
	public Produto(String descritor, String categoria, double preco, String imagem) {
		this.descritor = descritor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
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

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descritor=" + descritor + ", categoria=" + categoria + ", imagem=" + imagem
				+ "]";
	}

}
