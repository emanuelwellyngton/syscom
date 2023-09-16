package syscom.modelos;

import java.sql.Date;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private boolean status;
	
	public Cliente(int id, String nome, String cpf, String email, String telefone, Date dataNascimento, String endereco,
			String bairro, String cidade, String estado, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

	public Cliente(String nome, String cpf, String email, String telefone, Date dataNascimento, String endereco,
			String bairro, String cidade, String estado, boolean status) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}
	
	public Cliente(String nome, String cpf, String email, String telefone, Date dataNascimento, String endereco,
			String bairro, String cidade, String estado) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Cliente() {
	}
	
	public Cliente(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", status=" + status + "]";
	}
}
