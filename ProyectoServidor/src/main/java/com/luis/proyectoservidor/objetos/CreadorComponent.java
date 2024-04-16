package com.luis.proyectoservidor.objetos;

public class CreadorComponent {

    public static final String CENTER = "CENTRAR";
    public static final String LEFT = "IZQUIERDA";
    public static final String RIGHT = "DERECHA";
    public static final String JUSTIFY = "JUSTIFICAR";

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

    public String crearImg(String ruta, String alineacion, int altura, int anchura){
        StringBuilder content = new StringBuilder();
        content.append(getAlineacion(getAtributeImg(ruta,altura,anchura),alineacion));
        return content.toString();
    }

    private String getAtributeImg(String ruta, int alto, int ancho){
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

    public String createVideo(String ruta, int altura, int ancho){
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

        return  content.toString();
    }

    private String getAlineacion(String text, String alineacion){
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
        return  content.toString();
    }
}
