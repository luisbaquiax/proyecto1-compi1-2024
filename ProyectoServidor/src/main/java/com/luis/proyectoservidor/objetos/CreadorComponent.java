package com.luis.proyectoservidor.objetos;

import java.io.IOException;
import java.util.List;

public class CreadorComponent {

    public static final String CENTER = "CENTRAR";
    public static final String LEFT = "IZQUIERDA";
    public static final String RIGHT = "DERECHA";
    public static final String JUSTIFY = "JUSTIFICAR";

    private Archivo archivo;

    public CreadorComponent() {
        this.archivo = new Archivo();
    }

    public String crearTituloParrafo(String texto, String alineacion, String color) {
        StringBuilder content = new StringBuilder();
        content.append(getAlineacion(getAtributeTituloParrafo(texto, color), texto));
        return content.toString();
    }

    private String getAtributeTituloParrafo(String texto, String color) {
        String content = "<h1 style=\"color: " +
                color +
                ";\">" +
                texto +
                " </h1>\n";
        return content;
    }

    public String crearImg(String ruta, String alineacion, int altura, int anchura) {
        StringBuilder content = new StringBuilder();
        content.append(getAlineacion(getAtributeImg(ruta, altura, anchura), alineacion));
        return content.toString();
    }

    private String getAtributeImg(String ruta, int alto, int ancho) {
        StringBuilder contenido = new StringBuilder();
        contenido.append("<img src=");
        contenido.append("\"");
        contenido.append(ruta);
        contenido.append("\" ");
        contenido.append("width=");
        contenido.append("\"");
        contenido.append(ancho);
        contenido.append("\" ");
        contenido.append("height=");
        contenido.append("\"");
        contenido.append(alto);
        contenido.append("\" ");
        contenido.append(">\n");
        return contenido.toString();
    }

    public String createVideo(String ruta, int altura, int ancho) {
        StringBuilder content = new StringBuilder();
        // src="D:\Películas y series\laland.mkv" height="320" width="320" controls></video>
        content.append("<video ");
        content.append("src=\"");
        content.append(ruta);
        content.append("\" ");
        content.append("height=\"");
        content.append(altura);
        content.append("\" ");
        content.append("width=\"");
        content.append(ancho);
        content.append("\" ");
        content.append("controls");
        content.append("></video>\n");

        return content.toString();
    }

    public String createMenu(List<Etiqueta> etiquetas, String padre) {
        StringBuilder contenido = new StringBuilder();
        contenido.append("<div>\n");

        try {
            List<Sitio> sitios = (List<Sitio>) archivo.getObjectDatos(Archivo.RUTA_SITIOS);
            Pagina pagina = getPagina(sitios, padre);
            for (int i = 0; i < etiquetas.size(); i++) {
                for (int j = 0; j < pagina.getHijas().size(); j++) {
                    for (int k = 0; k < pagina.getHijas().get(j).getEtiquetas().size(); k++) {
                        Etiqueta e = pagina.getHijas().get(j).getEtiquetas().get(k);
                        if(e.getValor().equals(etiquetas.get(i).getValor())){
                            contenido.append("<a href=\"");
                            contenido.append(pagina.getId());
                            contenido.append("\">");
                            contenido.append("</a>  ");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            System.out.println("no se pudo leer el objeto.");
        }
        contenido.append("</div>");
        return contenido.toString();
    }

    private Pagina getPagina(List<Sitio> sitios, String id) {
        for (int i = 0; i < sitios.size(); i++) {
            for (int j = 0; j < sitios.get(i).getPaginas().size(); j++) {
                if (id.equals(sitios.get(i).getPaginas().get(j).getId())) {
                    return sitios.get(i).getPaginas().get(j);
                }
            }
        }
        return null;
    }

    private String getAlineacion(String text, String alineacion) {
        StringBuilder content = new StringBuilder();
        switch (alineacion) {
            case CENTER -> {
                content.append("<CENTER>\n");
                content.append(text);
                content.append("<CENTER>\n");
            }
            case LEFT -> {
                content.append("<DIV ALIGN=LEFT>\n");
                content.append(text);
                content.append("</DIV>\n");
            }
            case RIGHT -> {
                content.append("<DIV ALIGN=RIGHT>\n");
                content.append(text);
                content.append("</DIV>\n");
            }
            case JUSTIFY -> {
                content.append("<DIV ALIGN=JUSTIFY>\n");
                content.append(text);
                content.append("</DIV>\n");
            }
            default -> {
                content.append(text);
            }
        }
        return content.toString();
    }
}
