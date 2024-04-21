package com.luis.proyectoservidor.lexer;

public class Token {
    public String lexema;
    public Type tipoToken;

    public Token(Type tipoToken,String lexema) {
        this.lexema = lexema;
        this.tipoToken = tipoToken;
    }

}