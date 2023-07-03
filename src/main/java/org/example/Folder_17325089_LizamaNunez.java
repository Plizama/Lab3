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


    public Folder_17325089_LizamaNunez(String nameFolder, String user, Date fechaCreacion, Date fechamodificacion, String rutaActual) {
        this.nameFolder = nameFolder;
        User = user;
        this.fechaCreacion = fechaCreacion;
        this.fechamodificacion = fechamodificacion;
        this.atributos = new ArrayList<>();
        this.rutaActual = rutaActual;
    }



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

    public String getNameFolder() {
        return nameFolder;
    }

    public String getRutaActual() {
        return rutaActual;
    }

    public void setRutaActual(String rutaActual) {
        this.rutaActual = rutaActual;
    }

    public void setFechas(Date fechamodificacion) {
        this.fechaCreacion = fechamodificacion;
        this.fechamodificacion = fechamodificacion;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }
}
