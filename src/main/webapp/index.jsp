<%@page import="br.com.blog.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.min.css">
    <meta charset="UTF-8">
    <title>ESBlog</title>
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

            <c:set var="user" scope="session" value="${usuarioDono}"></c:set>
            <c:if test="${not empty user}">
                <a href="/Blog/entrada?acao=MinhaPagina" class="navbar-item">
                    Minha Pagina
                </a>
            </c:if>

        </div>
        <div class="navbar-end">
            <c:choose>
                <c:when test="${empty usuarioDono and empty usuarioCadastrado}">
                    <div class="navbar-item">
                        <a class="button is-link has-text-white" href="/Blog/entrada?acao=Login">Entrar</a>
                    </div>
                    <div class="navbar-item">
                        <a class="button is-primary has-text-white" href="/Blog/entrada?acao=UsuarioForm">Cadastre-se</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="navbar-item">
                        <a class="button is-danger has-text-white" href="/Blog/entrada?acao=Logout">Logout</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<div >
    <h1 class="title is-1">ES<strong style="color: rgb(224, 90, 71);">Blog</strong></h1>
    <h4 class="texto-home">Seu Blog de Engenharia de software</h4>
</div>
</body>
</html>