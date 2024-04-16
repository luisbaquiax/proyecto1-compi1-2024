/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.luis.proyectoservidor;


import com.luis.proyectoservidor.lexer.AccionesLexer;
import com.luis.proyectoservidor.objetos.*;
import com.luis.proyectoservidor.parser.AccionesParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ProyectoServidor {

    public static void main(String[] args) {
        /*Servidor servidor = new Servidor();
        servidor.setVisible(true);*/
        /*String contenido = "<ACCIones>\n" +
                "                <accion nombre=\"NUEVO_SITIO_WEB\">\n" +
                "                    <parametros>\n" +
                "                      <parametro nombre=\"ID\">\n" +
                "                                [-pagina1]\n" +
                "                            </parametro>\n" +
                "                      <parametro nombre=\"USUARIO_CREACION\">\n" +
                "                                [-user1]\n" +
                "                            </parametro>\n" +
                "                      <parametro nombre=\"FECHA_CREACION\">\n" +
                "                                [12-12-2]\n" +
                "                            </parametro>\n" +
                "                                \n" +
                "                      <parametro nombre=\"FECHA_MODIFICACION\">\n" +
                "                                 [12-12-12]\n" +
                "                            </parametro>\n" +
                "                      <parametro nombre=\"USUARIO_MODIFICACION\">\n" +
                "                                [-user1]\n" +
                "                            </parametro>\n" +
                "                    </parametros>\n" +
                "                  </accion>\n" +
                "                </acciones>";
        AccionesLexer lexer = new AccionesLexer(new StringReader(contenido));
        AccionesParser parser = new AccionesParser(lexer);
        try {
            parser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        CreadorSitios creador = new CreadorSitios();
        List<Sitio> sitios = new ArrayList<>();
        sitios.add(new Sitio("-hola","-user1","12-12-12","-user1","12-12-12"));
        sitios.add(new Sitio("-hola1","-user2","12-12-12","-user2","12-12-12"));

        List<Pagina> paginas = new ArrayList<>();
        paginas.add(new Pagina("-hola","-user1","12-12-12","-user1","12-12-12"));
        paginas.add(new Pagina("-hola1","-user2","12-12-12","-user2","12-12-12"));

        List<Componente> componentes = new ArrayList<>();
        Titulo titulo = new Titulo("HOLA","CENTRAR","#FF5733");
        Parrafo parrafo =  new Parrafo("  \"Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere, unde. A ratione eos maxime, voluptatem alias, aliquam earum pariatur laudantium hic fugit ipsam. Deserunt reprehenderit perspiciatis veniam, at adipisci recusandae. \"","CENTRAR","#36B039");
        componentes.add(titulo);
        componentes.add(parrafo);
        paginas.get(0).setComponentes(componentes);

        List<Componente> componentes2 = new ArrayList<>();
        Titulo titulo2 = new Titulo("HOLA","CENTRAR","#FF5733");
        Parrafo parrafo2 =  new Parrafo("hola que tal un gusto","CENTRAR","#FF5733");
        componentes2.add(titulo2);
        componentes2.add(parrafo2);
        paginas.get(1).setComponentes(componentes2);

        sitios.get(0).setPaginas(paginas);
        sitios.get(1).setPaginas(paginas);

        try {
            creador.crearCarpetasDeSitios(sitios);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        creador.crearArchivosHtml(sitios);
    }
}
