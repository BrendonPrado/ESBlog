<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/page.css">
<link rel="stylesheet" type="text/css" href="css/bulma.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/usuario.js"></script>
<meta charset="UTF-8">
<title>Remova os usuários</title>
</head>
<body class="container is-fluid">
<nav class="nav">
    <div class="navbar-brand">
        <a class="/Blog" href="http://localhost:8080/Blog">
            <img src="image/ESBlog.png" class="image" height="125" width="125">
        </a>

        <div class="navbar-start">
            <a href="/Blog" class="navbar-item">
                Inicío
            </a>

            <a href="/Blog/entrada?acao=ListarTopicos" class="navbar-item">
                Tópicos
            </a>
            
                <a href="/Blog/entrada?acao=MinhaPagina" class="navbar-item">
                    Minha Pagina
                </a>

        </div>
        <div class="navbar-end">
					
					<div class="navbar-item">
                		<a class="button is-danger has-text-white" id="remover" href="/Blog/entrada?acao=Logout">Logout</a>
            		</div>
        </div>
    </div>
</nav>
	<div id="conteudo">
	</div>
	<c:if test="${ not empty usuarios }">
    <div class="card margens">
        <h2 class="title is-h2">Remova os usuários desejados!</h2>

        <div class="card-content">
            <ol class="list">
            	<c:forEach items="${ usuarios }" var="usuario">
                    <li class="list-item"><div class="card-content"><p>${usuario.nome}</p><button class="button is-danger" style="float: right;transform: translateY(-3ch)"  onclick="deleteUsuario(this,${usuario.id})" >Remover</button></div></li>
            	</c:forEach>
            </ol>
        </div>
        </c:if>
       <c:if test="${ empty usuarios}">
           <h2 class="is-bold card">Não há usuários cadastrados</h2>
       </c:if>
    </div>
</body>
</html>