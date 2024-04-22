package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class AccionDeleteSitio extends Accion implements Serializable {
    /**
     * Id del sitio
     */
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

    /**
     * Id del sitio
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
