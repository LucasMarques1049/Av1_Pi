<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String erro_senha = (String) request.getAttribute("erro_senha");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Recuperaçao de senha</title>
</head>
<body>

	<div class="container">
		<div class="card">
			<section class="header">
				<h2>Recuperar Senha</h2>
			</section>
			<form name="frmLogar" action="recuperarSenha">
				<input type="text" id="username" name="usuario"
					placeholder="Usuario" required> 
				<input type="date"
					 name="data_nascimento" required>

				<button type="submit"">Logar</button>

				<a href="index.html">Voltar</a>
				<p>
					<%
					if (erro_senha != null) {
						out.print(erro_senha);
					}
					%>
				</p>
			</form>

		</div>
	</div>
		
	
</body>
</html>