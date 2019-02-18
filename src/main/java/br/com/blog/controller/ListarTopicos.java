package br.com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListarTopicos implements Controller {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("usuarioDono")!=null) {
    	   return "forward:TopicosUsuarioDono.jsp";
       }else if(request.getSession().getAttribute("usuarioCadastrado")!=null){
    	   return "forward:TopicosUsuarioCadastrado.jsp";
       }else {
    	   return "forward:TopicosUsuarioVisitante.jsp";
       }
    }
}
