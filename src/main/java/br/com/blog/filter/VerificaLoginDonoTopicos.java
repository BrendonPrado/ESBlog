package br.com.blog.filter;

import br.com.blog.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/topicos"})
public class VerificaLoginDonoTopicos implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;


        String txt = req.getParameter("txt");
        String titulo = req.getParameter("titulo");

        boolean ehUsuarioDono = (Usuario) req.getSession().getAttribute("usuarioDono") != null;
        if((!ehUsuarioDono) && (txt != null && titulo != null)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            req.setAttribute("msg","Para criar Tópicos vc deve se autenticar como usuário Dono!");
            requestDispatcher.forward(request,response);
        }else if ((!ehUsuarioDono) && (req.getMethod().equals("PUT") || req.getMethod().equals("DELETE"))){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
            req.setAttribute("msg","Para criar Tópicos vc deve se autenticar como usuário Dono!");
            requestDispatcher.forward(request,response);
        }
        else {
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
