package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder_17325089_LizamaNunez {
    private String nameFolder;
    //Revisar
    private String User;
    private Date fechaCreacion;
    private Date fechamodificacion;
    private List<String> atributos;
    private String rutaActual;

    /**
     * TDA constructor Folder
     * @param nameFolder : String nombre folder
     * @param user : String usuario logueado al momento de creacion folder.
     * @param fechaCreacion : Date fecha de creacion folder
     * @param fechamodificacion : Date fecha de modificacion folder
     * @param rutaActual : String ruta actual folder
     */
    public Folder_17325089_LizamaNunez(String nameFolder, String user, Date fechaCreacion, Date fechamodificacion, String rutaActual) {
        this.nameFolder = nameFolder;
        User = user;
        this.fechaCreacion = fechaCreacion;
        this.fechamodificacion = fechamodificacion;
        this.atributos = new ArrayList<>();
        this.rutaActual = rutaActual;
    }
    /**
     * TDA Selector nombre Folder
     * @return : String nombre Folder
     */
    public String getNameFolder() {
        return
                nameFolder;
    }
    /**
     * TDA Selector Ruta actual Folder
     * @return : String ruta actual Folder
     */
    public String getRutaActual() {
        return rutaActual;
    }
    /**
     * TDA Selector fecha creacion Folder
     * @return : Date fecha creacion folder
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * TDA modificador ruta actual Folder
     * @param rutaActual: String ruta actual
     */
    public void setRutaActual(String rutaActual) {
        this.rutaActual = rutaActual;
    }

    /**
     * TDA modificador ruta actual Folder
     * @param nameFolder : String name folder
     */
    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }
    /**
     * Metodo imprime datos guardados en formato String.
     * @return : String datos Folder
     */
    @Override
    public String toString() {
        return "Folder{" +
                "nameFolder='" + nameFolder + '\'' +
                ", User='" + User + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechamodificacion=" + fechamodificacion +
                ", atributos=" + atributos +
                ", rutaActual='" + rutaActual + '\'' +
                '}';
    }


}
