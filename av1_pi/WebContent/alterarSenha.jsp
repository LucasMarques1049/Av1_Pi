<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="adm.css">
<title>Alterar Senha</title>
</head>
<body>
	<div class="container">
		<section class="header">
			<h2>Editar Senha</h2>
		</section>

		<form name="frmEditarUser" action="alterarSenha" class="form">
			
			<div class="form-content">
				<label>Login do usuário</label> <input type="text" name="login" readonly
					value="<%out.print(request.getAttribute("login"));%>" />
			</div>

			<div class="form-content">
				<label for="password">Senha</label> <input type="password"
					name="senha" value="<%out.print(request.getAttribute("senha"));%>" />

			</div>

			<button type="submit">Editar</button>

		</form>

	</div>
</body>
</html>