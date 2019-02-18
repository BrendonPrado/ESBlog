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
    <title>Tópicos</title>

    <link rel="stylesheet" type="text/css" href="css/page.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <meta charset="UTF-8">
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
               <a href="/Blog/entrada?acao=MinhaPagina" class="navbar-item">
                    Minha Pagina
                </a>
        </div>
        <div class="navbar-end">			
					<div class="navbar-item">
                		<a class="button is-danger has-text-white" href="/Blog/entrada?acao=Logout">Logout</a>
            		</div>
        </div>
    </div>
</nav>
<br>
<br>
<span id="msg"> </span>
<form style="display: none" id="novo-topico">
    <div class="field">
        <label  class="is-hovered title is-1 label">Insira um Título :
            <div class="field">
                <div class="control">
                    <input class="input is-dark"  max="100" id="titulo-novo-topico" required type="text" placeholder="Título">
                </div>
            </div>
        </label>
        <br>
        <div class="control">
            <textarea class="textarea is-info" id="texto-novo-topico" required placeholder="Escreva Seu tópico aqui"></textarea>
        </div>
    </div>
    <div class="is-inline-block" id="opcoes-novo-topico">
        <a class="button is-dark" id="postar" onclick="postaNovoTopico()" type="button">Postar</a>
    </div>
</form>
<div>
<button type="reset" onclick="mostraFormularioNovoTopico()" id="botao-hide-topi" class="button is-fullwidth is-dark">Adicionar novo tópico</button>
</div>
    <div>
    <ul class="content is-medium" id="topicos">

    </ul>
   </div>
    <div id="topicos-mais">
        <button id="botao-mais-topicos" class="button is-large is-dark" style="margin-left: 37%;margin-bottom: 5% ;" onclick="carregaTopicos()">Carregar Mais Tópicos</button>
    </div>
</body>
</html>
