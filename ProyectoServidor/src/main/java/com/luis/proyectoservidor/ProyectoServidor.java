/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.luis.proyectoservidor;


import com.luis.proyectoservidor.lexer.AccionesLexer;
import com.luis.proyectoservidor.objetos.*;
import com.luis.proyectoservidor.parser.AccionesParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ProyectoServidor {

    public static void main(String[] args) throws IOException {
        /*Servidor servidor = new Servidor();
        servidor.setVisible(true);*/
        String contenido = """
                <Acciones>
                    <accion nombre="BORRAR_COMPONENTE">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                              <parametro nombre="PAGINA">
                                                  [_productos]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_COMPONENTE">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                              <parametro nombre="PAGINA">
                                                  [_productos]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_COMPONENTE">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                              <parametro nombre="PAGINA">
                                                  [_productos]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_SITIO_WEB">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_SITIO_WEB">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_PAGINA">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_PAGINA">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                  </parametros>
                    </accion>
                    <accion nombre="BORRAR_PAGINA">
                                  <parametros>
                                              <parametro nombre="ID">
                                                  [-aaa1]
                                              </parametro>
                                  </parametros>
                    </accion>
                </Acciones>                                
                       """;
        AccionesLexer lexer = new AccionesLexer(new StringReader(contenido));

        /*while (!lexer.yyatEOF()){
            Token token = lexer.yylex();
            System.out.println("lexema:"+token.lexema);
        }*/

       AccionesParser parser = new AccionesParser(lexer);
        try {
            parser.parse();
            List<Componente> componentes = parser.componentes;
            System.out.println("Componentes....");
            for (int i = 0; i < componentes.size(); i++) {
                if(componentes.get(i) instanceof Parrafo titulo){
                    System.out.println(titulo.toString());
                }else if(componentes.get(i) instanceof Titulo pa){
                    System.out.println(pa.toString());
                }else if(componentes.get(i) instanceof Img img){
                    System.out.println(img.toString());
                }else if(componentes.get(i) instanceof Video var){
                    System.out.println(var.toString());
                }
            }
            System.out.println("Modificar componentes....");
            List<Componente> componentes1 = parser.componentesModificacion;
            for (int i = 0; i < componentes1.size(); i++) {
                if(componentes1.get(i) instanceof Parrafo titulo){
                    System.out.println(titulo.toString());
                }else if(componentes1.get(i) instanceof Titulo pa){
                    System.out.println(pa.toString());
                }else if(componentes1.get(i) instanceof Img img){
                    System.out.println(img.toString());
                }else if(componentes1.get(i) instanceof Video var){
                    System.out.println(var.toString());
                }
            }
            System.out.println("Acciones....");
            List<Accion> acciones = parser.acciones;
            for (int i = 0; i < acciones.size(); i++) {
                if(acciones.get(i)instanceof AccionDeletComponent var){
                    System.out.println(var.toString());
                }else if(acciones.get(i) instanceof  AccionDeleteSitio var){
                    System.out.println(var.toString());
                }else if(acciones.get(i) instanceof  AccionDeletePage var){
                    System.out.println(var.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*CreadorSitios creador = new CreadorSitios();
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
        creador.crearArchivosHtml(sitios);*/
    }
}
