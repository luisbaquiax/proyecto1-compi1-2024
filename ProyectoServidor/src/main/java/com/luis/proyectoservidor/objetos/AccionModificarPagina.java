package com.luis.proyectoservidor.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccionModificarPagina extends Accion implements Serializable {
    private String idPagina;
    private String titulo;
    private List<Etiqueta> etiquetas;

    public AccionModificarPagina(String idPagina, String titulo) {
        this.idPagina = idPagina;
        this.titulo = titulo;
        this.etiquetas = new ArrayList<>();
    }

    public AccionModificarPagina(String tipo, String idPagina, String titulo) {
        super(tipo);
        this.idPagina = idPagina;
        this.titulo = titulo;
        this.etiquetas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "AccionModificarPagina{" +
                "idPagina='" + idPagina + '\'' +
                ", titulo='" + titulo + '\'' +
                ", etiquetas=" + etiquetas +
                "}\n";
    }

    public String getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(String idPagina) {
        this.idPagina = idPagina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
