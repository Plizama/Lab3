package org.example;
import java.util.Date;
import java.util.List;

public class Filesystem implements FilesystemInterface{
    private String nombreSystem;
    private Date fecha;
    private List<Drive> drives;
    private List<Folder> folders;
    private List<String> users;
    private List<File> files;
    private String userLog;
    private String rutaActual;
    private Trash trash;


    @Override
    public void addDrive(String letter, String nameDrive, int capacity) {

    }
}
