<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="adm.css">
<title>Dados do usuario</title>
</head>
<body>


	<div class="container">
		<section class="header">
			<h2>Editar Dados</h2>
		</section>

	<form  name="frmEditarUser" action="update" class="form">
			<div class="form-content">
				<label >ID do usuário</label> <input type="text"
					name="id_use" readonly
					value="<%out.print(request.getAttribute("id_use"));%>"/>
			</div>
			
			<div class="form-content">
				<label>Login do usuário</label> <input type="text"
					name="login"
					value="<%out.print(request.getAttribute("login"));%>" />
			</div>

			<div class="form-content">
				<label for="password">Senha</label> <input type="password"
					name="senha" 
					value="<%out.print(request.getAttribute("senha"));%>"/>

			</div>
			
			<div class="form-content">
				<label for="nome">Nome</label> <input type="text" name="nome"
				value="<%out.print(request.getAttribute("nome"));%>"/>
			</div>
			
			<div class="form-content">
				
				<label for="nome">Ativa conta </label>
				<select name="situacao">
					<option>sim</option>
					<option>nao</option>
				</select>
			</div>
			
			<div class="form-content">
				<label for="nome">Data nascimento</label> <input type="text" name="data_nascimento"
				readonly
				value="<%out.print(request.getAttribute("data_nascimento"));%>"/>
			</div>
			
			<div class="form-content">
				<label for="nome">Data Cadastro</label><input type="text" name="data_cad"
				readonly
				value="<%out.print(request.getAttribute("data_cad"));%>"/>
			</div>
			
			<button type="submit">Editar</button>

		</form>

	</div>
	
</body>
</html>