
/* codigo de usuario */
package com.luis.proyectoservidor.lexer;
import com.luis.proyectoservidor.parser.sym;
import java.util.*;
import java.io.StringReader;

import java_cup.runtime.*;

%% //separador de area

%class AccionesLexer
%public
%cup
%full
%line
%column
%char

LineTerminator = \r|\n|\r\n

WhiteSpace = {LineTerminator} | [ \t\f]

/* expresiones regulares */
entero = [0-9]+
//simbolo =[\-\_\$]

id = [\-\_\$][A-Za-z0-9]+
otrosId = id(\\|id)*
fecha = [1-2][0-9][0-9][0-9][\-][0-1][0-9][\-][0-9][0-9]
cadena=\"[^\"]*\"
color_hexagonal =[\#][0-9a-fA-F]{6}

%{

  StringBuffer texto = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  private Symbol symbol(int type, Object value, int row, int col) {
      return new Symbol(type, row+1, col+1, value);
    }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }

%}

%state VALOR_CORCHETES

%% // separador de areas

/* reglas lexicas */
 <YYINITIAL> {



[aA][cC][cC][iI][oO][nN][eE][sS] {
    System.out.println(yytext());
    return symbol(sym.ACCIONES, yytext());
}

[aA][cC][cC][iI][oO][nN] {
    System.out.println(yytext());
    return symbol(sym.ACCION, yytext());
}

[pP][aA][rR][aA][mM][eE][tT][rR][oO][sS] {
    System.out.println(yytext());
    return symbol(sym.PARAMETROS, yytext());
}

[pP][aA][rR][aA][mM][eE][tT][rR][oO] {
    System.out.println(yytext());
    return symbol(sym.PARAMETRO, yytext());
}

[nN][oO][mM][bB][rR][eE] {
    System.out.println(yytext());
    return symbol(sym.NOMBRE, yytext());
}

[vV][aA][lL][oO][rR] {
    System.out.println(yytext());
    return symbol(sym.VALOR, yytext());
}

[eE][tT][iI][qQ][uU][eE][tT][aA] {
    System.out.println(yytext());
    return symbol(sym.ETIQUETA, yytext());
}

[eE][tT][iI][qQ][uU][eE][tT][aA][sS] {
    System.out.println(yytext());

    return symbol(sym.ETIQUETAS, yytext());
}

[aA][tT][rR][iI][bB][uU][tT][oO][sS] {
    System.out.println(yytext());
    return symbol(sym.ATRIBUTOS, yytext());
}

[aA][tT][rR][iI][bB][uU][tT][oO] {
    System.out.println(yytext());
    return symbol(sym.ATRIBUTO, yytext());
}
    "\"" {
         System.out.println(yytext());
         return symbol(sym.COMILLA, yytext());
    }

    "\|" {
        System.out.println(yytext());
        return symbol(sym.BARRA, yytext());        
    }

    "<"                             {
                                    System.out.println(yytext());
                                    return symbol(sym.MENOR, yytext());
                                    }

    "</"                             {
                                    System.out.println(yytext());
                                    return symbol(sym.CERRAR, yytext());
                                    }

    ">"                             {
                                     System.out.println(yytext());
                                    return symbol(sym.MAYOR, yytext());
                                    }

    "="                             {
                                     System.out.println(yytext());
                                    return symbol(sym.IGUAL, yytext());
                                    }

    "\/"                            {
                                    System.out.println(yytext());
                                    return symbol(sym.DIAGONAL, yytext());
                                    }

    "\"NUEVO_SITIO_WEB\""	        {
                                     System.out.println(yytext());
                                    return symbol(sym.ACCION_NUEVO_SITIO, yytext());
                                    }

    "\"ID\""	                    {
                                     System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_ID, yytext());
                                    }

    "\"USUARIO_CREACION\""	        {
                                     System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_USUARIO_CREACION, yytext());
                                    }

    "\"FECHA_CREACION\""	        {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_FECHA_CREACION, yytext());
                                    }

    "\"FECHA_MODIFICACION\""	    {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_FECHA_MODIFICACION, yytext());
                                    }

    "\"USUARIO_MODIFICACION\""	    {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_USUARIO_MODIFICACION, yytext());
                                    }

    "\"BORRAR_SITIO_WEB\""	        {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_BORRAR_SITIO_WEB, yytext());
                                    }

    "\"NUEVA_PAGINA\""	            {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_NUEVA_PAGINA, yytext());
                                    }

    "\"TITULO\""	                {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_TITULO, yytext());
                                    }

    "\"SITIO\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_SITIO, yytext());
                                    }

    "\"PADRE\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_PADRE, yytext());
                                    }

    "\"BORRAR_PAGINA\""	            {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_BORRAR_PAGINA, yytext());
                                    }

    "\"MODIFICAR_PAGINA\""	        {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_MODIFICAR_PAGINA, yytext());
                                    }

    "\"AGREGAR_COMPONENTE\""	    {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_AGREGAR_COMPONENTE, yytext());
                                    }

    "\"MODIFICAR_COMPONENTE\""	    {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_MODIFICAR_COMPONENTE, yytext());
                                    }

    "\"PAGINA\""	                {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_PAGINA, yytext());
                                    }

    "\"CLASE\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.PARAMETRO_CLASE, yytext());
                                    }

    "\"BORRAR_COMPONENTE\""	        {
                                    System.out.println(yytext());
                                    return symbol(sym.ACCION_BORRAR_COMPONENTE, yytext());
                                    }

    "\"TEXTO\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_TEXTO, yytext());
                                    }

    "\"ALINEACION\""	            {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_ALINEACION, yytext());
                                    }

    "\"COLOR\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_COLOR, yytext());
                                    }



    "\"ORIGEN\""	                {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_ORIGEN, yytext());
                                    }

    "\"ALTURA\""	                {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_ALTURA, yytext());
                                    }

    "\"ANCHO\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_ANCHO, yytext());
                                    }

    "\"ETIQUETAS\""	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.ATRIBUTO_ETIQUETAS, yytext());
                                    }

    "\["                            {
                                    texto.setLength(0); yybegin(VALOR_CORCHETES);
                                    }

    {id}                            {
                                    System.out.println(yytext());
                                    return symbol(sym.IDENTIFICADOR, yytext());
                                    }

    /*{cadena} {
         System.out.println(yytext());
         return symbol(sym.CADENA, yytext());
    }*/

    {WhiteSpace} 	                {/* ignoramos */}

 }

