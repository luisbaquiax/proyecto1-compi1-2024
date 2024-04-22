package com.luis.proyectoservidor.objetos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorDatos {
    private CreadorSitios creadorSitios;
    private ControlXml controlXml;

    private List<String> mensajes;

    public ControladorDatos(CreadorSitios creadorSitios) {
        this.creadorSitios = creadorSitios;
        this.controlXml = new ControlXml();
        this.mensajes = new ArrayList<>();
    }

    public void agregarSitios(List<Sitio> sitios, List<Pagina> paginas, List<Componente> componentes) {
        try {
            List<Sitio> dataSitios = (List<Sitio>) creadorSitios.getArchivo().getObjectDatos(Archivo.RUTA_SITIOS);
            List<Pagina> dataPaginas = (List<Pagina>) creadorSitios.getArchivo().getObjectDatos(Archivo.RUTA_PAGINAS);

            if (dataSitios == null) {
                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
            }
            if (dataPaginas == null) {
                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_PAGINAS, paginas);
            }
            //AGREGAR SITIOS Y VALIDAR QUE NO ESTEN REPETIDOS
            for (int i = 0; i < dataSitios.size(); i++) {

            }

        } catch (IOException | ClassNotFoundException  | NullPointerException e) {
            mensajes.add("Mensaje del servidor: \tNO SE PUDO CREAR LOS SITIOS WEB, LO SENTIMOS");
        }
    }

    public void agregarPaginasAsitios(List<Sitio> sitios, List<Pagina> paginas){
        for (int i = 0; i < sitios.size(); i++) {
            for (int j = 0; j < paginas.size(); j++) {
                if(sitios.get(i).getId().equals(paginas.get(j).getSitio())){
                    sitios.get(i).getPaginas().add(paginas.get(j));
                }
            }
        }
    }

    public void agregarComponenteAPagina(List<Pagina> paginas, List<Componente> componentes){
        for (int i = 0; i < paginas.size(); i++) {
            for (int j = 0; j < componentes.size(); j++) {
                if(paginas.get(i).getId().equals(componentes.get(j).getPagina())){
                    paginas.get(i).getComponentes().add(componentes.get(j));
                }
            }
        }
    }

    public void eliminarSitio(String idSitio, List<Sitio> sitios) throws IOException {
        for (int i = 0; i < sitios.size(); i++) {
            if (sitios.get(i).getId().equals(idSitio)) {
                Sitio remove = sitios.remove(i);
                creadorSitios.eliminarCarpetaOArchivo(Archivo.CARPETA_SITIOS + File.separator + remove.getId());
                break;
            }
        }
        this.creadorSitios.crearCarpetasDeSitios(sitios);
        this.creadorSitios.crearArchivosHtml(sitios);
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }

    public void eliminarPagina(String idPagina, List<Sitio> sitios) {
        for (int i = 0; i < sitios.size(); i++) {
            Sitio sitio = sitios.get(i);
            List<Pagina> paginas = sitios.get(i).getPaginas();
            for (int j = 0; j < paginas.size(); j++) {
                if (paginas.get(j).getId().equals(idPagina)) {
                    Pagina remove = sitios.get(i).getPaginas().remove(j);
                    creadorSitios.eliminarCarpetaOArchivo(
                            Archivo.CARPETA_SITIOS + File.separator + sitio.getId() + File.separator + remove.getId());
                    break;
                }
            }
        }
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }

    public void eliminarComponente(String idComponent, Pagina pagina) {
        for (int i = 0; i < pagina.getComponentes().size(); i++) {
            if (idComponent.equals(pagina.getComponentes().get(i).getId())) {
                break;
            }
        }
    }
}
