package model;

public class LoginBeans {
	private String nome;
	private String senha;
	private String dataNascimento;
	
	public LoginBeans(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	
	public LoginBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
