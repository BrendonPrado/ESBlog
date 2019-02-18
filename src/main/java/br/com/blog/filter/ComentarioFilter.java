package br.com.blog.filter;

import br.com.blog.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ComentarioFilter")
public class ComentarioFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        boolean ehUsuarioDono = session.getAttribute("usuarioDono") != null;
        boolean ehUsuarioCadastrado = session.getAttribute("usuarioCadastrado") != null;


        if((request.getMethod().equals("POST")) && (!(ehUsuarioDono || ehUsuarioCadastrado))){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            request.setAttribute("msg","Para comentar vc deve se autenticar como usuário!");
            requestDispatcher.forward(req,resp);
        }else if ((request.getMethod().equals("POST")) && (!(ehUsuarioDono))){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            request.setAttribute("msg","Para deletar comentarios vc deve se autenticar como usuário!");
            requestDispatcher.forward(req,resp);
        }else {
            chain.doFilter(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
