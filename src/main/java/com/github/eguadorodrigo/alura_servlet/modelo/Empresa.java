package com.github.eguadorodrigo.alura_servlet.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

public class Empresa {

    private String nome;
    private Integer id;

    private Date dataAbertura;

    public Empresa() {
         this.dataAbertura = new Date();
    }

    public Empresa(String nome) {
        this.nome = nome;
        this.dataAbertura = new Date();
        this.id = getRandomValue();
    }


    public Empresa(String nome, Date dataAbertura) {
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.id = getRandomValue();
    }

    private Date conversorDeData(String dataAbertura) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dataFormatada = new Date();
        try{
            dataFormatada = formatter.parse(dataAbertura);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return dataFormatada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    private int getRandomValue() {
        return new Random().nextInt(100);
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }

    public void setDataAberturaFormatada(String dataAbertura) {
        this.dataAbertura = conversorDeData(dataAbertura);
    }
}
