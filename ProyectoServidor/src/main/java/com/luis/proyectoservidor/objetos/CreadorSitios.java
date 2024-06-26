package com.luis.proyectoservidor.objetos;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CreadorSitios {
    private Archivo archivo;
    private CreadorComponent creadorComponent;

    public CreadorSitios() {
        this.archivo = new Archivo();
        this.creadorComponent = new CreadorComponent();
    }

    public void crearCarpetasDeSitios(List<Sitio> sitios) throws IOException {
        for (int i = 0; i < sitios.size(); i++) {
            archivo.crearCarpeta(Archivo.CARPETA_SITIOS, sitios.get(i).getId());
        }
    }

    public void crearArchivosHtml(List<Sitio> sitios) {
        System.out.println("creando html...");
        for (int i = 0; i < sitios.size(); i++) {
            System.out.println("creando htmls...");
            crearPaginas(sitios.get(i));
        }
        for (int i = 0; i < sitios.size(); i++) {
            String ruta = Archivo.CARPETA_SITIOS
                    + File.separator
                    + sitios.get(i).getId()
                    + File.separator + "index" + Archivo.HTML;
            archivo.escribirArchivo(ruta, escribirIndexHtml(sitios.get(i)));
        }
    }

    private String escribirIndexHtml(Sitio sitio) {
        String html = "";
        html += "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Sitio" + sitio.getId() + "</title>\n" +
                "</head>\n" +
                "<body>\n";
        html += "<h1>Paginas</h1>";
                
        for (int i = 0; i < sitio.getPaginas().size(); i++) {
            html += "<a href=\"" + sitio.getPaginas().get(i).getId() + ".html\"></a>\n";
        }
        html += "</body>\n" +
                "</html>";
        return html;
    }

    public void crearPaginas(Sitio sitio) {
        List<Pagina> paginas = sitio.getPaginas();

        for (int i = 0; i < paginas.size(); i++) {
            String ruta = Archivo.CARPETA_SITIOS
                    + File.separator
                    + sitio.getId()
                    + File.separator
                    + paginas.get(i).getId()
                    + Archivo.HTML;
            List<Componente> components = paginas.get(i).getComponentes();
            //System.out.println(Arrays.toString(components.toArray()));
            archivo.escribirArchivo(ruta, webHmtml(paginas.get(i), createComponents(components)));
        }
    }

    private String webHmtml(Pagina sitio, String componentes) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"en\">\n");
        html.append("<head>\n");
        html.append("<meta charset=\"UTF-8\">\n");
        html.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("<title>");
        html.append(sitio.getId());
        html.append("</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append(componentes);
        html.append("</body>\n");
        html.append("</html>\n");
        return html.toString();
    }

    public String createComponents(List<Componente> components) {
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i) instanceof Menu menu) {
                contenido.append(creadorComponent.createMenu(menu.getEtiquetas(), menu.getPadre()));
            } else if (components.get(i) instanceof Titulo titulo) {
                contenido.append(creadorComponent.crearTituloParrafo(titulo.getTexto(), titulo.getAlineacion(), titulo.getColor()));
            } else if (components.get(i) instanceof Parrafo parrafo) {
                contenido.append(creadorComponent.crearTituloParrafo(parrafo.getTexto(), parrafo.getAlineacion(), parrafo.getColor()));
            } else if (components.get(i) instanceof Img img) {
                contenido.append(creadorComponent.crearImg(img.getRuta(), img.getAlineacion(), img.getAltura(), img.getAnchura()));
            } else if (components.get(i) instanceof Video video) {
                contenido.append(creadorComponent.createVideo(video.getRuta(), video.getAltura(), video.getAnchura()));
            }
        }
        return contenido.toString();
    }

    public void eliminarCarpetaOArchivo(String ruta) {
        File fileDelete = new File(ruta);
        if (fileDelete.isDirectory()) {
            File[] files = fileDelete.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
            fileDelete.delete();
        } else {
            if (fileDelete.delete()) {
            } else {
                System.out.println("no se pudo eleminar el archivo");
            }
        }
    }

    public Archivo getArchivo() {
        return archivo;
    }
}
