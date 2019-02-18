package br.com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.blog.modelo.Usuario;

import java.io.IOException;

public class MinhaPagina implements Controller {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioDono");
    	request.setAttribute("nome",usuario.getNome());
    	return "forward:minhaPaginaDono.jsp";
    }
}
