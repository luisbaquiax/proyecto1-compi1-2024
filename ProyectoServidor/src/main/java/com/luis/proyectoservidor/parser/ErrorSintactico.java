package com.luis.proyectoservidor.parser;

public class ErrorSintactico {
    private String cadea;
    private int fila;
    private int columna;
    private String descripcion;

    public ErrorSintactico(String cadea, int fila, int columna, String descripcion) {
        this.cadea = cadea;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }

    public String getCadea() {
        return cadea;
    }

    public void setCadea(String cadea) {
        this.cadea = cadea;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
