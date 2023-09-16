package syscom.modelos;

import java.sql.Date;

public class Vendedor {
	
	private int id;
	private String nome;
	private Date data_nascimento;
	private String email;
	private String cpf;
	private boolean status;
	
	public Vendedor(int id, String nome, Date data_nascimento, String email,
			String cpf, boolean status) {
		this.id = id;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.cpf = cpf;
		this.status = status;
	}

	public Vendedor(String nome, Date data_nascimento, String email, String cpf,
			boolean status) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.cpf = cpf;
		this.status = status;
	}
	
	public Vendedor(String nome, Date data_nascimento, String email, String cpf) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.cpf = cpf;
	}

	public Vendedor() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "Vendedor [id=" + id + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", email=" + email
				+ ", cpf=" + cpf + ", status=" + status + "]";
	}

}
