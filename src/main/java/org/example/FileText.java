package org.example;

import java.util.Date;

public class FileText extends FileAbs {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;

    public FileText(String nameFile, String extension, String user, Date fechaCreacion, String ubicacion) {
        this.nameFile = nameFile;
        this.extension = extension;
        this.tipoDeArchivo = obtenerTipodeArchivo();
        this.user = user;
        this.fechaCreacion = fechaCreacion;
        this.ubicacion = ubicacion;
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
    public String toString() {
        return "FileText{" +
                "nameFile='" + nameFile + '\'' +
                ", extension='" + extension + '\'' +
                ", tipoDeArchivo='" + tipoDeArchivo + '\'' +
                ", user='" + user + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
