package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileText_17325089_LizamaNunez extends FileAbs_17325089_LizamaNunez {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String contenido;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;
    private List<String> atributos;

    public FileText_17325089_LizamaNunez(String nameFile, String extension, String user, Date fechaCreacion, String ubicacion) {
        this.nameFile = nameFile;
        this.extension = extension;
        this.tipoDeArchivo = obtenerTipodeArchivo();
        this.contenido = "";
        this.user = user;
        this.fechaCreacion = fechaCreacion;
        this.ubicacion = ubicacion;
        this.atributos = new ArrayList<>();
    }


    @Override
    public String obtenerTipodeArchivo() {
        return "Archivo de texto plano";
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
    public Date getFechaCreacion() {
        return fechaCreacion;
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
    public String getContenido() {
        return contenido;
    }


    @Override
    public String toString() {
        return "FileText_17325089_LizamaNunez{" +
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
