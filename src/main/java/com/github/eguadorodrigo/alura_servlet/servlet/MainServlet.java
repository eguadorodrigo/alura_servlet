package com.github.eguadorodrigo.alura_servlet.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/entrada")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher rd = null;

        if("lista".equals(acao)){
            System.out.println("lista");
           rd = request.getRequestDispatcher("/empresa-list");

        }else if("edita".equals(acao)){
            System.out.println("edita");
            rd = request.getRequestDispatcher("/empresa-edita");

        }else if("cadastra".equals(acao)){

            System.out.println("cadastra");
            rd = request.getRequestDispatcher("/empresa-form");
        }

        rd.forward(request,response);
    }
}
