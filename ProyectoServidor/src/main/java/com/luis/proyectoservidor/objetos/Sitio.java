package com.luis.proyectoservidor.objetos;

import java.util.ArrayList;
import java.util.List;

public class Sitio {
    private String id;
    private String userCreacion;
    private String fechaCreacion;
    private  String userModificacion;
    private  String fechaModificacion;

    private List<Pagina> paginas;

    public Sitio() {
        this.paginas = new ArrayList<>();
    }

    public Sitio(String id, String userCreacion, String fechaCreacion, String userModificacion, String fechaModificacion) {
        this.id = id;
        this.userCreacion = userCreacion;
        this.fechaCreacion = fechaCreacion;
        this.userModificacion = userModificacion;
        this.fechaModificacion = fechaModificacion;
        this.paginas = new ArrayList<>();
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCreacion() {
        return userCreacion;
    }

    @Override
    public String toString() {
        return "Sitio{" +
                "id='" + id + '\'' +
                ", userCreacion='" + userCreacion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", userModificacion='" + userModificacion + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                "}\n";
    }

    public void setUserCreacion(String userCreacion) {
        this.userCreacion = userCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(String userModificacion) {
        this.userModificacion = userModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
