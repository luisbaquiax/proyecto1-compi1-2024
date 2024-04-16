package com.luis.proyectoservidor.objetos;

public class Parrafo extends Titulo {
    public Parrafo(String id, String pagina, String clase, String texto, String alineacion, String color) {
        super(id, pagina, clase, texto, alineacion, color);
    }

    public Parrafo(String texto, String alineacion, String color) {
        super(texto, alineacion, color);
    }
}
