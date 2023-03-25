package com.github.eguadorodrigo.alura_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmpresaEditaServlet", value = "/empresa-edita")
public class EmpresaEditaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Buscando dado para alterar uma empresa");

        Empresa empresa = BancoDeDadosEmMemoria.buscarEmpresaEmMemoriaPorId(request.getParameter("id"));
        System.out.println(empresa.toString());
        request.setAttribute("empresa", empresa);

        RequestDispatcher rd = request.getRequestDispatcher("/empresa-form.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Alterando dado de uma empresa");

        String id = request.getParameter("id");
        String nome = request.getParameter("editaNome");
        String dataAbertura = request.getParameter("editaDataAbertura");

        BancoDeDadosEmMemoria.alterarEmpresaEmMemoriaPorId(id, nome, dataAbertura);

        request.setAttribute("empresas", BancoDeDadosEmMemoria.listaTodasEmpresasEmMemoria());

        RequestDispatcher rd = request.getRequestDispatcher("/empresa-list.jsp");
        rd.forward(request,response);

    }
}
