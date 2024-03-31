package model;

import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DAO {
	// conex�o mysql
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/av1_pi?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "toto1049";

	// metodo conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);// ler o driver
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// insert no banco
	public void inserirUsuario(UsuarioBeans novoUsuario) {
		String create = "insert into usuario ( login,senha,nome,ativo,dataNascimento) values (?,?,?,?,?)";
		try {
			// abri conexao
			Connection con = conectar();
			// query de execução no banco
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametro (?) pelas as variaveis UsuarioBeans
			pst.setString(1, novoUsuario.getLogin());
			pst.setString(2, novoUsuario.getSenha());
			pst.setString(3, novoUsuario.getNome());
			pst.setString(4, novoUsuario.getAtivo());
			pst.setString(5, novoUsuario.getDataNascimento());
			// executer a query
			pst.executeUpdate();
			// encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void dadosUsuario(UsuarioBeans dadoUsuario, LoginBeans loginUser) {
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement( "select * from usuario where login =?");
			pst.setString(1, loginUser.getNome());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				dadoUsuario.setId_use(rs.getString(1));
				dadoUsuario.setLogin(rs.getString(2));
				dadoUsuario.setSenha(rs.getString(3));
				dadoUsuario.setNome(rs.getString(4));
				dadoUsuario.setAtivo(rs.getString(5));
				dadoUsuario.setDataNascimento(rs.getString(6));
				dadoUsuario.setDataCadastro(rs.getString(7));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	public void selecionarUsuario(UsuarioBeans usuario) {
		String read2 = "select * from usuario where id_use =?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, usuario.getId_use());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				usuario.setId_use(rs.getString(1));
				usuario.setLogin(rs.getString(2));
				usuario.setSenha(rs.getString(3));
				usuario.setNome(rs.getString(4));
				usuario.setAtivo(rs.getString(5));
				usuario.setDataNascimento(rs.getString(6));
				usuario.setDataCadastro(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alteraDadosUsuario(UsuarioBeans usuario) {
		String create = "update usuario set login=?, senha=?, nome=?, ativo=? where id_use=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			pst.setString(4, usuario.getAtivo());
			
			pst.setString(5, usuario.getId_use());	
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public boolean loginUser(LoginBeans logarUsuario) { 
			boolean loginSucesso = false;
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement("select * from usuario where login = ? and senha = ?");
			pst.setString(1, logarUsuario.getNome());
			pst.setString(2, logarUsuario.getSenha());
			
			ResultSet rs = pst.executeQuery();
			loginSucesso = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginSucesso;
	}
	
	public boolean recuperarSenha(LoginBeans novaSenha) { 
		boolean recupecao = false;
	try {

		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement("select * from usuario where login = ? and dataNascimento = ?");
		pst.setString(1, novaSenha.getNome());
		pst.setString(2, novaSenha.getDataNascimento());
		
		ResultSet rs = pst.executeQuery();
		recupecao = rs.next();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return recupecao;
}
	
	
	public void alteraSenha(UsuarioBeans usuario, LoginBeans login) {
		String create = "update usuario set senha=? where login=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, usuario.getSenha());
			pst.setString(2, login.getNome());	
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void dadosUsuarioSenha(UsuarioBeans dadoUsuario, LoginBeans loginUser) {
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement( "select * from usuario where login =?");
			pst.setString(1, loginUser.getNome());
			System.out.println(loginUser.getNome());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				dadoUsuario.setId_use(rs.getString(1));
				dadoUsuario.setLogin(rs.getString(2));
				dadoUsuario.setSenha(rs.getString(3));
				dadoUsuario.setNome(rs.getString(4));
				dadoUsuario.setAtivo(rs.getString(5));
				dadoUsuario.setDataNascimento(rs.getString(6));
				dadoUsuario.setDataCadastro(rs.getString(7));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	
	public void removerUsuario(UsuarioBeans usuario) {
		String delete = "delete from usuario where id_use=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, usuario.getId_use());
			pst.executeUpdate();//executar o comando no banco de daados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
