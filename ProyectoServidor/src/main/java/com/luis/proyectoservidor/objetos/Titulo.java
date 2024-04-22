package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class Titulo extends Componente implements Serializable {

    private String texto;
    private String alineacion;
    private String color;

    public Titulo() {
    }

    public Titulo(String texto, String alineacion, String color) {
        this.texto = texto;
        this.alineacion = alineacion;
        this.color = color;
    }

    public Titulo(String id, String pagina, String clase, String texto, String alineacion, String color) {
        super(id, pagina, clase);
        this.texto = texto;
        this.alineacion = alineacion;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "texto='" + texto + '\'' +
                ", alineacion='" + alineacion + '\'' +
                ", color='" + color + '\'' +
                "}\n";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
