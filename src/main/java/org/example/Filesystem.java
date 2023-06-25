package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filesystem implements FilesystemInterface{
    private String nombreSystem;
    private Date fecha;
    private List<Drive> drives;
    private List<Folder> folders;
    private List<User> users;
    private List<File> files;
    private User userLog;
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
    public void register(String nameUser) {
        User newUser = new User(nameUser);
        users.add(newUser);
    }

    @Override
    public void login(String nameUser) {
        //.indexof()
        List<User> listaUsers = getUsers();
        for(User userBuscado : listaUsers){
            String nameUserbuscado = userBuscado.getNameUser();
            if(nameUserbuscado.equals(nameUser)){
                userBuscado.setLogin(true);
                setUserLog(userBuscado);
            }
        }
    }

    @Override
    public void logout() {
        List<User> listaUsers = getUsers();
        for(User userLogueado : listaUsers){
            boolean estadoUser = userLogueado.isLogin();
            if(estadoUser){
                userLogueado.setLogin(false);
            }
        }
    }

    //existe Usuario logueado
    public boolean existUserLog(){
        List<User> listaUsers = getUsers();
        for(User userLogueado : listaUsers){
            boolean estadoUser = userLogueado.isLogin();
            if(estadoUser){
                return true;
            }
        }
        return false;
    }
    @Override
    public void switchDrive(String letterDriveFijo) {
        setRutaActual(letterDriveFijo);
    }

    @Override
    public void mkdir(String nameDirectory) {

    }


    public boolean existeLEtter (List<Drive> listaDrives, String LetterPrueba){
        int numeroDrives = listaDrives.size();

        if (numeroDrives == 1){
            Drive primerDrive = listaDrives.get(0);
            String originalLetter = primerDrive.getLetter();
            //return originalLetter;
            if (originalLetter.equals(LetterPrueba)) {
                return true;
            }
        }
        if(numeroDrives > 1){
            for( Drive driveActual: listaDrives){
                String letterActual = driveActual.getLetter();
                if (letterActual.equals(LetterPrueba)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeUser (List<User> ListUsers, String nameNewUser){
        int numeroUsers = ListUsers.size();

        if (numeroUsers == 1){
            User primerUser = ListUsers.get(0);
            String originalNAme = primerUser.getNameUser();
            if (originalNAme.equals(nameNewUser)) {
                return true;
            }
        }
        if(numeroUsers > 1){
            for(User userSelect: ListUsers){
                String nameUserSelect = userSelect.getNameUser();
                if (nameUserSelect.equals(nameNewUser)) {
                    return true;
                }
            }
        }
        return false;
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


    public List<Drive> getDrives() {
        return drives;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setRutaActual(String rutaActual) {
        String ruta = rutaActual + "/";
        this.rutaActual = ruta;
    }

    public void setUserLog(User userLog) {
        this.userLog = userLog;
    }
}
