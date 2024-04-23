package com.luis.proyectoservidor.objetos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorDatos {
    private CreadorSitios creadorSitios;
    private ControlXml controlXml;

    private List<String> mensajes;

    public ControladorDatos(CreadorSitios creadorSitios) {
        this.creadorSitios = creadorSitios;
        this.controlXml = new ControlXml();
        this.mensajes = new ArrayList<>();
    }

    public void agregarSitios(List<Sitio> sitios, List<Pagina> paginas, List<Componente> componentes) {
        System.out.println("datos...");
        System.out.println(Arrays.toString(sitios.toArray()));
        System.out.println(Arrays.toString(paginas.toArray()));
        System.out.println(Arrays.toString(componentes.toArray()));
        System.out.println("hola 1");
        try {
            List<Sitio> dataSitios = (List<Sitio>) creadorSitios.getArchivo().leerObejtodelAarchivo(Archivo.RUTA_SITIOS);

            //List<Pagina> dataPaginas = (List<Pagina>) creadorSitios.getArchivo().getObjectDatos(Archivo.RUTA_PAGINAS);
            if (dataSitios == null) {
                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_PAGINAS, paginas);

                agregarPaginaASitio(paginas, sitios, componentes);

                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
                crearCarpetaArchivos(sitios);

                controlXml.escrbirXml(sitios);
            } else {
                //agregamos sitios
                for (int i = 0; i < sitios.size(); i++) {
                    if (!existeSitio(sitios.get(i), dataSitios)) {
                        System.out.println("se agrego pagina");
                        dataSitios.add(sitios.get(i));
                    } else {
                        System.out.println("ya existe sitio");
                        mensajes.add("Mensaje-servidor: \tEl id del sitio esta en uso, id repetido: " + sitios.get(i).getId());
                    }
                }
                agregarPaginaASitio(paginas, dataSitios, componentes);
                System.out.println("original...");
                System.out.println(Arrays.toString(sitios.toArray()));
                System.out.println("datasitios...");
                System.out.println(Arrays.toString(dataSitios.toArray()));
                creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, dataSitios);
                crearCarpetaArchivos(dataSitios);

                controlXml.escrbirXml(dataSitios);

                System.out.println("Se han creado as carpetas y sitios");
            }

        } catch (IOException | NullPointerException e) {
            mensajes.add("Mensaje-servidor: \tNO SE PUDO CREAR LOS SITIOS WEB, LO SENTIMOS");
            System.out.println("Mensaje error: " + e.getMessage());
            Logger.getLogger(ControladorDatos.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void ejecutarAciones(List<Accion> acciones) {
            List<Sitio> dataSitios = (List<Sitio>) creadorSitios.getArchivo().leerObejtodelAarchivo(Archivo.RUTA_SITIOS);
            for (int i = 0; i < acciones.size(); i++) {
                if (acciones.get(i) instanceof AccionDeletComponent var) {
                    Pagina p = new Pagina();
                    p.setId(var.getPage());
                    eliminarComponente(var.getComponent(), existePagina(p, dataSitios));
                } else if (acciones.get(i) instanceof AccionDeleteSitio var) {
                    /*try {
                        eliminarSitio(var.getId(), dataSitios);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }*/
                } else if (acciones.get(i) instanceof AccionDeletePage var) {
                    eliminarPagina(var.getIdPage(), dataSitios);
                } else if (acciones.get(i) instanceof AccionModificarPagina var) {
                    for (int j = 0; j < dataSitios.size(); j++) {
                        for (int k = 0; k < dataSitios.get(j).getPaginas().size(); k++) {
                            if (var.getIdPagina().equals(dataSitios.get(j).getPaginas().get(k).getId())) {
                                dataSitios.get(j).getPaginas().get(k).setTitulo(var.getTitulo());
                                List<Etiqueta> etiquetas = new ArrayList<>(var.getEtiquetas());
                                dataSitios.get(j).getPaginas().get(k).setEtiquetas(etiquetas);
                            }
                        }
                    }
                }
            }
            mensajes.add("No se pudo ejecutar la accion");
    }

    public void ejecutarModificarComponente(List<Componente> componentesModificar) {
        List<Sitio> dataSitios = (List<Sitio>) creadorSitios.getArchivo().leerObejtodelAarchivo(Archivo.RUTA_SITIOS);

        if (dataSitios != null) {

            for (int i = 0; i < componentesModificar.size(); i++) {
                for (int j = 0; j < dataSitios.size(); j++) {
                    for (int k = 0; k < dataSitios.get(j).getPaginas().size(); k++) {
                        if (componentesModificar.get(i).getPagina().equals(dataSitios.get(j).getPaginas().get(k).getId())) {
                            List<Componente> auxi = dataSitios.get(j).getPaginas().get(k).getComponentes();
                            for (int l = 0; l < auxi.size(); l++) {
                                if (auxi.get(l).getId().equals(componentesModificar.get(i).getId())) {
                                    Componente remove = dataSitios.get(j).getPaginas().get(k).getComponentes().remove(l);
                                    dataSitios.get(j).getPaginas().get(k).getComponentes().add(componentesModificar.get(i));
                                }
                            }
                        }
                    }
                }
            }
            creadorSitios.crearArchivosHtml(dataSitios);
        } else {
            mensajes.add("No se pudo realizar la accion, no exiten datos.");
        }
    }

    private void agregarPaginaASitio(List<Pagina> paginas, List<Sitio> dataSitios, List<Componente> componentes) {
        //agregamos paginas a sitios
        for (int i = 0; i < paginas.size(); i++) {
            if (existePagina(paginas.get(i), dataSitios) == null) {
                //antes de agregar paginas, agregamos componentes a las paginas
                for (int j = 0; j < componentes.size(); j++) {
                    if (componentes.get(j).getPagina().equals(paginas.get(i).getId())) {
                        if (!existeComponete(componentes.get(j), paginas.get(i).getComponentes())) {
                            System.out.println("se agre componente");
                            paginas.get(i).getComponentes().add(componentes.get(j));
                        }
                    }
                }
                for (int j = 0; j < dataSitios.size(); j++) {
                    if (paginas.get(i).getSitio().equals(dataSitios.get(j).getId())) {
                        System.out.println("se agrega pagina");
                        dataSitios.get(j).getPaginas().add(paginas.get(i));
                    }
                }
            } else {
                mensajes.add("Mensaje-servidor: \tEl id de la pagina web esta en uso, id repetido: " + paginas.get(i).getId());
            }
        }

    }

    private void agregarPaginasHijas(List<Sitio> sitios) {

    }

    private boolean existeSitio(Sitio sitio, List<Sitio> sitios) {
        for (int i = 0; i < sitios.size(); i++) {
            if (sitios.get(i).getId().equals(sitio.getId())) {
                return true;
            }
        }
        return false;
    }

    private Pagina existePagina(Pagina pagina, List<Sitio> sitios) {
        for (int i = 0; i < sitios.size(); i++) {
            List<Pagina> paginas = sitios.get(i).getPaginas();
            for (int j = 0; j < paginas.size(); j++) {
                if (paginas.get(j).getId().equals(pagina.getId())) {
                    return sitios.get(i).getPaginas().get(j);
                }
            }
        }
        return null;
    }

    private boolean existeComponete(Componente comp, List<Componente> componentes) {
        for (int i = 0; i < componentes.size(); i++) {
            if (comp.getId().equals(componentes.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    public void crearCarpetaArchivos(List<Sitio> sitios) throws IOException {
        creadorSitios.crearCarpetasDeSitios(sitios);
        creadorSitios.crearArchivosHtml(sitios);
    }

    public void eliminarSitio(String idSitio, List<Sitio> sitios) throws IOException {
        for (int i = 0; i < sitios.size(); i++) {
            if (sitios.get(i).getId().equals(idSitio)) {
                Sitio remove = sitios.remove(i);
                creadorSitios.eliminarCarpetaOArchivo(Archivo.CARPETA_SITIOS + File.separator + remove.getId());
                break;
            }
        }
        this.creadorSitios.crearCarpetasDeSitios(sitios);
        this.creadorSitios.crearArchivosHtml(sitios);
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }

    public void eliminarPagina(String idPagina, List<Sitio> sitios) {
        for (int i = 0; i < sitios.size(); i++) {
            Sitio sitio = sitios.get(i);
            List<Pagina> paginas = sitios.get(i).getPaginas();
            for (int j = 0; j < paginas.size(); j++) {
                if (paginas.get(j).getId().equals(idPagina)) {
                    Pagina remove = sitios.get(i).getPaginas().remove(j);
                    creadorSitios.eliminarCarpetaOArchivo(
                            Archivo.CARPETA_SITIOS + File.separator + sitio.getId() + File.separator + remove.getId());
                    break;
                }
            }
        }
        //actualizar lista-sitios
        this.creadorSitios.getArchivo().escribirObjeto(Archivo.RUTA_SITIOS, sitios);
        //actualizar xml
        this.controlXml.escrbirXml(sitios);
    }

    public void eliminarComponente(String idComponent, Pagina pagina) {
        for (int i = 0; i < pagina.getComponentes().size(); i++) {
            if (idComponent.equals(pagina.getComponentes().get(i).getId())) {
                pagina.getComponentes().remove(i);
                break;
            }
        }
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
