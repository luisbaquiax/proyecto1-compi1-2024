package com.luis.proyectoservidor.objetos;

public class AccionDeletePage extends Accion{
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
