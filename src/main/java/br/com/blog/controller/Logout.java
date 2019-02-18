package br.com.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Controller{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("usuarioDono");
		request.getSession().removeAttribute("usuarioCadastrado");
		return "redirect:entrada?acao=Inicio";
	}

}
