package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileDoc_17325089_LizamaNunez extends FileAbs_17325089_LizamaNunez {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String contenido;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;
    private List<String> atributos;

    public FileDoc_17325089_LizamaNunez(String nameFile, String extension, String user, Date fechaCreacion, String ubicacion) {
        this.nameFile = nameFile;
        this.extension = extension;
        this.tipoDeArchivo = obtenerTipodeArchivo();
        this.contenido = "";
        this.user = user;
        this.fechaCreacion = fechaCreacion;
        this.ubicacion = ubicacion;
        this.atributos = new ArrayList<>();
    }

    /**
     * Metodo indica tipo de archivo a partir de la extension indicada en el nombre.
     * @return : String tipo de archivo
     */
    @Override
    public String obtenerTipodeArchivo() {
        return "Archivo de documento";
    }
    /**
     * Metodo TDA selector nombre archivo.
     * @return : String nombre Archivo
     */
    @Override
    public String getNameFile() {
        return nameFile;
    }
    /**
     * Metodo TDA selector ubicacion archivo.
     * @return : String ruta ubicacion archivo
     */
    @Override
    public String getUbicacion() {
        return ubicacion;
    }
    /**
     * Metodo TDA selector extension archivo.
     * @return : String extension archivo
     */
    @Override
    public String getExtension() {
        return extension;
    }
    /**
     * Metodo TDA selector Fecha creacion archivo.
     * @return : Date fehca de creacion archivo
     */
    @Override
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    /**
     * Metodo TDA selector atributos archivo.
     * @return : ArrayList de String con atributos de archivos
     */
    @Override
    public List<String> getAtributos() {
        return atributos;
    }
    /**
     * Metodo TDA selector Contenido archivo.
     * @return : String contenido de archivo
     */
    @Override
    public String getContenido() {
        return contenido;
    }
    /**
     * Metodo TDA modificador ubicacion archivo.
     * @param ubicacion : String nueva ruta archivo
     */
    @Override
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    /**
     * Metodo TDA modificador Fecha creacion archivo.
     * @param nuevaFecha : Date nueva fecha de creacion archivo
     */
    @Override
    public void setFechaCreacion(Date nuevaFecha) {
        this.fechaCreacion = nuevaFecha;
    }
    /**
     * Metodo TDA modificador nombre archivo.
     * @param newNameFile : String nuevo nombre archivo
     */
    @Override
    public void setNameFile(String newNameFile) {
        this.nameFile = newNameFile;
    }
    /**
     * Metodo TDA modificador contenido archivo.
     * @param contenido : String contenido archivo
     */
    @Override
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Metodo imprime datos guardados en formato String.
     * @return : String datos File
     */
    @Override
    public String toString() {
        return "FileDoc_17325089_LizamaNunez{" +
                "nameFile='" + nameFile + '\'' +
                ", extension='" + extension + '\'' +
                ", tipoDeArchivo='" + tipoDeArchivo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", user='" + user + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ubicacion='" + ubicacion + '\'' +
                ", atributos=" + atributos +
                '}';
    }
}
