<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String erro = (String) request.getAttribute("erro");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Logar Usuario</title>
</head>
<body>
	
	<div class="container">
 		<div class="card">
 		 <section class="header">
      <h2>Login</h2>
    </section>
    			<form name="frmLogar" action="logar">
				<input type="text" id="username" name="usuario"
					placeholder="Usuario" required> <input type="password" id="password" name="senha" placeholder="Senha" required>
			      	
			      	<button type="submit"">Logar</button><br/>
			      	
			      	<a href="recuperaSenha.jsp">esqueceu a senha?</a><br/>
			      	<a href="index.html">Voltar</a>
    				<p><% 
			      		if(erro !=null){
			      			out.print(erro);
			      		}
			      	%></p>
    			</form>
    			
  		</div>
	</div>

</body>
</html>