package org.example;

import java.util.Date;

public abstract class FileAbs {
    private String nameFile;
    private String extension;
    private String tipoDeArchivo;
    private String user;
    private Date fechaCreacion;
    private String ubicacion;



    public abstract String obtenerTipodeArchivo();

    public abstract String getNameFile();
    public abstract String getUbicacion();
    public abstract String getExtension();
    public abstract void setUbicacion(String ubicacion);

}


