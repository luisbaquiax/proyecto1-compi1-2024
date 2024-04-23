package com.luis.proyectoservidor.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagina implements Serializable {
    private String id;
    private String titulo;
    private String sitio;
    private String padre;
    private String usuarioCreacion;
    private String fechaCreacion;
    private String usuarioModificacion;
    private String fechaModificacion;
    private List<Componente> componentes;
    private List<Etiqueta> etiquetas;
    private List<Pagina> hijas;

    public Pagina() {
        this.componentes = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
        this.hijas = new ArrayList<>();
    }

    public Pagina(String id, String titulo, String sitio, String padre, String usuarioCreacion, String fechaCreacion, String usuarioModificacion, String fechaModificacion) {
        this.id = id;
        this.titulo = titulo;
        this.sitio = sitio;
        this.padre = padre;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.componentes = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
        this.hijas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pagina{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", sitio='" + sitio + '\'' +
                ", padre='" + padre + '\'' +
                ", usuarioCreacion='" + usuarioCreacion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", usuarioModificacion='" + usuarioModificacion + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                ", \ncomponentes=" + componentes +
                ", \netiquetas=" + etiquetas +
                ", \nhijas=" + hijas +
                "}\n\n";
    }

    public List<Pagina> getHijas() {
        return hijas;
    }

    public void setHijas(List<Pagina> hijas) {
        this.hijas = hijas;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}

