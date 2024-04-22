package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class Video extends Componente implements Serializable {
    private int altura;
    private int anchura;
    private String ruta;

    public Video() {
    }

    public Video(int altura, int anchura, String ruta) {
        this.altura = altura;
        this.anchura = anchura;
        this.ruta = ruta;
    }

    public Video(String id, String pagina, String clase, int altura, int anchura, String ruta) {
        super(id, pagina, clase);
        this.altura = altura;
        this.anchura = anchura;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Video{" +
                "altura=" + altura +
                ", anchura=" + anchura +
                ", ruta='" + ruta + '\'' +
                "}\n";
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
