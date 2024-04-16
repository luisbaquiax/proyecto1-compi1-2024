package com.luis.proyectoservidor.lexer;

public class ErrorLexico {
    private String description;
    private int fila;
    private int columna;

    public ErrorLexico(String description, int fila, int columna) {
        this.description = description;
        this.fila = fila;
        this.columna = columna;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
