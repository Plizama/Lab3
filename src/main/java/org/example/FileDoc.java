package org.example;

import java.util.Date;

public class FileDoc extends FileAbs{
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;

    public FileDoc(String nameFile, String extension, String user, Date fechaCreacion, String ubicacion) {
        this.nameFile = nameFile;
        this.extension = extension;
        this.tipoDeArchivo = obtenerTipodeArchivo();
        this.user = user;
        this.fechaCreacion = fechaCreacion;
        this.ubicacion = ubicacion;
    }


    @Override
    public String obtenerTipodeArchivo() {
        return "Archivo de documento";
    }

    @Override
    public String toString() {
        return "FileDoc{" +
                "nameFile='" + nameFile + '\'' +
                ", extension='" + extension + '\'' +
                ", tipoDeArchivo='" + tipoDeArchivo + '\'' +
                ", user='" + user + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
