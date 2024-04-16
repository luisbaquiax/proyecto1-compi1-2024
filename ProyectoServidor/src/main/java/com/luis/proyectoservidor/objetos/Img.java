package com.luis.proyectoservidor.objetos;

public class Img extends Componente {
    private int altura;
    private int anchura;
    private String ruta;
    private String alineacion;

    public Img() {
    }

    public Img(int altura, int anchura, String ruta, String alineacion) {
        this.altura = altura;
        this.anchura = anchura;
        this.ruta = ruta;
        this.alineacion = alineacion;
    }

    public Img(String id, String pagina, String clase, int altura, int anchura, String ruta, String alineacion) {
        super(id, pagina, clase);
        this.altura = altura;
        this.anchura = anchura;
        this.ruta = ruta;
        this.alineacion = alineacion;
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

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }
}
