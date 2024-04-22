package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class Etiqueta implements Serializable {
    private String valor;

    public Etiqueta() {
    }

    public Etiqueta(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
