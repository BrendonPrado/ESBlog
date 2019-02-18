package br.com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Inicio implements  Controller{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "forward:index.jsp";
    }
}
