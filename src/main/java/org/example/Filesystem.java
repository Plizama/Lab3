package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Filesystem implements FilesystemInterface{
    private String nombreSystem;
    private Date fecha;
    private List<Drive> drives;
    private List<Folder> folders;
    private List<User> users;
    private List<FileAbs> files;
    private String rutaActual;
    private Trash trash;




    public Filesystem(String nameFilesystem) {
        this.nombreSystem = nameFilesystem;
        this.fecha = new Date();
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.users = new ArrayList<>();
        this.files = new ArrayList<>();
        this.trash = new Trash();

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
    public String nameUserLog() {
        List<User> listaUsers = getUsers();
        for (User userLogueado : listaUsers) {
            boolean estadoUser = userLogueado.isLogin();
            if (estadoUser) {
                String nameUser = userLogueado.getNameUser();
                return nameUser;
            }
        }
        return "NoUser";
    }

    //Proabda, funciona
    public int contadorCaracteres (String palabra, char caracter){
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++){
            if(palabra.charAt(i) == caracter){
                contador++;
            }
        }
        return contador;
    }
    //probado funcional
    public String invertirString (String cadena){
        String invertida = "";
        for (int indice = cadena.length() - 1; indice >=0; indice--){
            invertida += cadena.charAt(indice);
        }
        return invertida;
    }


    @Override
    public void switchDrive(String letterDriveFijo) {

        setRutaActual(letterDriveFijo);
    }

    @Override
    public void mkdir(String nameDirectory) {
        String nameUserAct = nameUserLog();
        Date FechaCrea = new Date();
        String rutaDirectory = getRutaActual();
        Folder newDirectory = new Folder(nameDirectory, nameUserAct, FechaCrea, FechaCrea, rutaDirectory);
        folders.add(newDirectory);

    }

    @Override
    public void cd(String path) {
        String nivelAnterior = "..";
        String raizUnidad = "/";
        String mismaCarpeta1 = ".";
        String mismaCarpeta2 = "./";
        String mismaCarpeta3 = "././././";
        if (path.equals(mismaCarpeta1)){
            return;
        }
        if(path.equals(mismaCarpeta2)) {
            return;
        }
        if(path.equals(mismaCarpeta3)){
            return;
        }
        if(path.equals(raizUnidad)){
            String rutaActual = getRutaActual();
            int posicionPrimerSlash = rutaActual.indexOf("/");
            String nuevaRutaActual = rutaActual.substring(0,posicionPrimerSlash);
            setRutaActual(nuevaRutaActual);
            return;
        }
        if (path.equals(nivelAnterior)){
            String rutaActual = getRutaActual();
            String simbolo = "/";
            int numSlash = contadorCaracteres(rutaActual,simbolo.charAt(0));
            if(numSlash > 1){
                int tamanoRuta = rutaActual.length() - 1;
                String rutaCortada = rutaActual.substring(0,tamanoRuta);
                String rutaInvertida = invertirString(rutaCortada);
                int posicionPrimerSlash = rutaInvertida.indexOf("/") +1;
                int finalString = rutaInvertida.length();
                String rutaFinalInvertida = rutaInvertida.substring(posicionPrimerSlash, finalString);
                String newRuta = invertirString(rutaFinalInvertida);
                setRutaActual(newRuta);
                return;
            }

        } else {

            if (path.contains("/")){
                int primerSlach = path.indexOf("/") + 1;
                int finalString = path.length();
                String carpeta = path.substring(primerSlach,finalString);
                List<Folder> carpetasActuales = getFolders();
                //List<Folder> folders
                for( Folder carpetaBuscada: carpetasActuales){
                    String nameCarpetaBuscada = carpetaBuscada.getNameFolder();
                    if(carpeta.equals(nameCarpetaBuscada)){
                        String rutaCarpetaBuscada = carpetaBuscada.getRutaActual();
                        String newRuta = rutaCarpetaBuscada.concat(nameCarpetaBuscada);
                        setRutaActual(newRuta);
                        return;
                    }
                }
            }
            List<Folder> carpetasActuales = getFolders();
            for( Folder carpetaBuscada: carpetasActuales){
                String nameCarpetaBuscada = carpetaBuscada.getNameFolder();
                if(path.equals(nameCarpetaBuscada)){
                    String rutaCarpetaBuscada = carpetaBuscada.getRutaActual();
                    String newRuta = rutaCarpetaBuscada.concat(nameCarpetaBuscada);
                    setRutaActual(newRuta);
                    return;
                }

            }
            return;

        }

    }

    @Override
    public void addFile(String nameFile) {
        int posicionDot = nameFile.indexOf(".");
        //Probar
        int posicionFinal = nameFile.length();
        String extension = nameFile.substring(posicionDot,posicionFinal);
        List<String> fileCod = Arrays.asList(".java",".py",".rkt");
        List<String> fileDoc = Arrays.asList(".doc",".docx",".pdf");
        List<String> fileImag = Arrays.asList(".jpg",".jpeg",".png");
        List<String> fileText = Arrays.asList(".txt",".md");

        if (fileCod.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs newfile = new FileCod(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileDoc.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs newfile = new FileDoc(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileImag.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs newfile = new FileImag(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileText.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs newfile = new FileText(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
    }

    //private List<FileAbs> files;
    @Override
    public void del(String fileName){
        List<String> todoDirectorioActual = Arrays.asList("*.*","*");
        if (todoDirectorioActual.contains(fileName)){
            String rutaActuAl = getRutaActual();
            List<FileAbs> archivosActuales = getFiles();
            List<FileAbs> newfiles = new ArrayList<>();
            for (FileAbs archivoBuscado: archivosActuales){
                String rutaArchivo = archivoBuscado.getUbicacion();
                if (rutaArchivo.equals(rutaActuAl)){
                    trash.addFileTrash(archivoBuscado);
                }else{
                    newfiles.add(archivoBuscado);
                }
            }
            setFiles(newfiles);
            return;
        }
        if(fileName.contains("*")){
            int posicionAsterisco = fileName.indexOf("*");
            if(posicionAsterisco == 0){
                int posicionPuntoExtension = fileName.indexOf(".");
                int ultimaPosicion = fileName.length();
                String extension = fileName.substring(posicionPuntoExtension,ultimaPosicion);
                List<FileAbs> archivosActuales = getFiles();
                List<FileAbs> newfiles = new ArrayList<>();
                for (FileAbs archivoBuscado: archivosActuales) {
                    String extensionArchivoBuscado = archivoBuscado.getExtension();
                    if (extension.equals(extensionArchivoBuscado)){
                        trash.addFileTrash(archivoBuscado);
                    } else {
                        newfiles.add(archivoBuscado);
                    }
                }
                setFiles(newfiles);
                return;
            } else {
                int posicionPuntoExtensio = fileName.indexOf(".");
                int ultimaPosicion = fileName.length();
                String primeraLetra = fileName.substring(0,1);
                String extension = fileName.substring(posicionPuntoExtensio,ultimaPosicion);
                List<FileAbs> archivosActuales = getFiles();
                List<FileAbs> newfiles = new ArrayList<>();
                for (FileAbs archivoBuscado: archivosActuales) {
                    String extensionArchivoBuscado = archivoBuscado.getExtension();
                    if (extension.equals(extensionArchivoBuscado)){
                        String nameArchivoBuscado = archivoBuscado.getNameFile();
                        String primeraLetraArchivoB = nameArchivoBuscado.substring(0,1);
                        if (primeraLetra.equals(primeraLetraArchivoB)){
                            trash.addFileTrash(archivoBuscado);
                        }else{
                            newfiles.add(archivoBuscado);
                        }
                    }
                }
                setFiles(newfiles);
                return;
            }

        }
        else{
            if (fileName.contains(".")){
                List<FileAbs> archivosActuales = getFiles();
                List<FileAbs> newfiles = new ArrayList<>();
                for (FileAbs archivoBuscado: archivosActuales){
                    String nameArchivoBuscado = archivoBuscado.getNameFile();
                    if (fileName.equals(nameArchivoBuscado)){
                        trash.addFileTrash(archivoBuscado);

                    } else {
                        newfiles.add(archivoBuscado);
                    }
                }
                setFiles(newfiles);
                return;
            } else {
                List<Folder> carpetasActuales = getFolders();
                List<FileAbs> busquedaArchivosCarpeta = getFiles();
                List<Folder> newfolders = new ArrayList<>();
                List<FileAbs> newfiles = new ArrayList<>();
                for (Folder carpetaBuscada: carpetasActuales){
                    String nameCarpetaBuscada = carpetaBuscada.getNameFolder();
                    if (nameCarpetaBuscada.equals(fileName)){
                        trash.addFolderTrash(carpetaBuscada);
                        for (FileAbs archivosEnCarpeta: busquedaArchivosCarpeta){
                            String rutaArchivoEnCarpeta = archivosEnCarpeta.getUbicacion();
                            if(rutaArchivoEnCarpeta.contains(nameCarpetaBuscada)){
                                trash.addFileTrash(archivosEnCarpeta);
                            } else {
                                newfiles.add(archivosEnCarpeta);
                            }
                        }
                        setFiles(newfiles);

                    } else {
                        newfolders.add(carpetaBuscada);
                    }
                }
                setFolders(newfolders);
            }
        }
    }

    /**
     *
     * @param nameFile
     * @param targetPath
     */

    @Override
    public void copy(String nameFile, String targetPath) {
        if (nameFile.contains("*")){
            if (nameFile.contains("/")){
                //"folder/my_*"
                int posicionSlash = nameFile.indexOf("/");
                int largoNameFile = nameFile.length()-1;
                String comienzoNameFile = nameFile.substring(posicionSlash,largoNameFile);
                String nameFolder = nameFile.substring(0, posicionSlash);
                List<FileAbs> archivosActuales = getFiles();
                for (FileAbs archivoRevision : archivosActuales){
                    String rutaArchivobuscado = archivoRevision.getUbicacion();
                    int tamanoRutaArchivo = rutaArchivobuscado.length()-1;
                    String rutaArchivoCortada = rutaArchivobuscado.substring(0,tamanoRutaArchivo);
                    String rutaInvertida = invertirString(rutaArchivoCortada);
                    int posicionPrimerSlash = rutaInvertida.indexOf("/");
                    String stringCortado = rutaInvertida.substring(0,posicionPrimerSlash);
                    String carpetaContendora = invertirString(stringCortado);
                    if (carpetaContendora.equals(nameFolder)){
                        String nameArchivoRevision = archivoRevision.getNameFile();
                        if (nameArchivoRevision.contains(comienzoNameFile)){
                            archivoRevision.setUbicacion(targetPath);
                        }
                    }
                }
                return;
            }else{
                int largoNameFile = nameFile.length();
                String trozoBuscado = nameFile.substring(1, largoNameFile);
                List<FileAbs> archivosActuales = getFiles();
                for (FileAbs archivoBuscado: archivosActuales){
                    String nameArchivoBuscado = archivoBuscado.getNameFile();
                    if(nameArchivoBuscado.contains(trozoBuscado)){
                        archivoBuscado.setUbicacion(targetPath);
                    }
                }
                return;
            }
        }else{
            if(nameFile.contains(".")){
                List<FileAbs> archivosActuales = getFiles();
                for (FileAbs archivoBuscado : archivosActuales){
                    String nameArchivoBuscado = archivoBuscado.getNameFile();
                    if (nameArchivoBuscado.equals(nameFile)){
                        archivoBuscado.setUbicacion(targetPath);
                    }
                }
                return;
            } else {
                List<Folder> listasCarpetasBuscadas = getFolders();
                for (Folder carpetaBuscada :  listasCarpetasBuscadas){
                    String nameFolderBuscada = carpetaBuscada.getNameFolder();
                    if (nameFolderBuscada.equals(nameFile)){
                        carpetaBuscada.setRutaActual(targetPath);
                    }
                }
                return;

            }

        }




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
                ", rutaActual='" + rutaActual + '\'' +
                ", trash=" + trash +
                '}';
    }

    public void eliminaFilePorName(String nameFile){
        int contador = 0;
        List<FileAbs> archivosActuales = getFiles();
        for (FileAbs archivoBuscado: archivosActuales){
            String nameArchivoBuscado = archivoBuscado.getNameFile();
            if (nameArchivoBuscado.equals(nameFile)){
                files.remove(contador);
            }
            contador++;

        }
    }
    public void eliminaCarpetaPorName(String nameFolder){
        int contador = 0;
        List<Folder> carpetasActuales = getFolders();
        for (Folder carpetaBuscado: carpetasActuales){
            String nameCarpetaBuscada = carpetaBuscado.getNameFolder();
            if (nameCarpetaBuscada.equals(nameFolder)){
                folders.remove(contador);
            }
            contador++;

        }
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


    public String getRutaActual() {
        return rutaActual;
    }

    public List<Folder> getFolders() {
        return folders;
    }


    public List<FileAbs> getFiles() {
        return files;
    }

    public void setFiles(List<FileAbs> files) {
        this.files = files;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
