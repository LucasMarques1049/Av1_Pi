package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.LoginBeans;
import model.UsuarioBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/logar", "/update", "/delete", "/recuperarSenha","/alterarSenha", "/dadosSenha"}) 
// trata as requisicoes
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	UsuarioBeans usuario = new UsuarioBeans();
	LoginBeans logarUsuario = new LoginBeans();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			DadosUsuarioTelaAdm(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/select")) {
			DadosEditarUsuario(request, response);
		} else if (action.equals("/logar")) {
			loginUsuario(request, response);
		} else if (action.equals("/update")) {
			editarUsuario(request, response);
		} else if (action.equals("/delete")) {
			deletarUsuario(request, response);
		} else if (action.equals("/recuperarSenha")) {
			novaSenha(request, response);
		} else if (action.equals("/dadosSenha")) {
			DadosUsuarioTelaSenha(request, response);
		}else if (action.equals("/alterarSenha")) {
			alterarSenha(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void alterarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		usuario.setSenha(senha);
		logarUsuario.setNome(login);
	
		dao.alteraSenha(usuario, logarUsuario);
		response.sendRedirect("login.jsp");
		
	}
	protected void novaSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logarUsuario.setNome(request.getParameter("usuario"));
		logarUsuario.setDataNascimento(request.getParameter("data_nascimento"));
		if (dao.recuperarSenha(logarUsuario)) {
			response.sendRedirect("dadosSenha");
			
		} else {
			request.setAttribute("erro_senha", "Dados invalidos");
			RequestDispatcher rd = request.getRequestDispatcher("recuperaSenha.jsp");
			rd.forward(request, response);
		}

	}

	
	
	
	// login
	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logarUsuario.setNome(request.getParameter("usuario"));
		logarUsuario.setSenha(request.getParameter("senha"));
		if (dao.loginUser(logarUsuario)) {
			response.sendRedirect("main");
			// System.out.println("logado");
		} else {
			request.setAttribute("erro", "Usuario ou senha invalido");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

	protected void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_use = request.getParameter("id_use");
		usuario.setId_use(id_use);
		dao.removerUsuario(usuario);
		response.sendRedirect("login.jsp");
	}
	protected void DadosUsuarioTelaAdm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		// seter a variavel
		usuario.setId_use(login);
		
		dao.dadosUsuario(usuario, logarUsuario);
		request.setAttribute("id_use", usuario.getId_use());
		request.setAttribute("login", usuario.getLogin());
		request.setAttribute("senha", usuario.getSenha());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("situacao", usuario.getAtivo());
		request.setAttribute("data_nascimento", usuario.getDataNascimento());
		request.setAttribute("data_cad", usuario.getDataCadastro());
		RequestDispatcher rd = request.getRequestDispatcher("admUsuarios.jsp");
		rd.forward(request, response);
	}
	
	protected void DadosUsuarioTelaSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		System.out.println(login);
		// seter a variavel
		usuario.setId_use(login);
		
		dao.dadosUsuarioSenha(usuario, logarUsuario);
		
		request.setAttribute("id_use", usuario.getId_use());
		request.setAttribute("login", usuario.getLogin());
		request.setAttribute("senha", usuario.getSenha());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("situacao", usuario.getAtivo());
		request.setAttribute("data_nascimento", usuario.getDataNascimento());
		request.setAttribute("data_cad", usuario.getDataCadastro());

		RequestDispatcher rd = request.getRequestDispatcher("alterarSenha.jsp");
		rd.forward(request, response);
	}
	
	
	
	
	protected void DadosEditarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_use = request.getParameter("id_use");
		// seter a variavel
		usuario.setId_use(id_use);
		dao.selecionarUsuario(usuario);

		request.setAttribute("id_use", usuario.getId_use());
		request.setAttribute("login", usuario.getLogin());
		request.setAttribute("senha", usuario.getSenha());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("situacao", usuario.getAtivo());
		request.setAttribute("data_nascimento", usuario.getDataNascimento());
		request.setAttribute("data_cad", usuario.getDataCadastro());
		RequestDispatcher rd = request.getRequestDispatcher("editarUsuario.jsp");
		rd.forward(request, response);
	}

	protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setId_use(request.getParameter("id_use"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setAtivo(request.getParameter("situacao"));

		dao.alteraDadosUsuario(usuario);

		response.sendRedirect("main");
	}

	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis UsuraioBeans
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setAtivo(request.getParameter("situacao"));
		usuario.setDataNascimento(request.getParameter("data_nascimento"));

		// metodo inserirUsuario
		dao.inserirUsuario(usuario);

		response.sendRedirect("login.jsp");
	}

}
