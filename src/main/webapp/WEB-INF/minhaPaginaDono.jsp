<%--
  Created by IntelliJ IDEA.
  User: brendon
  Date: 11/02/19
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bulma.min.css">

    <title>Bem Vindo ${nome}</title>
</head>
<body class="container is-centered">
<nav class="nav">
    <div class="navbar-brand">
        <a class="/Blog" href="http://localhost:8080/Blog">
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
                		<a class="button is-danger has-text-white" href="/Blog/entrada?acao=Logout">Logout</a>
            		</div>
        </div>
    </div>
</nav>

    <div class="card margens">
        <div class="card-content">
            <ol class="list">
                <li class="list-item"><a href="/Blog/entrada?acao=GerenciarUsuarios">Gerenciar usuários</a></li>
                <li class="list-item"><a href="/Blog/entrada?acao=ListarTopicos">Gerenciar Tópicos e comentários</a></li>
            </ol>
        </div>
    </div>

</body>
</html>
