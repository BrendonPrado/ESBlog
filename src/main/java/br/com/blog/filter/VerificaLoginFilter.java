package br.com.blog.filter;

import br.com.blog.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "VerificaLoginFilter",urlPatterns = {"/entrada"})
public class VerificaLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        String acao = request.getParameter("acao");
        boolean ehUsuarioDono = session.getAttribute("usuarioDono") != null;
        boolean ehUsuarioCadastrado = session.getAttribute("usuarioCadastrado") != null;
        if((ehUsuarioCadastrado || ehUsuarioDono) && (acao.equals("Login") || acao.equals("Logar") || acao.equals("UsuarioForm"))){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(req,response);
        }
        if((!ehUsuarioDono) && (!(acao.equals("ListarTopicos") || acao.equals("Login") || acao.equals("Inicio") || acao.equals("UsuarioForm") || acao.equals("SalvaUsuarioForm") || acao.equals("Logar")))){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Login.jsp");
            request.setAttribute("msg","Você tem que fazer o login primeiro!!");
            rd.forward(req,response);
        }else{
            chain.doFilter(req,resp);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
