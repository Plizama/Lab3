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

}


