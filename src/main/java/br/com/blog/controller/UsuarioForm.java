package br.com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsuarioForm implements Controller{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "forward:FormUsuario.jsp";
	}

}
