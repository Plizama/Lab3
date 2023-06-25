package org.example;

import java.util.Date;
import java.util.List;

public class Folder {
    private String nameFolder;
    //Revisar
    private String User;
    private Date fechaCreacion;
    private Date fechamodificacion;
    private List<String> atributos;


    public Folder(String nameFolder, String user, Date fechaCreacion, Date fechamodificacion, List<String> atributos) {
        this.nameFolder = nameFolder;
        User = user;
        this.fechaCreacion = fechaCreacion;
        this.fechamodificacion = fechamodificacion;
        this.atributos = atributos;
    }
}
