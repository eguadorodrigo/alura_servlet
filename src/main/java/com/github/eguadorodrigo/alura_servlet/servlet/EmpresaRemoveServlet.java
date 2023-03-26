package com.github.eguadorodrigo.alura_servlet.servlet;

import com.github.eguadorodrigo.alura_servlet.modelo.BancoDeDadosEmMemoria;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmpresaRemoveServlet", value = "/empresa-remove")
public class EmpresaRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Removendo empresa");

        BancoDeDadosEmMemoria.removerEmpresa(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("mensagem", "Empresa removida com sucesso!");
        request.setAttribute("empresas", BancoDeDadosEmMemoria.listaTodasEmpresasEmMemoria());

        RequestDispatcher rd = request.getRequestDispatcher("/empresa-list.jsp");
        rd.forward(request,response);
    }
}
