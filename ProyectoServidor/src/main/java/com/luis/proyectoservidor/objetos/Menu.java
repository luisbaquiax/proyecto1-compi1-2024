package com.luis.proyectoservidor.objetos;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Componente {
    private String padre;
    private List<Etiqueta> etiquetas;

    public Menu() {
        this.etiquetas = new ArrayList<>();
    }

    public Menu(String id, String pagina, String clase) {
        super(id, pagina, clase);
        this.etiquetas = new ArrayList<>();
    }

    public Menu(String id, String pagina, String clase, String padre) {
        super(id, pagina, clase);
        this.padre = padre;
        this.etiquetas = new ArrayList<>();
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
