package com.luis.proyectoservidor.objetos;

import java.util.List;

public class ControlXml {
    private Archivo archivo;

    public ControlXml() {
        this.archivo = new Archivo();
    }

    public void escrbirXml(List<Sitio> sitios) {
        StringBuilder contenido = new StringBuilder();
    }

    private String xmlSitios(List<Sitio> sitios) {
        StringBuilder contenido = new StringBuilder();

        for (int i = 0; i < sitios.size(); i++) {
            contenido.append("<accion nombre=\"NUEVO_SITIO_WEB\">\n");

            contenido.append(" \t<parametros>\n<parametro nombre=\"ID\">\n");
            contenido.append("[");
            contenido.append(sitios.get(i).getId());
            contenido.append("]\n");
            contenido.append(" \t<parametro nombre=\"USUARIO_CREACION\">\n");
            contenido.append("[");
            contenido.append(sitios.get(i).getUserCreacion());
            contenido.append("]\n");
            contenido.append(" \t<parametro nombre=\"FECHA_CREACION\">\n");
            contenido.append("[\n");
            contenido.append(sitios.get(i).getFechaCreacion());
            contenido.append("]\n");
            contenido.append(" \t<parametro nombre=\"USUARIO_MODIFICACION\">\n");
            contenido.append("[");
            contenido.append(sitios.get(i).getUserModificacion());
            contenido.append("]\n");
            contenido.append(" \t<parametro nombre=\"FECHA_MODIFICACION\">\n");
            contenido.append("[\n");
            contenido.append(sitios.get(i).getFechaModificacion());
            contenido.append("]\n");
            contenido.append("\t</parametros>");
            contenido.append("</accion>\n");
        }

        return contenido.toString();
    }

    private String xmlPaginas(List<Pagina> paginas) {
        StringBuilder contenido = new StringBuilder();

        for (int i = 0; i < paginas.size(); i++) {
            contenido.append("<accion nombre=\"NUEVA_PAGINA\">\n");

            contenido.append(" \t<parametros>\n<parametro nombre=\"ID\">\n");
            contenido.append("[");
            contenido.append(paginas.get(i).getId());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"TITULO\">\n");
            contenido.append("[");
            contenido.append(paginas.get(i).getTitulo());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"SITIO\">\n");
            contenido.append("[\n");
            contenido.append(paginas.get(i).getSitio());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"PADRE\">\n");
            contenido.append("[");
            contenido.append("</parametro>\n");
            contenido.append(paginas.get(i).getPadre());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"USUARIO_CREACION\">\n");
            contenido.append("[\n");
            contenido.append("</parametro>\n");
            contenido.append(paginas.get(i).getUsuarioCreacion());
            contenido.append("]\n");
            contenido.append(" \t<parametro nombre=\"FECHA_CREACION\">\n");
            contenido.append("[\n");
            contenido.append(paginas.get(i).getFechaCreacion());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"USUARIO_MODIFICACION\">\n");
            contenido.append("[\n");
            contenido.append(paginas.get(i).getUsuarioModificacion());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append(" \t<parametro nombre=\"FECHA_MODIFICACION\">\n");
            contenido.append("[\n");
            contenido.append(paginas.get(i).getFechaModificacion());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append("\t</parametros>");

            List<Etiqueta> etiquetas = paginas.get(i).getEtiquetas();
            for (int j = 0; j < etiquetas.size(); j++) {
                contenido.append("\t<etiquetas valor=\"");
                contenido.append(etiquetas.get(i).getValor());
                contenido.append("\"/>\n");
            }

            contenido.append("</accion>\n");
        }

        return contenido.toString();
    }

    private String xmlComponents(List<Componente> componentes) {
        StringBuilder contenido = new StringBuilder();

        for (int i = 0; i < componentes.size(); i++) {
            contenido.append("<accion nombre=\"NUEVO_SITIO_WEB\">\n");

            contenido.append(" \t<parametros>\n<parametro nombre=\"ID\">\n");
            contenido.append("[");
            contenido.append(componentes.get(i).getId());
            contenido.append("]\n");
            contenido.append("</parametro>\n");
            contenido.append("\t</parametros>");
            contenido.append("</accion>\n");
        }

        return contenido.toString();
    }


}
