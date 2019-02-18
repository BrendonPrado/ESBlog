<%--
  Created by IntelliJ IDEA.
  User: brendon
  Date: 11/02/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="css/page.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/topicos-visitante.js"></script>
    <meta charset="UTF-8">
    <title>Tópicos</title>
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

        </div>
        <div class="navbar-end">
					<div class="navbar-item">
                		<a class="button is-link has-text-white" href="/Blog/entrada?acao=Login">Entrar</a>
            		</div>
            		<div class="navbar-item">
                		<a class="button is-primary has-text-white" href="/Blog/entrada?acao=UsuarioForm">Cadastre-se</a>
            		</div>

        </div>
    </div>
</nav>
<div>
    <ul class="content is-medium" id="topicos">

    </ul>
</div>
<div id="topicos-mais">
    <button id="botao-mais-topicos" class="button is-large is-dark" style="margin-left: 37%;margin-bottom: 5% ;" onclick="carregaTopicos()">Carregar Mais Tópicos</button>
</div>
</body>
</html>
