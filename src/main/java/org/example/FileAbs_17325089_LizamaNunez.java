package org.example;

import java.util.Date;

public abstract class FileAbs_17325089_LizamaNunez {
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
    public abstract void setFechaCreacion(Date nuevaFecha);
    public abstract void setNameFile(String newNameFile);

}


