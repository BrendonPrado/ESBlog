package br.com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.blog.modelo.dao.UsuarioDao;

public class GerenciarUsuarios implements Controller {
	UsuarioDao UsuarioDao = new UsuarioDao();
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setAttribute("usuarios",this.UsuarioDao.SelecionaTodosUsuariosNaoDono());
		return "forward:ListaUsuarios.jsp";
	}

}
