package com.luis.proyectoservidor.objetos;

public class AccionDeletComponent extends Accion {
    private String component;
    private String page;

    public AccionDeletComponent(String component, String page) {
        this.component = component;
        this.page = page;
    }

    public AccionDeletComponent(String tipo, String component, String page) {
        super(tipo);
        this.component = component;
        this.page = page;
    }

    @Override
    public String toString() {
        return "AccionDeletComponent{" +
                "component='" + component + '\'' +
                ", page='" + page + " tip: " + getTipo() +
                "}\n";
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
