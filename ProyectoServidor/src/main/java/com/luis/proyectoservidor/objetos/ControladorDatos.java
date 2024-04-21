package com.luis.proyectoservidor.objetos;

import java.io.IOException;
import java.util.List;

public class ControladorDatos {
    CreadorSitios creadorSitios;
    ControlXml controlXml;

    public ControladorDatos(CreadorSitios creadorSitios) {
        this.creadorSitios = creadorSitios;
        this.controlXml = new ControlXml();
    }

    public void eliminarSitio(String idSitio, List<Sitio> sitios) throws IOException {
        for (int i = 0; i < sitios.size(); i++) {
            if(sitios.get(i).getId().equals(idSitio)){
                Sitio remove = sitios.remove(i);
            }
        }
        this.creadorSitios.crearCarpetasDeSitios(sitios);
        this.creadorSitios.crearArchivosHtml(sitios);
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }
    public  void eliminarPagina(String idPagina, List<Sitio> sitios){
        for (int i = 0; i < sitios.size(); i++) {
            List<Pagina> paginas = sitios.get(i).getPaginas();
            for (int j = 0; j < paginas.size(); j++) {
                if(paginas.get(j).getId().equals(idPagina)){
                    Pagina remove = sitios.get(i).getPaginas().remove(j);
                }
            }
        }
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }
}
