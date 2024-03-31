package model;

public class UsuarioBeans {
	private String id_use;
	private String login;
	private String nome;
	private String senha;
	private String ativo;
	private String dataNascimento;
	private String dataCadastro;
	
	
	public UsuarioBeans() {
		super();
	}




	public UsuarioBeans(String id_use, String login, String nome, String senha, String ativo, String dataNascimento,
			String dataCadastro) {
		super();
		this.id_use = id_use;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.ativo = ativo;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}



	public String getId_use() {
		return id_use;
	}


	public void setId_use(String id_use) {
		this.id_use = id_use;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
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


	public String getAtivo() {
		return ativo;
	}


	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	

}
	

	