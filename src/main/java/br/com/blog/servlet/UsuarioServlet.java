package br.com.blog.servlet;

import br.com.blog.modelo.dao.UsuarioDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/usuarios"},asyncSupported = true)
public class UsuarioServlet extends HttpServlet {
    Gson gson = new Gson();
    UsuarioDao usuarioDao = new UsuarioDao();
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            usuarioDao.DeletaPorIDUsuario(Integer.parseInt(req.getReader().readLine()));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
