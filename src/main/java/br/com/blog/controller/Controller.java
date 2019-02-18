package br.com.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    default boolean verificaMetodoHttpCorreto(String get, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String metodo = request.getMethod();
        if(!metodo.equals(get)){
          return false;

        }else {
            return true;
        }
    };


}
