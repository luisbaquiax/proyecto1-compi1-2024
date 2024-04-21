package com.luis.proyectoservidor.objetos;

public class AccionDeleteSitio extends Accion {
    private String id;

    public AccionDeleteSitio(String id) {
        this.id = id;
    }

    public AccionDeleteSitio(String tipo, String id) {
        super(tipo);
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccionDeleteSitio{" + "tipo: " + getTipo() + " id: " + getId() + " }\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
