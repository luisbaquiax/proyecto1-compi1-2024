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
                                <accion nombre="NUEVO_SITIO_WEB">
                                                    <parametros>
                                                      <parametro nombre="ID">
                                                                [-pagina1]
                                                            </parametro>
                                                      <parametro nombre="USUARIO_CREACION">
                                                                [-user1]
                                                            </parametro>
                                                      <parametro nombre="FECHA_CREACION">
                                                                [2024-12-22]
                                                            </parametro>
                                                      <parametro nombre="FECHA_MODIFICACION">
                                                                 [2024-12-12]
                                                            </parametro>
                                                      <parametro nombre="USUARIO_MODIFICACION">
                                                                [-user1]
                                                            </parametro>
                                                    </parametros>
                                                  </accion>
                                                  <accion nombre="AGREGAR_COMPONENTE">
                                                          <parametros>
                                                                      <parametro nombre="ID">
                                                                          [-comp1]
                                                                      </parametro>
                                                                      <parametro nombre="PAGINA">
                                                                          [-productos]
                                                                      </parametro>
                                                                      <parametro nombre="CLASE">
                                                                          [TITULO]
                                                                      </parametro>
                                                          </parametros>
                                                          <atributos>
                                                                  <atributo nombre="TEXTO">
                                                                  [\"Este es el texto que aparece en el titulo :) \"]
                                                              </atributo>
                                                              <atributo nombre="ALINEACION">
                                                                  [DERECHA]
                                                              </atributo>
                                                                  <atributo nombre="COLOR">
                                                                  [#5A5A5A]
                                                              </atributo>
                                                          </atributos>
                                                      </accion>
                                                      <accion nombre="AGREGAR_COMPONENTE">
                                                          <parametros>
                                                                      <parametro nombre="ID">
                                                                          [-comp1]
                                                                      </parametro>
                                                                      <parametro nombre="PAGINA">
                                                                          [-productos]
                                                                      </parametro>
                                                                      <parametro nombre="CLASE">
                                                                          [TITULO]
                                                                      </parametro>
                                                          </parametros>
                                                          <atributos>
                                                                  <atributo nombre="TEXTO">
                                                                  [Este es el texto que aparece en el titulo :) ]
                                                              </atributo>
                                                              <atributo nombre="ALINEACION">
                                                                  [DERECHA]
                                                              </atributo>
                                                                  <atributo nombre="COLOR">
                                                                  [#5A5A5A]
                                                              </atributo>
                                                          </atributos>
                                                      </accion>
                                                      <accion nombre="AGREGAR_COMPONENTE">
                                                          <parametros>
                                                                      <parametro nombre="ID">
                                                                          [-comp1]
                                                                      </parametro>
                                                                      <parametro nombre="PAGINA">
                                                                          [-productos]
                                                                      </parametro>
                                                                      <parametro nombre="CLASE">
                                                                          [PARRAFO]
                                                                      </parametro>
                                                          </parametros>
                                                          <atributos>
                                                                  <atributo nombre="TEXTO">
                                                                  [Este es el texto que aparece en el titulo :) ]
                                                              </atributo>
                                                              <atributo nombre="ALINEACION">
                                                                  [DERECHA]
                                                              </atributo>
                                                                  <atributo nombre="COLOR">
                                                                  [#5A5A5A]
                                                              </atributo>
                                                          </atributos>
                                                      </accion>
                                                     \s
                                                        <accion nombre="AGREGAR_COMPONENTE">
                                                              <parametros>
                                                                          <parametro nombre="ID">
                                                                              [-aaa1]
                                                                          </parametro>
                                                                          <parametro nombre="PAGINA">
                                                                              [_productos]
                                                                          </parametro>
                                                                          <parametro nombre="CLASE">
                                                                              [IMAGEN]
                                                                          </parametro>
                                                              </parametros>
                                                              <atributos>
                                                                             <atributo nombre="ANCHO">
                                                                      [12]
                                                                      </atributo>
                                                                      <atributo nombre="ALINEACION">
                                                                      [CENTRAR]
                                                                      </atributo>
                                                                      <atributo nombre="ORIGEN">
                                                                      [soy url]
                                                                      </atributo>
                                                                     \s
                                                                  <atributo nombre="ALTURA">
                                                                      [12]
                                                                      </atributo>
                                                              \s
                                                              </atributos>
                                                        </accion>
                                                         <accion nombre="AGREGAR_COMPONENTE">
                                                             <parametros>
                                                                         <parametro nombre="ID">
                                                                             [-aaa1]
                                                                         </parametro>
                                                                         <parametro nombre="PAGINA">
                                                                             [_productos]
                                                                         </parametro>
                                                                         <parametro nombre="CLASE">
                                                                             [VIDEO]
                                                                         </parametro>
                                                             </parametros>
                                                             <atributos>
                                                                     <atributo nombre="ORIGEN">
                                                                     [ url]
                                                                     </atributo>
                                                                 <atributo nombre="ALTURA">
                                                                     [12]
                                                                     </atributo>
                                                                     <atributo nombre="ANCHO">
                                                                     [12]
                                                                     </atributo>
                                                             </atributos>
                                                       </accion>  \s
                                                      <accion nombre="MODIFICAR_COMPONENTE">
                                                          <parametros>
                                                                      <parametro nombre="ID">
                                                                          [-aaa1]
                                                                      </parametro>
                                                                      <parametro nombre="PAGINA">
                                                                          [_productos]
                                                                      </parametro>
                                                                      <parametro nombre="CLASE">
                                                                          [VIDEO]
                                                                      </parametro>
                                                          </parametros>
                                                          <atributos>
                                                                <atributo nombre="ANCHO">
                                                                  [12]
                                                                  </atributo>
                                                                 \s
                                                              <atributo nombre="ALTURA">
                                                                  [12]
                                                                  </atributo>
                                                              <atributo nombre="ORIGEN">
                                                                  [ url]
                                                                  </atributo>                                 \s
                                                          </atributos>
                                                    </accion>
                                                        <accion nombre="MODIFICAR_COMPONENTE">
                                                              <parametros>
                                                                          <parametro nombre="ID">
                                                                              [-aaa1]
                                                                          </parametro>
                                                                          <parametro nombre="PAGINA">
                                                                              [_productos]
                                                                          </parametro>
                                                                          <parametro nombre="CLASE">
                                                                              [IMAGEN]
                                                                          </parametro>
                                                              </parametros>
                                                              <atributos>
                                                                             <atributo nombre="ANCHO">
                                                                      [12]
                                                                      </atributo>
                                                                      <atributo nombre="ALINEACION">
                                                                      [CENTRAR]
                                                                      </atributo>
                                                                      <atributo nombre="ORIGEN">
                                                                      [ -idPadre]
                                                                      </atributo>
                                                                     \s
                                                                  <atributo nombre="ALTURA">
                                                                      [12]
                                                                      </atributo>
                                                              \s
                                                              </atributos>
                                                        </accion>   \s
                                        <accion nombre="AGREGAR_COMPONENTE">
                                              <parametros>
                                                          <parametro nombre="ID">
                                                              [-aaa1]
                                                          </parametro>
                                                          <parametro nombre="PAGINA">
                                                              [_productos]
                                                          </parametro>
                                                          <parametro nombre="CLASE">
                                                              [IMAGEN]
                                                          </parametro>
                                              </parametros>
                                              <atributos>
                                                             <atributo nombre="ANCHO">
                                                      [12]
                                                      </atributo>
                                                      <atributo nombre="ALINEACION">
                                                      [CENTRAR]
                                                      </atributo>
                                                      <atributo nombre="ORIGEN">
                                                      [soy url]
                                                      </atributo>
                                                  <atributo nombre="ALTURA">
                                                      [12]
                                                      </atributo>
                                              </atributos>
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
                    
                      <accion nombre="NUEVO_SITIO_WEB">
                        <parametros>
                          <parametro nombre="ID">
                                    [-pagina1]
                                </parametro>
                          <parametro nombre="USUARIO_CREACION">
                                    [-user1]
                                </parametro>
                          <parametro nombre="FECHA_CREACION">
                                    [2024-12-02]
                                </parametro>
                          <parametro nombre="FECHA_MODIFICACION">
                                     [2024-12-12]
                                </parametro>
                          <parametro nombre="USUARIO_MODIFICACION">
                                    [-user1]
                                </parametro>
                        </parametros>
                      </accion>
                    
                      <accion nombre="NUEVO_SITIO_WEB">
                        <parametros>
                          <parametro nombre="ID">
                                    [-pagina1]
                                </parametro>
                          <parametro nombre="USUARIO_CREACION">
                                    [-user1]
                                </parametro>
                          <parametro nombre="FECHA_CREACION">
                                    [2024-12-02]
                                </parametro>
                          <parametro nombre="FECHA_MODIFICACION">
                                     [2024-12-12]
                                </parametro>
                          <parametro nombre="USUARIO_MODIFICACION">
                                    [-user2]
                                </parametro>
                        </parametros>
                      </accion>
                        <accion nombre="NUEVA_PAGINA">
                          <parametros>
                            <parametro nombre="ID">
                                      [-PAGINA1]
                                  </parametro>
                            <parametro nombre="TITULO">
                                      [PAGINA1]
                                  </parametro>
                            <parametro nombre="SITIO">
                                       [-PAGINA1]
                                  </parametro>
                            <parametro nombre="PADRE">
                                       [-PAGINA1]
                                  </parametro>
                            <parametro nombre="USUARIO_CREACION">
                                     [-PAGINA1]
                                  </parametro>
                            <parametro nombre="FECHA_CREACION">
                                      [2024-12-12]
                                  </parametro>
                            <parametro nombre="FECHA_MODIFICACION">
                                      [2024-01-12]
                                  </parametro>
                            <parametro nombre="USUARIO_MODIFICACION">
                                      [-PAGINA1]
                                  </parametro>
                                </parametros>
                            <etiquetas>
                              <etiqueta valor="-etiqueta1"/>
                            </etiquetas>
                        </accion>
                      <accion nombre="MODIFICAR_PAGINA">
                          <parametros>
                                <parametro nombre="ID">
                                      [-producto]
                                  </parAmetRo>
                                  <parametro nombre="TITULO">
                                      [nuevo titulo]
                                  </parametro>
                          </parametros>
                          <etiquetas>
                                    <etiqueta valor="-nuevaetiqueta1"/>
                                    <etiqueta valor="-nuevaetiqueta2"/>
                          </etiquetas>
                      </accion>
                      
                   <accion nombre="AGREGAR_COMPONENTE">
                 	<parametros>
                           		<parametro nombre="ID">
                               		[-aaa1]
                         		</parametro>
                           		<parametro nombre="PAGINA">
                               		[_productos]
                         		</parametro>
                           		<parametro nombre="CLASE">
                               		[MENU]
                         		</parametro>
                 	</parametros>
                  	<atributos>
                     		<atributo nombre="PADRE">
                               [-idPadre]
                             </atributo>
                            <atributo nombre="ETIQUETAS">
                               [-pagina]
                             </atributo>
                 	</atributos>
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
            System.out.println("sitios....");
            List<Sitio> sitios = parser.sitios;
            for (int i = 0; i < sitios.size(); i++) {
                System.out.println(sitios.get(i).toString());
            }
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
                }else if(componentes.get(i) instanceof Menu var){
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
                }else if(acciones.get(i) instanceof  AccionModificarPagina var){
                    System.out.println(var.toString());
                }
            }
            System.out.println("paginas....");
            List<Pagina> paginas = parser.paginas;
            for (int i = 0; i < paginas.size(); i++) {
                System.out.println(paginas.toString());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
