package br.com.blog.controller;

import br.com.blog.modelo.TipoDeUsuario;
import br.com.blog.modelo.Usuario;
import br.com.blog.modelo.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logar implements Controller {
    public UsuarioDao usuarioDao = new UsuarioDao();
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if(!this.verificaMetodoHttpCorreto("POST",request,response)){
            request.setAttribute("msg","Por favor para logar use apenas metodo POST");
            return "forward:Login.jsp";

        }else{
            Usuario usuarioReal = usuarioDao.SelecionaPorEmail(email);
            if (usuarioReal != null){
                if(usuarioReal.getSenha().equals(senha) && usuarioReal.getTipoDeUsuario().equals(TipoDeUsuario.Cadastrado)){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuarioCadastrado",usuarioReal);
                    return "redirect:entrada?acao=ListarTopicos";
                }else if(usuarioReal.getSenha().equals(senha) && usuarioReal.getTipoDeUsuario().equals(TipoDeUsuario.Dono)){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuarioDono",usuarioReal);
                    return "redirect:entrada?acao=MinhaPagina";
                }else{
                    request.setAttribute("msg","Email ou senha incorretos");
                    return "forward:Login.jsp";
                }
            }
            request.setAttribute("msg","Email ou senha incorretos");
            return "forward:Login.jsp";
        }

    }
}
