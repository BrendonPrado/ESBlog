package br.com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login  implements   Controller{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "forward:Login.jsp";
    }
}
