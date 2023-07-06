package org.example;

import java.util.Date;
import java.util.List;

public abstract class FileAbs_17325089_LizamaNunez {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String contenido;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;
    private List<String> atributos;


    /**
     * Metodo Abstracto indica tipo de archivo a partir de la extension indicada en el nombre.
     * @return
     */
    public abstract String obtenerTipodeArchivo();

    /**
     * Metodo Abstracto TDA selector nombre archivo.
     * @return
     */
    public abstract String getNameFile();

    /**
     * Metodo Abstracto TDA selector ubicacion archivo.
     * @return
     */
    public abstract String getUbicacion();

    /**
     * Metodo Abstracto TDA selector extension archivo.
     * @return
     */
    public abstract String getExtension();

    /**
     * Metodo Abstracto TDA selector Fecha creacion archivo.
     * @return
     */
    public abstract Date getFechaCreacion();

    /**
     * Metodo Abstracto TDA selector atributos archivo.
     * @return
     */
    public abstract List<String>getAtributos();

    /**
     * Metodo Abstracto TDA selector Contenido archivo.
     * @return
     */
    public abstract String getContenido();

    /**
     * Metodo Abstracto TDA modificador ubicacion archivo.
     * @param ubicacion : String nueva ruta archivo
     */
    public abstract void setUbicacion(String ubicacion);

    /**
     * Metodo Abstracto TDA modificador Fecha creacion archivo.
     * @param nuevaFecha : Date nueva fecha de creacion archivo
     */
    public abstract void setFechaCreacion(Date nuevaFecha);

    /**
     * Metodo Abstracto TDA modificador nombre archivo.
     * @param newNameFile : String nuevo nombre archivo
     */
    public abstract void setNameFile(String newNameFile);

    /**
     * Metodo Abstracto TDA modificador contenido archivo.
     * @param contenido : String contenido archivo
     */
    public abstract void setContenido(String contenido);



}


