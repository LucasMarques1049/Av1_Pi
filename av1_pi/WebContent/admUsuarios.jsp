<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.UsuarioBeans"%>
<%@ page import="model.LoginBeans"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="adm.css">
<script type="text/javascript">
	function confirmar(id_use) {
		let resposta = confirm("Confirma a exclusao do usuario ?")
		if (resposta === true) {
			window.location.href = "delete?id_use=" + id_use
		}
	}
</script>


<title>Area administrativa</title>
</head>
<body>

	<div class="container">
		<section class="header">
			<h2>Area ADM</h2>
			<p>
				Bem vindo(a):
				<%
			out.print(request.getAttribute("nome"));
			%>
			</p>
		</section>

		<form name="frmTodosUser" action="main" class="form">



			<table id="tabela">
				<thead>
					<tr>
						<th>ID</th>
						<th>Login</th>
						<th>Senha</th>
						<th>Nome</th>
						<th>Ativo</th>
						<th>Data Nascimento</th>
						<th>Data Cadastro</th>
						<th>opções</th>
					</tr>
				</thead>

				<tbody>


					<tr>
						<td>
							<%
							out.print(request.getAttribute("id_use"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("login"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("senha"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("nome"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("situacao"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("data_nascimento"));
							%>
						</td>
						<td>
							<%
							out.print(request.getAttribute("data_cad"));
							%>
						</td>
						<td><a
							href="select?id_use=<%out.print(request.getAttribute("id_use"));%>"
							class="btnEditar">Editar</a> <a
							href="javascript: confirmar(<%out.print(request.getAttribute("id_use"));%>)"
							class="btnExluir">Excluir</a></td>
					</tr>

				</tbody>
			</table>

		</form>

	</div>

</body>
</html>