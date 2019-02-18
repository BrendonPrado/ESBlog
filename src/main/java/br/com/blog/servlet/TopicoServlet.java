package br.com.blog.servlet;

import br.com.blog.modelo.Topico;
import br.com.blog.modelo.Usuario;
import br.com.blog.modelo.dao.ComentarioDao;
import br.com.blog.modelo.dao.TopicoDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;


@WebServlet(urlPatterns = {"/topicos"},asyncSupported = true)
public class TopicoServlet  extends HttpServlet {
    TopicoDao topicoDao = new TopicoDao();
    Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String texto = req.getParameter("txt");
        String titulo = req.getParameter("titulo");

         if((texto != null && titulo != null) && (validaTitulo(titulo))) {
            if (topicoDao.insertMergeUser(texto, titulo, (Usuario) req.getSession().getAttribute("usuarioDono"))) {
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.getWriter().print(gson.toJson("Topico postado"));
            } else {
                resp.setContentType("application/json");
                resp.getWriter().print(gson.toJson("Nao foi possivel postar! o Titulo deve ser unico "));
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioDono");


        String comeco = req.getParameter("comeco");
        String id = req.getParameter("id");


        if (comeco != null) {
            List<Topico> topicos = topicoDao.selecionaTopicosPorIndex(Integer.parseInt(comeco));
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(topicos));

        } else if (id != null) {
            Topico topico = topicoDao.selecionaTopicoPorId(Integer.parseInt(id));
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(topico));
        }else {
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson("Nao foi possivel "));
        }

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        topicoDao.deletaPorTopico(Integer.parseInt(req.getReader().readLine()));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String titulo = req.getParameter("titulo");
        String texto = req.getParameter("txt");

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioDono");

        if ((id != null && usuario != null) && (titulo != null && validaTitulo(titulo) && texto != null)) {
            if (topicoDao.updateTopico(Integer.parseInt(id), titulo, texto)) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.setContentType("application/json");
                resp.getWriter().print(gson.toJson("Topico editado"));
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.setContentType("application/json");
                resp.getWriter().print(gson.toJson("Não foi possivel editar o topico!Ele não pode conter um título já usado e não pode estar comentado!!"));
            }
        }
    }


    public boolean validaTitulo(String titulo) {
        if (titulo.length() < 100) {
            return true;
        } else {
            return false;
        }
    }
}