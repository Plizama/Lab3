package org.example;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Filesystem_17325089_LizamaNunez implements FilesystemInterface_17325089_LizamaNunez {
    private String nombreSystem;
    private Date fecha;
    private List<Drive_17325089_LizamaNunez> drives;
    private List<Folder_17325089_LizamaNunez> folders;
    private List<User_17325089_LizamaNunez> users;
    private List<FileAbs_17325089_LizamaNunez> files;
    private String rutaActual;
    private Trash_17325089_LizamaNunez trash;




    public Filesystem_17325089_LizamaNunez(String nameFilesystem) {
        this.nombreSystem = nameFilesystem;
        this.fecha = new Date();
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.users = new ArrayList<>();
        this.files = new ArrayList<>();
        this.trash = new Trash_17325089_LizamaNunez();

    }

    @Override
    public void addDrive(String letter, String nameDrive, int capacity) {
        Drive_17325089_LizamaNunez newDrive = new Drive_17325089_LizamaNunez(letter, nameDrive,capacity);
        drives.add(newDrive);
    }

    @Override
    public void register(String nameUser) {
        User_17325089_LizamaNunez newUser = new User_17325089_LizamaNunez(nameUser);
        users.add(newUser);
    }

    @Override
    public void login(String nameUser) {
        //.indexof()
        List<User_17325089_LizamaNunez> listaUsers = getUsers();
        for(User_17325089_LizamaNunez userBuscado : listaUsers){
            String nameUserbuscado = userBuscado.getNameUser();
            if(nameUserbuscado.equals(nameUser)){
                userBuscado.setLogin(true);
            }
        }
    }

    @Override
    public void logout() {
        List<User_17325089_LizamaNunez> listaUsers = getUsers();
        for(User_17325089_LizamaNunez userLogueado : listaUsers){
            boolean estadoUser = userLogueado.isLogin();
            if(estadoUser){
                userLogueado.setLogin(false);
            }
        }
    }

    //existe Usuario logueado
    public boolean existUserLog(){
        List<User_17325089_LizamaNunez> listaUsers = getUsers();
        for(User_17325089_LizamaNunez userLogueado : listaUsers){
            boolean estadoUser = userLogueado.isLogin();
            if(estadoUser){
                return true;
            }
        }
        return false;
    }
    public String nameUserLog() {
        List<User_17325089_LizamaNunez> listaUsers = getUsers();
        for (User_17325089_LizamaNunez userLogueado : listaUsers) {
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
        Folder_17325089_LizamaNunez newDirectory = new Folder_17325089_LizamaNunez(nameDirectory, nameUserAct, FechaCrea, FechaCrea, rutaDirectory);
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
                List<Folder_17325089_LizamaNunez> carpetasActuales = getFolders();
                //List<Folder> folders
                for( Folder_17325089_LizamaNunez carpetaBuscada: carpetasActuales){
                    String nameCarpetaBuscada = carpetaBuscada.getNameFolder();
                    if(carpeta.equals(nameCarpetaBuscada)){
                        String rutaCarpetaBuscada = carpetaBuscada.getRutaActual();
                        String newRuta = rutaCarpetaBuscada.concat(nameCarpetaBuscada);
                        setRutaActual(newRuta);
                        return;
                    }
                }
            }
            List<Folder_17325089_LizamaNunez> carpetasActuales = getFolders();
            for( Folder_17325089_LizamaNunez carpetaBuscada: carpetasActuales){
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
            FileAbs_17325089_LizamaNunez newfile = new FileCod_17325089_LizamaNunez(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileDoc.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs_17325089_LizamaNunez newfile = new FileDoc_17325089_LizamaNunez(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileImag.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs_17325089_LizamaNunez newfile = new FileImag_17325089_LizamaNunez(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
        if(fileText.contains(extension)){
            String userAct = nameUserLog();
            Date FechaCrea = new Date();
            String rutaAct = getRutaActual();
            FileAbs_17325089_LizamaNunez newfile = new FileText_17325089_LizamaNunez(nameFile, extension, userAct, FechaCrea, rutaAct);
            files.add(newfile);
        }
    }

    //private List<FileAbs> files;
    @Override
    public void del(String fileName){
        List<String> todoDirectorioActual = Arrays.asList("*.*","*");
        if (todoDirectorioActual.contains(fileName)){
            String rutaActuAl = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
            List<FileAbs_17325089_LizamaNunez> newfiles = new ArrayList<>();
            for (FileAbs_17325089_LizamaNunez archivoBuscado: archivosActuales){
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
                List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> newfiles = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez archivoBuscado: archivosActuales) {
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
                List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> newfiles = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez archivoBuscado: archivosActuales) {
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
                List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> newfiles = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez archivoBuscado: archivosActuales){
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
                List<Folder_17325089_LizamaNunez> carpetasActuales = getFolders();
                List<FileAbs_17325089_LizamaNunez> busquedaArchivosCarpeta = getFiles();
                List<Folder_17325089_LizamaNunez> newfolders = new ArrayList<>();
                List<FileAbs_17325089_LizamaNunez> newfiles = new ArrayList<>();
                for (Folder_17325089_LizamaNunez carpetaBuscada: carpetasActuales){
                    String nameCarpetaBuscada = carpetaBuscada.getNameFolder();
                    if (nameCarpetaBuscada.equals(fileName)){
                        trash.addFolderTrash(carpetaBuscada);
                        for (FileAbs_17325089_LizamaNunez archivosEnCarpeta: busquedaArchivosCarpeta){
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

   /// REVISAR DE ACA ABAJO
    @Override
    public void copy(String nameFile, String targetPath) {
        // namefiles con *
        if (nameFile.contains("*")){
            // folder1/my_*
            if(nameFile.contains("/")){
                int posicionSlash = nameFile.indexOf("/")+ 1;
                int largoNameFile = nameFile.length()-1;
                //my_
                String inicioNameFile = nameFile.substring(posicionSlash,largoNameFile);
                // folder1
                String folderContenedor = nameFile.substring(0,(posicionSlash-1));
                List<FileAbs_17325089_LizamaNunez> listaFilesActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> archivosCopiados = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez fileBuscado : listaFilesActuales){
                    String rutaFileBuscado = fileBuscado.getUbicacion();
                    String slash = "/";
                    int numeroSlashRuta = contadorCaracteres(rutaFileBuscado,slash.charAt(0));
                    if (numeroSlashRuta > 1){
                        int numeroSlashFinal = rutaFileBuscado.length() -1;
                        String rutaMenosSlashFinal = rutaFileBuscado.substring(0,numeroSlashFinal);
                        String rutaInvertida = invertirString(rutaMenosSlashFinal);
                        int posicionPrimerSlash = rutaInvertida.indexOf("/");
                        String folderBuscadaInvertida = rutaInvertida.substring(0,posicionPrimerSlash);
                        String folderBuscada = invertirString(folderBuscadaInvertida);
                        if (folderBuscada.equals(folderContenedor)){
                            String nameFileBuscado = fileBuscado.getNameFile();
                            if (nameFileBuscado.contains(inicioNameFile)){
                                Date newFecha = new Date();
                                FileAbs_17325089_LizamaNunez newFile = fileCreator(nameFileBuscado,targetPath,newFecha);
                                archivosCopiados.add(newFile);
                            }
                        }
                    }else{
                        int largoRutaFileBuscado = rutaFileBuscado.length()-1;
                        String rutaMenosSlashFinal = rutaFileBuscado.substring(0,largoRutaFileBuscado);
                        if(rutaFileBuscado.contains(folderContenedor)){
                            String nameFileBuscado = fileBuscado.getNameFile();
                            if (nameFileBuscado.contains(inicioNameFile)){
                                Date newFecha = new Date();
                                FileAbs_17325089_LizamaNunez newFile = fileCreator(nameFileBuscado,targetPath,newFecha);
                                archivosCopiados.add(newFile);
                            }
                        }
                    }
                } files.addAll(archivosCopiados);
            }else {
                int largoNameFile = nameFile.length();
                String trozoFileBuscado = nameFile.substring(1,largoNameFile);
                List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> archivosCopiados = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez fileBuscado : archivosActuales){
                    String nameFileBuscado = fileBuscado.getNameFile();
                    if (nameFileBuscado.contains(trozoFileBuscado)){
                        Date newFecha = new Date();
                        FileAbs_17325089_LizamaNunez newFile = fileCreator(nameFileBuscado,targetPath,newFecha);
                        archivosCopiados.add(newFile);

                    }
                }
                files.addAll(archivosCopiados);
            }
        }else{
            if (nameFile.contains(".")){
                List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
                List<FileAbs_17325089_LizamaNunez> archivosCopiados = new ArrayList<>();
                for (FileAbs_17325089_LizamaNunez fileBuscado : archivosActuales){
                    String nameFileBuscado = fileBuscado.getNameFile();
                    if (nameFileBuscado.equals(nameFile)){
                        Date newFecha = new Date();
                        FileAbs_17325089_LizamaNunez newFile = fileCreator(nameFileBuscado,targetPath,newFecha);
                        archivosCopiados.add(newFile);

                    }
                }
                files.addAll(archivosCopiados);
            }else{
                List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
                List<Folder_17325089_LizamaNunez> foldersCopiados = new ArrayList<>();
                for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                    String nameFolder = folderBuscado.getNameFolder();
                    if (nameFolder.equals(nameFile)){
                        Date newFecha = new Date();
                        String userActual = nameUserLog();
                        Folder_17325089_LizamaNunez newFolder = new Folder_17325089_LizamaNunez(nameFolder,userActual,newFecha,newFecha,targetPath);
                        foldersCopiados.add(newFolder);
                    }
                }
                folders.addAll(foldersCopiados);

            }
        }
    }

    @Override
    public void move(String nameFile, String targetPath) {
        if(nameFile.contains(".")){
            List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
            for (FileAbs_17325089_LizamaNunez archivoBuscado : archivosActuales){
                String nameArchivoBuscado = archivoBuscado.getNameFile();
                if (nameArchivoBuscado.equals(nameFile)){
                    archivoBuscado.setUbicacion(targetPath);
                }
            }
            return;
        } else {
            List<Folder_17325089_LizamaNunez> listasCarpetasBuscadas = getFolders();
            for (Folder_17325089_LizamaNunez carpetaBuscada :  listasCarpetasBuscadas){
                String nameFolderBuscada = carpetaBuscada.getNameFolder();
                if (nameFolderBuscada.equals(nameFile)){
                    carpetaBuscada.setRutaActual(targetPath);
                }
            }
            return;
        }
    }

    @Override
    public void ren(String currentName, String newName) {
        if(currentName.contains(".")){
            List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez archivo: archivosActuales){
                String nameArchivo= archivo.getNameFile();
                if(nameArchivo.equals(currentName)){
                    archivo.setNameFile(newName);
                }
            }
        }else {
            List<Folder_17325089_LizamaNunez> carpetasActuales = getFolders();
            for(Folder_17325089_LizamaNunez carpeta : carpetasActuales){
                String nameCarpeta = carpeta.getNameFolder();
                if(nameCarpeta.equals(currentName)){
                    carpeta.setNameFolder(newName);
                }
            }
        }
    }

    @Override
    public void dir(List<String> params) {
        List<String> vacio =new ArrayList<>();

        List<String> dirActuOculto = new ArrayList<>();
        dirActuOculto.add("/a");

        List<String> dirActu = new ArrayList<>();
        dirActu.add("/s");

        List<String> dirActuAlfaAs = new ArrayList<>();
        dirActuAlfaAs.add("/o N");

        List<String> pregunta = new ArrayList<>();
        pregunta.add("/?");

        List<String> dirActuySub = new ArrayList<>();
        dirActuySub.add("/s");
        dirActuySub.add("/a");

        List<String> dirFechaAsc = new ArrayList<>();
        dirFechaAsc.add("/o D");

        List<String> dirFechaDes = new ArrayList<>();
        dirFechaDes.add("/o-D");


        if(params.equals(dirActuOculto)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaActual.equals(rutaFileBuscado)){
                    System.out.println(fileBuscado);
                    System.out.println( "\n");
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaActual.equals(rutaFolderBuscado)){
                    System.out.println(folderBuscado);
                    System.out.println("\n");
                }
            }
        }
        if (params.equals(dirActu)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaFileBuscado.contains(rutaActual)){
                    List<String> listAtributosFileBuscado = fileBuscado.getAtributos();
                    //r (solo lectura), h (oculto)
                    if (listAtributosFileBuscado.contains("h")){
                        //salta
                    }else {
                        System.out.println(fileBuscado);
                        System.out.println( "\n");
                    }
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaFolderBuscado.contains(rutaActual)){
                    System.out.println(folderBuscado);
                    System.out.println("\n");
                }
            }
        }
        if(params.equals(dirActuySub)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaFileBuscado.contains(rutaActual)){
                    System.out.println(fileBuscado);
                    System.out.println( "\n");
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaFolderBuscado.contains(rutaActual)){
                    System.out.println(folderBuscado);
                    System.out.println("\n");
                }
            }

        }
        if (params.equals(vacio)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaFileBuscado.equals(rutaActual)){
                    List<String> listAtributosFileBuscado = fileBuscado.getAtributos();
                    //r (solo lectura), h (oculto)
                    if (listAtributosFileBuscado.contains("h")){
                        //salta
                    }else {
                        System.out.println(fileBuscado + "\n");

                    }
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaFolderBuscado.equals(rutaActual)){
                    System.out.println(folderBuscado + "\n" );
                }
            }
        }
        if (params.equals(dirActuAlfaAs)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            List<FileAbs_17325089_LizamaNunez> filesDirActual = new ArrayList<>();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaActual.equals(rutaFileBuscado)){
                    filesDirActual.add(fileBuscado);
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            List<Folder_17325089_LizamaNunez> foldersDirActual = new ArrayList<>();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaActual.equals(rutaFolderBuscado)){
                    foldersDirActual.add(folderBuscado);
                }
            }
            Collections.sort(filesDirActual, new Comparator<FileAbs_17325089_LizamaNunez>() {
                @Override
                public int compare(FileAbs_17325089_LizamaNunez p1, FileAbs_17325089_LizamaNunez p2) {
                    return p1.getNameFile().compareTo(p2.getNameFile());
                }
            });
            for (FileAbs_17325089_LizamaNunez file: filesDirActual){
                System.out.println(file + "\n");
            }
            //System.out.println(filesDirActual);
            Collections.sort(foldersDirActual, new Comparator<Folder_17325089_LizamaNunez>() {
                @Override
                public int compare(Folder_17325089_LizamaNunez f1, Folder_17325089_LizamaNunez f2) {
                    return f1.getNameFolder().compareTo(f2.getNameFolder());
                }
            });
            for (Folder_17325089_LizamaNunez folder: foldersDirActual){
                System.out.println(folder + "\n");
            }


        }
        if(params.equals(dirFechaAsc)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            List<FileAbs_17325089_LizamaNunez> filesDirActual = new ArrayList<>();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaFileBuscado.equals(rutaActual)){
                    List<String> listAtributosFileBuscado = fileBuscado.getAtributos();
                    //r (solo lectura), h (oculto)
                    if (listAtributosFileBuscado.contains("h")){
                        //salta
                    }else {
                        filesDirActual.add(fileBuscado);
                    }
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            List<Folder_17325089_LizamaNunez> foldersDirActual = new ArrayList<>();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaFolderBuscado.equals(rutaActual)){
                    foldersDirActual.add(folderBuscado);
                }
            }
            ///prueba
            Collections.sort(filesDirActual, new Comparator<FileAbs_17325089_LizamaNunez>() {
                @Override
                public int compare(FileAbs_17325089_LizamaNunez p1, FileAbs_17325089_LizamaNunez p2) {
                    return p1.getFechaCreacion().compareTo(p2.getFechaCreacion());
                }
            });
            for (FileAbs_17325089_LizamaNunez file: filesDirActual){
                System.out.println(file + "\n");
            }
            Collections.sort(foldersDirActual, new Comparator<Folder_17325089_LizamaNunez>() {
                @Override
                public int compare(Folder_17325089_LizamaNunez f1, Folder_17325089_LizamaNunez f2) {
                    return f1.getFechaCreacion().compareTo(f2.getFechaCreacion());
                }
            });
            for (Folder_17325089_LizamaNunez folder: foldersDirActual){
                System.out.println(folder + "\n");
            }
        }
        if (params.equals(dirFechaDes)){
            String rutaActual = getRutaActual();
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            List<FileAbs_17325089_LizamaNunez> filesDirActual = new ArrayList<>();
            for(FileAbs_17325089_LizamaNunez fileBuscado : filesActuales){
                String rutaFileBuscado = fileBuscado.getUbicacion();
                if (rutaFileBuscado.equals(rutaActual)){
                    List<String> listAtributosFileBuscado = fileBuscado.getAtributos();
                    //r (solo lectura), h (oculto)
                    if (listAtributosFileBuscado.contains("h")){
                        //salta
                    }else {
                        filesDirActual.add(fileBuscado);
                    }
                }
            }
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            List<Folder_17325089_LizamaNunez> foldersDirActual = new ArrayList<>();
            for(Folder_17325089_LizamaNunez folderBuscado : foldersActuales){
                String rutaFolderBuscado = folderBuscado.getRutaActual();
                if (rutaFolderBuscado.equals(rutaActual)){
                    foldersDirActual.add(folderBuscado);
                }
            }
            ///prueba
            Collections.sort(filesDirActual, new Comparator<FileAbs_17325089_LizamaNunez>() {
                @Override
                public int compare(FileAbs_17325089_LizamaNunez p1, FileAbs_17325089_LizamaNunez p2) {
                    return p2.getFechaCreacion().compareTo(p1.getFechaCreacion());
                }
            });
            for (FileAbs_17325089_LizamaNunez file: filesDirActual){
                System.out.println(file + "\n");
            }
            Collections.sort(foldersDirActual, new Comparator<Folder_17325089_LizamaNunez>() {
                @Override
                public int compare(Folder_17325089_LizamaNunez f1, Folder_17325089_LizamaNunez f2) {
                    return f2.getFechaCreacion().compareTo(f1.getFechaCreacion());
                }
            });
            for (Folder_17325089_LizamaNunez folder: foldersDirActual){
                System.out.println(folder + "\n");
            }
        }
        if (params.equals(pregunta)){
            System.out.println("-----PARAMETROS UTILIZADOS---- \n");
            System.out.println("Parametro listar contenido directorio actual: ");
            System.out.println("\"\"");
            System.out.println("______________________");
            System.out.println("Parametro lista contenido directorio actual y subdirectorios :");
            System.out.println("["+"\""+"/"+"s"+"\""+"]" );
            System.out.println("______________________");
            System.out.println("Parametro lista contenido directorio actual (incluye contenido oculto) :");
            System.out.println("["+"\""+"/"+"a"+"\""+"]" );
            System.out.println("______________________");
            System.out.println("Parametro lista contenido directorio actual y subdirectorios (incluye contenido oculto) :");
            System.out.println("["+"\""+"/"+"s"+"\""+","+"\""+"/"+"a"+"\""+"]" );
            System.out.println("______________________");
            System.out.println("Parametro lista contenido directorio actual en orden alfabetico :");
            System.out.println("["+"\""+"/"+"o"+" "+"N"+"\""+"]" );
            System.out.println("______________________");
            System.out.println("Parametro lista contenido actual segun fecha en orden ascendente :");
            System.out.println("["+"\""+"/"+"o"+" "+"D"+"\""+"]" );
            System.out.println("______________________");
            System.out.println("Parametro lista contenido actual segun fecha en orden descendente :");
            System.out.println("["+"\""+"/"+"o"+"-"+"D"+"\""+"]" );
            System.out.println("______________________");

        }
        return;

    }

    @Override
    public void format(String letter, String newName) {
        List<Drive_17325089_LizamaNunez> listDrivesActuales = getDrives();
        List<Drive_17325089_LizamaNunez> listNewDrivesActuales = new ArrayList<>();
        for (Drive_17325089_LizamaNunez driveBuscado: listDrivesActuales){
            String letterDriveBuscado = driveBuscado.getLetter();
            int capacityDriveBuscado = driveBuscado.getCapacity();
            if (letterDriveBuscado.contains(letter)){
                Drive_17325089_LizamaNunez newDrive = new Drive_17325089_LizamaNunez(letter,newName,capacityDriveBuscado);
                listNewDrivesActuales.add(newDrive);
            } else {
                listNewDrivesActuales.add(driveBuscado);
            }


        }
        setDrives(listNewDrivesActuales);

        List<FileAbs_17325089_LizamaNunez> listFileActuales = getFiles();
        List<FileAbs_17325089_LizamaNunez> newListFileActuales = new ArrayList<>();
        for (FileAbs_17325089_LizamaNunez fileBuscado: listFileActuales){
            String rutaFileBuscado = fileBuscado.getUbicacion();
            if (rutaFileBuscado.contains(letter)){
                //
            }else {
                newListFileActuales.add(fileBuscado);
            }
        }
        setFiles(newListFileActuales);

        List<Folder_17325089_LizamaNunez> listFolderActuales = getFolders();
        List<Folder_17325089_LizamaNunez> newListFolderActuales = new ArrayList<>();
        for (Folder_17325089_LizamaNunez folderBuscado : listFolderActuales){
            String rutaFolderBuscado = folderBuscado.getRutaActual();
            if(rutaFolderBuscado.contains(letter)){
                //
            }else{
                newListFolderActuales.add(folderBuscado);
            }
        }
        setFolders(newListFolderActuales);
    }

    @Override
    public void encrypt(String password, String folderName) {
        int sumaPassword =sumaASCIIString(password);
        int x = sumaPassword % 5;
        //FILE
        if (folderName.contains(".")){
            String newNameFolder = transformarStringSumaASCII(folderName,x);
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for (FileAbs_17325089_LizamaNunez file: filesActuales){
                String nameFile = file.getNameFile();
                if (nameFile.equals(folderName)){
                    file.setNameFile(newNameFolder);
                }
            }
        }
        //Folder
        else {
            String newNameFolder = transformarStringSumaASCII(folderName,x);
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            //Cambiar name carpeta
            for (Folder_17325089_LizamaNunez folder : foldersActuales){
                String nameFolder = folder.getNameFolder();
                if (nameFolder.equals(folderName)){
                    folder.setNameFolder(newNameFolder);
                }
            }
            //Cambiar nombre Archivos contenidos carpeta
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado: filesActuales){
                String ruta = fileBuscado.getUbicacion();
                if (ruta.contains(folderName)){
                    String nameFileBuscado = fileBuscado.getNameFile();
                    String newNameFile = transformarStringSumaASCII(nameFileBuscado,x);
                    fileBuscado.setNameFile(newNameFile);
                }

            }
            //Cambiar subcarpetas de carperta escogida
            for (Folder_17325089_LizamaNunez folderBuscado: foldersActuales){
                String rutaFolder = folderBuscado.getRutaActual();
                if (rutaFolder.contains(folderName)){
                    String nameFoldeBuscado = folderBuscado.getNameFolder();
                    String newNameFolderBuscado = transformarStringSumaASCII(nameFoldeBuscado, x);
                    folderBuscado.setNameFolder(newNameFolderBuscado);
                }
            }
        }
    }

    @Override
    public void decrypt(String password, String folderName) {
        int sumaPassword =sumaASCIIString(password);
        int x = sumaPassword % 5;
        String encryptFolderNamer = transformarStringSumaASCII(folderName,x);
        //FILE
        if (folderName.contains(".")){
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for (FileAbs_17325089_LizamaNunez file: filesActuales){
                String nameFile = file.getNameFile();
                if (nameFile.equals(encryptFolderNamer)){
                    file.setNameFile(folderName);
                }
            }
        }
        //Folder
        else {
            List<Folder_17325089_LizamaNunez> foldersActuales = getFolders();
            //Cambiar name carpeta
            for (Folder_17325089_LizamaNunez folder : foldersActuales) {
                String nameFolder = folder.getNameFolder();
                if (nameFolder.equals(encryptFolderNamer)) {
                    folder.setNameFolder(folderName);
                }
            }
            //Cambiar nombre Archivos contenidos carpeta
            List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
            for(FileAbs_17325089_LizamaNunez fileBuscado: filesActuales){
                String ruta = fileBuscado.getUbicacion();
                if (ruta.contains(folderName)){
                    String nameFileBuscado = fileBuscado.getNameFile();
                    String newNameFile = transformarStringSumaASCII(nameFileBuscado,(-x));
                    fileBuscado.setNameFile(newNameFile);
                }

            }
            //Cambiar subcarpetas de carperta escogida
            for (Folder_17325089_LizamaNunez folderBuscado: foldersActuales){
                String rutaFolder = folderBuscado.getRutaActual();
                if (rutaFolder.contains(folderName)){
                    String nameFoldeBuscado = folderBuscado.getNameFolder();
                    String newNameFolderBuscado = transformarStringSumaASCII(nameFoldeBuscado, (-x));
                    folderBuscado.setNameFolder(newNameFolderBuscado);
                }
            }
        }
    }

    @Override
    public void grep(String pattern, String path) {
        List<String> comodines = new ArrayList<>();
        comodines.add("..");
        comodines.add(".");
        comodines.add("/");
        comodines.add("*");
        List<FileAbs_17325089_LizamaNunez> filesActuales = getFiles();
        if(comodines.contains(path)){
            String rutaActual = getRutaActual();
            for (FileAbs_17325089_LizamaNunez file : filesActuales){
                String ubicacionFile = file.getUbicacion();
                if (rutaActual.equals(ubicacionFile)){
                    String contenidoFile = file.getContenido();
                    String nameFile = file.getNameFile();
                    int contador = 0;

                    while (contenidoFile.indexOf(pattern) > -1) {
                        contenidoFile = contenidoFile.substring(contenidoFile.indexOf(
                                pattern)+pattern.length(),contenidoFile.length());
                        contador++;
                    }
                    System.out.println("La cantidad de veces de la palabra buscada en "+ nameFile+"es"+contador);
                }
            }
            return;

        }else {
            for (FileAbs_17325089_LizamaNunez file : filesActuales){
                String nameFile = file.getNameFile();
                if (nameFile.equals(path)){
                    String contenidoFile = file.getContenido();
                    int contador = 0;

                    while (contenidoFile.indexOf(pattern) > -1) {
                        contenidoFile = contenidoFile.substring(contenidoFile.indexOf(
                                pattern)+pattern.length(),contenidoFile.length());
                        contador++;
                    }
                    System.out.println("La cantidad de veces de la palabra buscada en "+ nameFile+"es"+contador);
                }
            }
            return;

        }
    }

    @Override
    public void viewTrash() {
        System.out.println("---Archivos en la papelera---");
        List<FileAbs_17325089_LizamaNunez> filesPapelera = trash.getFiles();
        for (FileAbs_17325089_LizamaNunez fileTrash : filesPapelera){
            System.out.println(fileTrash + "\n");
        }
        System.out.println("---Carpetas en la papelera---");
        List<Folder_17325089_LizamaNunez> foldersPapelera = trash.getFolders();
        for (Folder_17325089_LizamaNunez folderTrash : foldersPapelera){
            System.out.println(folderTrash + "\n");
        }
    }

    @Override
    public void restore(String pattern) {
        String restaurarTodo = "*.*";
        if (pattern.equals(restaurarTodo)){
            List<FileAbs_17325089_LizamaNunez> filesPapelera = trash.getFiles();
            files.addAll(filesPapelera);
            List<Folder_17325089_LizamaNunez> foldersPapelera = trash.getFolders();
            folders.addAll(foldersPapelera);
        } else {
            if (pattern.contains(".")){
                List<FileAbs_17325089_LizamaNunez> filesPapelera = trash.getFiles();
                for (FileAbs_17325089_LizamaNunez fileBuscado : filesPapelera){
                    String nameFileBuscado = fileBuscado.getNameFile();
                    if (nameFileBuscado.equals(pattern)){
                        files.add(fileBuscado);
                    }
                }
            }else {
                List<Folder_17325089_LizamaNunez> foldersPapelera = trash.getFolders();
                for (Folder_17325089_LizamaNunez folderBuscado : foldersPapelera){
                    String nameFolderBuscado = folderBuscado.getNameFolder();
                    if (nameFolderBuscado.equals(pattern)){
                        folders.add(folderBuscado);
                    }
                }
            }
        }
    }


    public boolean existeLEtter (List<Drive_17325089_LizamaNunez> listaDrives, String LetterPrueba){
        int numeroDrives = listaDrives.size();

        if (numeroDrives == 1){
            Drive_17325089_LizamaNunez primerDrive = listaDrives.get(0);
            String originalLetter = primerDrive.getLetter();
            //return originalLetter;
            if (originalLetter.equals(LetterPrueba)) {
                return true;
            }
        }
        if(numeroDrives > 1){
            for( Drive_17325089_LizamaNunez driveActual: listaDrives){
                String letterActual = driveActual.getLetter();
                if (letterActual.equals(LetterPrueba)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeUser (List<User_17325089_LizamaNunez> ListUsers, String nameNewUser){
        int numeroUsers = ListUsers.size();

        if (numeroUsers == 1){
            User_17325089_LizamaNunez primerUser = ListUsers.get(0);
            String originalNAme = primerUser.getNameUser();
            if (originalNAme.equals(nameNewUser)) {
                return true;
            }
        }
        if(numeroUsers > 1){
            for(User_17325089_LizamaNunez userSelect: ListUsers){
                String nameUserSelect = userSelect.getNameUser();
                if (nameUserSelect.equals(nameNewUser)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int sumaASCIIString(String palabra){
        int suma = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            int valorAscii = (int) caracter;
            suma += valorAscii;
        }
        return suma;
    }
    public String transformarStringSumaASCII (String original, int valor){
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char caracter = original.charAt(i);
            int ascii = (int) caracter;
            int nuevoAscii = ascii + valor;
            char nuevoCaracter = (char) nuevoAscii;
            resultado.append(nuevoCaracter);
        }
        return resultado.toString();

    }
    public boolean existePassword(String password, String originalName){
        int valorEncriptado = sumaASCIIString(password);
        String nameEncriptado = transformarStringSumaASCII(originalName,valorEncriptado);
        List<Folder_17325089_LizamaNunez> listaFolders = getFolders();
        List<FileAbs_17325089_LizamaNunez> listaFiles = getFiles();
        if (originalName.contains(".")) {
            for (FileAbs_17325089_LizamaNunez file : listaFiles) {
                String nameFile = file.getNameFile();
                if (nameFile.equals(nameEncriptado)) {
                    return true;
                }
            }
        }
        if(!(originalName.contains("."))){
            for (Folder_17325089_LizamaNunez folder: listaFolders) {
                String nameFolder = folder.getNameFolder();
                if (nameFolder.equals(nameEncriptado)) {
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
        List<FileAbs_17325089_LizamaNunez> archivosActuales = getFiles();
        for (FileAbs_17325089_LizamaNunez archivoBuscado: archivosActuales){
            String nameArchivoBuscado = archivoBuscado.getNameFile();
            if (nameArchivoBuscado.equals(nameFile)){
                files.remove(contador);
            }
            contador++;

        }
    }
    public void eliminaCarpetaPorName(String nameFolder){
        int contador = 0;
        List<Folder_17325089_LizamaNunez> carpetasActuales = getFolders();
        for (Folder_17325089_LizamaNunez carpetaBuscado: carpetasActuales){
            String nameCarpetaBuscada = carpetaBuscado.getNameFolder();
            if (nameCarpetaBuscada.equals(nameFolder)){
                folders.remove(contador);
            }
            contador++;

        }
    }






    public List<Drive_17325089_LizamaNunez> getDrives() {
        return drives;
    }


    public List<User_17325089_LizamaNunez> getUsers() {
        return users;
    }

    public void setRutaActual(String rutaActual) {
        String ruta = rutaActual + "/";
        this.rutaActual = ruta;
    }


    public String getRutaActual() {
        return rutaActual;
    }

    public List<Folder_17325089_LizamaNunez> getFolders() {
        return folders;
    }


    public List<FileAbs_17325089_LizamaNunez> getFiles() {
        return files;
    }

    public void setFiles(List<FileAbs_17325089_LizamaNunez> files) {
        this.files = files;
    }

    public void setFolders(List<Folder_17325089_LizamaNunez> folders) {
        this.folders = folders;
    }

    public FileAbs_17325089_LizamaNunez fileCreator(String nameFile, String ubicacion, Date newdate) {
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
            FileAbs_17325089_LizamaNunez newfile = new FileCod_17325089_LizamaNunez(nameFile, extension, userAct, newdate, ubicacion);
            return newfile;
        }
        if(fileDoc.contains(extension)){
            String userAct = nameUserLog();
            FileAbs_17325089_LizamaNunez newfile = new FileDoc_17325089_LizamaNunez(nameFile, extension, userAct, newdate, ubicacion);
            return newfile;
        }
        if(fileImag.contains(extension)){
            String userAct = nameUserLog();
            FileAbs_17325089_LizamaNunez newfile = new FileImag_17325089_LizamaNunez(nameFile, extension, userAct, newdate, ubicacion);
            return newfile;
        }
        else{
            String userAct = nameUserLog();
            FileAbs_17325089_LizamaNunez newfile = new FileText_17325089_LizamaNunez(nameFile, extension, userAct, newdate, ubicacion);
            return newfile;
        }
    }

    public void setDrives(List<Drive_17325089_LizamaNunez> drives) {
        this.drives = drives;
    }
}
