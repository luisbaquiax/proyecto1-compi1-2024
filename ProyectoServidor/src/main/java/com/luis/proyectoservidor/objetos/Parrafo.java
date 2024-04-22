package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class Parrafo extends Titulo implements Serializable {
    public Parrafo(String id, String pagina, String clase, String texto, String alineacion, String color) {
        super(id, pagina, clase, texto, alineacion, color);
    }

    public Parrafo() {
    }

    public Parrafo(String texto, String alineacion, String color) {
        super(texto, alineacion, color);
    }

    @Override
    public String toString() {
        return "Parrafo{id= "+getId()+" txt= "+getTexto()+"}\n";
    }
}
