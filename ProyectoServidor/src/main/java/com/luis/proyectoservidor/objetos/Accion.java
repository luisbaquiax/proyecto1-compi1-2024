package com.luis.proyectoservidor.objetos;

import java.io.Serializable;

public class Accion implements Serializable {
    public static final String DELE_COMPONENT = "BORRAR_COMPONENTE";
    public static final String DELETE_SITE = "BORRAR_SITIO_WEB";
    public static final String DELETE_PAGE = "BORRAR_PAGINA";
    public static final String MODIFICAR_PAGINA = "MODIFICAR_PAGINA";
    private String tipo;

    public Accion() {
    }

    @Override
    public String toString() {
        return "Accion{" +
                "tipo='" + tipo + '\'' +
                "}\n";
    }

    public Accion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
