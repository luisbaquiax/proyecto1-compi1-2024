package com.luis.proyectoservidor.objetos;

import com.luis.proyectoservidor.lexer.AccionesLexer;
import com.luis.proyectoservidor.parser.AccionesParser;
import java_cup.runtime.Symbol;

import java.io.StringReader;
import java.util.List;

public class Enlace {

    private Mensaje mensaje;
    private ControladorDatos controladorDatos;
    private CreadorSitios creadorSitios;

    private String avisos;

    public Enlace(Mensaje mensaje) {
        this.mensaje = mensaje;
        this.creadorSitios = new CreadorSitios();
        this.controladorDatos = new ControladorDatos(creadorSitios);
    }

    public void validarAciones() {
        if (mensaje.getTipo().equals(Mensaje.ACCION)) {
            runAcciones();
        } else if (mensaje.getTipo().equals(Mensaje.CONSULTA)) {
            runConsultas();
        }
    }

    public void runAcciones() {
        AccionesLexer lexer = new AccionesLexer(new StringReader(mensaje.getContenido()));
        AccionesParser parser = new AccionesParser(lexer);
        try {
            parser.parse();
            System.out.println("sitios....");
            List<Sitio> sitios = parser.sitios;
            for (int i = 0; i < sitios.size(); i++) {
                System.out.println(sitios.get(i).toString());
            }
            List<Componente> componentes = parser.componentes;
            System.out.println("Componentes....");
            for (int i = 0; i < componentes.size(); i++) {
                if (componentes.get(i) instanceof Parrafo titulo) {
                    System.out.println(titulo.toString());
                } else if (componentes.get(i) instanceof Titulo pa) {
                    System.out.println(pa.toString());
                } else if (componentes.get(i) instanceof Img img) {
                    System.out.println(img.toString());
                } else if (componentes.get(i) instanceof Video var) {
                    System.out.println(var.toString());
                } else if (componentes.get(i) instanceof Menu var) {
                    System.out.println(var.toString());
                }
            }
            System.out.println("Modificar componentes....");
            List<Componente> componentesModificacion = parser.componentesModificacion;
            for (int i = 0; i < componentesModificacion.size(); i++) {
                if (componentesModificacion.get(i) instanceof Parrafo titulo) {
                    System.out.println(titulo.toString());
                } else if (componentesModificacion.get(i) instanceof Titulo pa) {
                    System.out.println(pa.toString());
                } else if (componentesModificacion.get(i) instanceof Img img) {
                    System.out.println(img.toString());
                } else if (componentesModificacion.get(i) instanceof Video var) {
                    System.out.println(var.toString());
                }
            }
            System.out.println("Acciones....");
            List<Accion> acciones = parser.acciones;
            for (int i = 0; i < acciones.size(); i++) {
                if (acciones.get(i) instanceof AccionDeletComponent var) {
                    System.out.println(var.toString());
                } else if (acciones.get(i) instanceof AccionDeleteSitio var) {
                    System.out.println(var.toString());
                } else if (acciones.get(i) instanceof AccionDeletePage var) {
                    System.out.println(var.toString());
                } else if (acciones.get(i) instanceof AccionModificarPagina var) {
                    System.out.println(var.toString());
                }
            }
            System.out.println("paginas....");
            List<Pagina> paginas = parser.paginas;
            for (int i = 0; i < paginas.size(); i++) {
                System.out.println(paginas.toString());
            }
            controladorDatos.agregarSitios(sitios, paginas, componentes);


            //establecer mensaje
            avisos += "LISTADO DE TOKENS\n";
            while (!lexer.yyatEOF()) {
                Symbol simbol = lexer.next_token();
                avisos += "LEXEMA: " + simbol.value.toString() + "\tFila: " + simbol.left + "\tColumna: " + simbol.right + "\n";
            }
            avisos += "\n";

            //mensajes del analizador sintacito
            if (!parser.mensajes.isEmpty()) {
                avisos += "ADVERTENCIAS!!!\n";
                for (int i = 0; i < parser.mensajes.size(); i++) {
                    avisos += parser.mensajes.get(i) + "\n";
                }
                avisos += "\n";
            }

            //agregar mensajes del controlador de datos
            avisos += "MENSAJES DEL SERVIDOR\n";
            for (int i = 0; i < controladorDatos.getMensajes().size(); i++) {
                avisos += controladorDatos.getMensajes().get(i) + "\n";
            }
            avisos += "\n";

            controladorDatos.ejecutarAciones(acciones);
            controladorDatos.ejecutarModificarComponente(componentesModificacion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runConsultas() {

    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }
}
