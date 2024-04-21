package com.luis.proyectoservidor.objetos;

import javax.swing.*;
import java.io.*;

public class Archivo {
    public static final String HTML = ".html";
    public static final String DATOS = ".datos";

    public static final String CARPETA_SITIOS = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/sitios";
    public static final String CARPETA_DATOS = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/datos";
    public static  final String RUTA_SITIOS = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/datos/sitios.data";
    public static  final String RUTA_PAGINAS = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/datos/pages.data";
    public static  final String RUTA_COMPONENTES = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/datos/components.data";
    public static  final String ARCHIVO_XML = "C:/Users/Usuario/Desktop/proyecto1-compi1-2024/datos/archivo.xml";

    public Archivo() {
    }

    public void escribirObjeto(String filepath, Object datos) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(datos);
            objectOut.close();
            System.out.println("Se ha escrito el objeto");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object leerObejtodelAarchivo(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();
            System.out.println("Se ha leido el objeto");
            objectIn.close();
            return obj;

        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public Object getObjectDatos(String path) {
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            Object salida = flujoSalida.readObject();
            flujoSalida.close();
            return salida;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void escribirArchivo(String ruta, String contenido) {
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter escribeArchivo = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(escribeArchivo);
            bw.write(contenido);
            System.out.println("archivo creado");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearCarpeta(String ruta, String nombreCarpeta) throws FileNotFoundException, IOException {
        File carpeta = new File(ruta+File.separator+nombreCarpeta);
        if (carpeta.mkdir()) {
            System.out.println("creado");
            System.out.println(carpeta.getAbsolutePath());
        } else {
            System.out.println("no creado");
            System.out.println(carpeta.getAbsolutePath());
        }
    }
}
