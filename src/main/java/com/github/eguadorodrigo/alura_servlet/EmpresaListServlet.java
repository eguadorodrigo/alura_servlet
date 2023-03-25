package com.github.eguadorodrigo.alura_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmpresaListServlet", value = "/empresa-list")
public class EmpresaListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Lista Empresa");
        BancoDeDadosEmMemoria.carregaEmpresasPadraoNaMemoria();

        request.setAttribute("empresas", BancoDeDadosEmMemoria.listaTodasEmpresasEmMemoria());

        RequestDispatcher rd = request.getRequestDispatcher("/empresa-list.jsp");
        rd.forward(request, response);
    }
}
