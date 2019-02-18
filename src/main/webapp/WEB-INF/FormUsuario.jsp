<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bulma.min.css">
<meta charset="UTF-8">
<title>Cadastre-se</title>
</head>
<body class="container is-centered">
<nav class="nav">
	<div class="navbar-brand">
		<a class="" href="http://localhost:8080/Blog">
			<img src="image/ESBlog.png" height="125" width="125">
		</a>

		<div class="navbar-start">
			<a href="/Blog" class="navbar-item">
				Inicío
			</a>

			<a href="/Blog/entrada?acao=ListarTopicos" class="navbar-item">
				Tópicos
			</a>


		</div>
		<div class="navbar-end">
			<div class="navbar-item">
				<a class="button is-link has-text-white" href="/Blog/entrada?acao=Login">Entrar</a>
			</div>
			<div class="navbar-item">
			</div>
		</div>
	</div>
</nav>

	<h1 class="title is-1">Cadastre-se agora!</h1>
	<span>${msg}</span>
	<form class="container is-fluid"  method="post" action="/Blog/entrada?acao=SalvaUsuarioForm">
		<label class="label" for="nome">Nome:
		<input name="nome" class="input"  max="100" placeholder="Nome" required type="text">
		</label>
		<label class="label" for="email">Email:
		<input name="email" class="input" max="100" placeholder="email" required type="email">
		</label>
		<label class="label" for="apelido">Apelido:
			<input name="apelido" class="input"  max="30" placeholder="apelido" required type="text">
		</label>

		<label for="senha" class="label">Senha:
			<input name="senha" class="input" max="10" placeholder="Senha" required type="text">
		</label>
		<button  id="botao" class="button" type="submit">Cadastrar</button>
	</form>
	

</body>
</html>