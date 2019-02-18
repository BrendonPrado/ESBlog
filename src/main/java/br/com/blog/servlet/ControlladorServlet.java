package br.com.blog.servlet;

import br.com.blog.controller.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/entrada")
public class ControlladorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");


		String nome = null;
		Controller controller = null;
		try {
			Class<?> classe = Class.forName("br.com.blog.controller."+acao);
			controller = (Controller) classe.newInstance();
			nome = controller.executa(req,resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}


		String[] sep_nome = nome.split(":");
		if(sep_nome[0].equals("forward")) {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/"+sep_nome[1]);
			rd.forward(req, resp);
			System.out.println(sep_nome[1]);
		}else {
			resp.sendRedirect(sep_nome[1]);
		}

	}
	

}
