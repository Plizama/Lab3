package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileCod_17325089_LizamaNunez extends FileAbs_17325089_LizamaNunez {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;
    private List<String> atributos;

    public FileCod_17325089_LizamaNunez(String nameFile, String extension, String user, Date fechaCreacion, String ubicacion) {
        this.nameFile = nameFile;
        this.extension = extension;
        this.tipoDeArchivo = obtenerTipodeArchivo();
        this.user = user;
        this.fechaCreacion = fechaCreacion;
        this.ubicacion = ubicacion;
        this.atributos= new ArrayList<>();
    }


    @Override
    public String obtenerTipodeArchivo() {
        return "Archivo de código fuente";
    }

    @Override
    public String getNameFile() {
        return nameFile;
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void setFechaCreacion(Date nuevaFecha) {
        this.fechaCreacion = nuevaFecha;
    }

    @Override
    public void setNameFile(String newNameFile) {
        this.nameFile = newNameFile;
    }

    @Override
    public List<String> getAtributos() {
        return atributos;
    }


    @Override
    public String toString() {
        return "FileCod{" +
                "nameFile='" + nameFile + '\'' +
                ", extension='" + extension + '\'' +
                ", tipoDeArchivo='" + tipoDeArchivo + '\'' +
                ", user='" + user + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
