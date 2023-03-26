package com.github.eguadorodrigo.alura_servlet.servlet;

import com.github.eguadorodrigo.alura_servlet.modelo.BancoDeDadosEmMemoria;
import com.github.eguadorodrigo.alura_servlet.modelo.Empresa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmpresaFormServlet", value = "/empresa-form")
public class EmpresaFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/empresa-form.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Vai cadastrar uma empresa");
        List<Empresa> empresas = BancoDeDadosEmMemoria.listaTodasEmpresasEmMemoria();
        criaEmpresaViaRequest(request, empresas);

        request.setAttribute("empresas", empresas);
        request.setAttribute("mensagem", "Empresa cadastrada com sucesso!");

        RequestDispatcher rd = request.getRequestDispatcher("/empresa-list.jsp");
        rd.forward(request,response);
    }

    private static void criaEmpresaViaRequest(HttpServletRequest request, List<Empresa> empresas) {
        String nome = request.getParameter("cadastraNome");
        String dataAbertura = request.getParameter("cadastraDataAbertura");
        System.out.println(nome);
        System.out.println(dataAbertura);
        empresas.add(new Empresa(nome, Date.valueOf(dataAbertura)));
    }
}
