package org.example;
import java.util.ArrayList;
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




    public Filesystem(String nameFilesystem) {
        this.nombreSystem = nameFilesystem;
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.users = new ArrayList<>();
        this.files = new ArrayList<>();

    }
    @Override
    public void addDrive(String letter, String nameDrive, int capacity) {
        Drive newDrive = new Drive(letter, nameDrive,capacity);
        drives.add(newDrive);
    }




    @Override
    public String toString() {
        return "Filesystem{" +
                "nombreSystem='" + nombreSystem + '\'' +
                ", fecha=" + fecha +
                ", drives=" + drives +
                ", folders=" + folders +
                ", users=" + users +
                ", files=" + files +
                ", userLog='" + userLog + '\'' +
                ", rutaActual='" + rutaActual + '\'' +
                ", trash=" + trash +
                '}';
    }
}
