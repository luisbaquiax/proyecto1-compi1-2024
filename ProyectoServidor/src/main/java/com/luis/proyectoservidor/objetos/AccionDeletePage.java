package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class AccionDeletePage extends Accion implements Serializable {
    private String idPage;

    public AccionDeletePage(String idPage) {
        this.idPage = idPage;
    }

    public AccionDeletePage(String tipo, String idPage) {
        super(tipo);
        this.idPage = idPage;
    }

    @Override
    public String toString() {
        return "AccionDeletePage{id: " +getIdPage()+" tip: "+getTipo()+"}\n";
    }

    public String getIdPage() {
        return idPage;
    }

    public void setIdPage(String idPage) {
        this.idPage = idPage;
    }
}