<VALOR_CORCHETES>{

    {cadena}                        {
                                    System.out.println(yytext());
                                    return symbol(sym.CADENA, yytext());
                                    }

    {entero}                        {
                                    System.out.println(yytext());
                                    return symbol(sym.NUMERO, yytext());
                                    }

    {fecha}                         {
                                    System.out.println(yytext());
                                    return symbol(sym.FECHA, yytext());
                                    }

    {color_hexagonal}               {
                                    System.out.println(yytext());
                                    return symbol(sym.COLOR_HEXAGONAL, yytext());
                                    }

    {id}                            {
                                    System.out.println(yytext());
                                    return symbol(sym.IDENTIFICADOR, yytext());
                                    }


    "VIDEO"	                        {
                                    System.out.println(yytext());
                                    return symbol(sym.COMPONENTE_VIDEO, yytext());
                                    }

    "MENU"	                        {
                                    //System.out.println(yytext());
                                    return symbol(sym.COMPONENTE_MENU, yytext());
                                    }

    "PARRAFO"	                    {
                                    //System.out.println(yytext());
                                    return symbol(sym.COMP_PARRAFO, yytext());
                                    }

    "IMAGEN"	                    {
                                    //System.out.println(yytext());
                                    return symbol(sym.COMPONENTE_IMAGEN, yytext());
                                    }

    "TITULO"	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.COMP_TITULO, yytext());
                                    }

    "CENTRAR"	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.VALOR_ALINEACION, yytext());
                                    }

    "IZQUIERDA"	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.VALOR_ALINEACION, yytext());
                                    }

    "DERECHA"	                    {
                                    System.out.println(yytext());
                                    return symbol(sym.VALOR_ALINEACION, yytext());
                                    }

    "JUSTIFICAR"	                {
                                    System.out.println(yytext());
                                    return symbol(sym.VALOR_ALINEACION, yytext());
                                    }

    {id}                            {
                                    System.out.println(yytext());
                                    return symbol(sym.IDENTIFICADOR, yytext());
                                    }

    /*{otrosId}                       {
                                    System.out.println(yytext());
                                    return symbol(sym.IDES, yytext());
                                    }*/

[-|a-z|A-Z|0-9|\"|-|_| |/|#|$|@|!|%|&|*|(|)|.|,|-|=|+|:|\/\/||]+         { texto.append(yytext());}
               \\t                          { texto.append('\t'); }
               \\n                          { texto.append('\n'); }
               \\r                          { texto.append('\r'); }
               \\\"                         { texto.append('\"'); }
               \\                           { texto.append('\\'); }
               \]                           { 
                    
                    yybegin(YYINITIAL);
                    if(!texto.toString().isBlank()){
                        System.out.println(texto.toString());
                        return symbol(sym.TEXTO, texto.toString());
                    }
                }

}

/* error fallback */
[^]                              { System.out.println("Simbolo invalido: "+yytext()); }

<<EOF>>                 { return symbol(sym.EOF, ""); }
