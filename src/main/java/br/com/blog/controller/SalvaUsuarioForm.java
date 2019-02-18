package br.com.blog.controller;

import br.com.blog.modelo.TipoDeUsuario;
import br.com.blog.modelo.Usuario;
import br.com.blog.modelo.dao.UsuarioDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalvaUsuarioForm implements  Controller {
	UsuarioDao usuarioDao = new UsuarioDao();
	Gson gson = new Gson();


	public boolean validarEmail(String email)
	{
		boolean emailValido = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				emailValido = true;
			}
		}
		return emailValido;
	}
	public  boolean validaNome(String nome){
		if(nome.length() > 100){
			return false;
		}
		return true;
	}
	public boolean validaApelido(String apelido){
		if(apelido.length() >30){
			return false;
		}
		return true;
	}

	public boolean validaSenha(String senha){
		if(senha.length()> 10){
			return true;
		}
		return false;
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String apelido = request.getParameter("apelido");

		boolean dadosValidos = validaApelido(apelido) && validaNome(nome) && validarEmail(email) && validaSenha(senha);

		if(!this.verificaMetodoHttpCorreto("POST",request,response)){
			request.setAttribute("msg","Por favor para cadastrar utilize apenas metodo POST!");
			return "forward:FormUsuario.jsp";

		};

		Usuario usuario = new Usuario(nome,senha,email, apelido);
		System.out.println(usuario.getApelido() + usuario.getNome());
		PrintWriter out = response.getWriter();
		if (dadosValidos) {
			out.print(this.gson.toJson("Por favor envie nome,email e apelido para checar disponibilidade no sistema."));
		} else {
			if (usuarioDao.SelecionaPorNome(usuario.getNome()) == null) {
				if (usuarioDao.SelecionaPorEmail(usuario.getEmail()) == null){
					if (usuarioDao.SelecionaPorApelido(usuario.getApelido()) == null){
						usuarioDao.Insert(usuario);
						request.setAttribute("msg", "Usuario Cadastrado!");
						return "forward:FormUsuario.jsp";
					}else {
						request.setAttribute("msg", "Não foi possível fazer o cadastro!  Apelido já usado");
						return "forward:FormUsuario.jsp";
					}
				}else {
					request.setAttribute("msg", "Não foi possível fazer o cadastro!  Email já usado");
					return "forward:FormUsuario.jsp";
				}

			}else {
				request.setAttribute("msg", "Não foi possível fazer o cadastro! Nome já cadastrado");
				return "forward:FormUsuario.jsp";
			}

		}
		request.setAttribute("msg", "Não Foi possível Cadastrar");
		return "forward:FormUsuario.jsp";
	}
}


