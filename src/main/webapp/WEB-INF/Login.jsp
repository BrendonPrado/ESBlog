<%--
  Created by IntelliJ IDEA.
  User: brendon
  Date: 10/02/19
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/page.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.min.css">
    <title>Faça seu login</title>
</head>
<body class="container is-centered">
<nav>
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
            <a class="button is-primary has-text-white" href="/Blog/entrada?acao=UsuarioForm">Cadastre-se</a>
        </div>
    </div>
</div>
</nav>
</br>
</br>
<c:url value="/entrada?acao=Logar" var="link" />
<div class="margens-quadrada has-background-grey-light">
    <div class="card card-content margens-quadrada">
    <c:if test="${not empty msg  }">
        <span class="is-warning">${msg}</span>
    </c:if>
        <form class="card-content" method="post" action="${link}">
            <h3 class="is-3">Faça seu login!</h3>
            <label class="label" for="email">Email
                <input class="input" name="email" type="email">
            </label>
            <label for="senha" class="label">Senha
                <input class="input" name="senha" type="password">
            </label>
            <button type="submit" >Logar</button>
        </form>
    </div>
</div>

</body>
</html>
