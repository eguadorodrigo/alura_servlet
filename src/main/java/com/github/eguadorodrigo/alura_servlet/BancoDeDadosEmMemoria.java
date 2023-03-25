package com.github.eguadorodrigo.alura_servlet;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosEmMemoria {
    private static final List<Empresa> empresas = new ArrayList<>();
    static void carregaEmpresasPadraoNaMemoria() {
        Empresa emp1 = new Empresa("Apple");
        Empresa emp2 = new Empresa("Google");
        empresas.add(emp1);
        empresas.add(emp2);
    }

    static void removerEmpresa(Integer id) {
        empresas.removeIf(empresa -> id.equals(empresa.getId()));
    }

    static List<Empresa> listaTodasEmpresasEmMemoria(){
        return empresas;
    }

    public static Empresa buscarEmpresaEmMemoriaPorId(String id) {
        return empresas
                .stream()
                .filter(empresa -> empresa.getId() == Integer.parseInt(id))
                .findAny()
                .orElseThrow(()->new RuntimeException("Empresa com este id não encontrado."));
    }

    public static void alterarEmpresaEmMemoriaPorId(String id, String nome, String dataAbertura) {
        empresas.forEach(empresa -> {
            if(Integer.parseInt(id) == empresa.getId()){
                System.out.println("encontrado o id");
                empresa.setNome(nome);
                empresa.setDataAberturaFormatada(dataAbertura);
            }
        });
    }
}
