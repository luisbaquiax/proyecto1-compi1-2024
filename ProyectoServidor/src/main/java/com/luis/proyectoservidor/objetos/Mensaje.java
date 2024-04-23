/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

/**
 *
 * @author Luis
 */
public class Mensaje implements Serializable {
    public static final  String CONSULTA= "CONSULTA";
    public static final String ACCION = "ACCION";
    private String contenido;
    private String tipo;

    public Mensaje(String contenido, String tipo) {
        this.contenido = contenido;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido='" + contenido + '\'' +
                ", tipo='" + tipo + '\'' +
                "}\n";
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
