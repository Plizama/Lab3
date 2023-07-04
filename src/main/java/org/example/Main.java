package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 0;

        int choice;

        System.out.println("---------PARA INICIAR CREA UN NUEVO SISTEMA----------");
        System.out.println("Ingrese el nombre del nuevo sistema y luego presione ENTER:");
        String nameSystem = input.next();
        Filesystem_17325089_LizamaNunez filesystemCreado = new Filesystem_17325089_LizamaNunez(nameSystem);

        do {
            printMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---Ingresando una nueva unidad al sistema---");
                    System.out.println("Ingrese la letra de la nueva unidad y luego presione ENTER:");
                    String letterDrive= input.next();
                    System.out.println("Ingrese el nombre de la nueva unidad y luego presione ENTER:");
                    String nameDrive= input.next();
                    System.out.println("Ingrese la capacidad de la nueva unidad y luego presione ENTER:");
                    var capacityDrive= input.nextInt();

                    List<Drive_17325089_LizamaNunez> listaDrives = filesystemCreado.getDrives();
                    boolean bandera = filesystemCreado.existeLEtter(listaDrives,letterDrive);
                    if(bandera == true){
                        System.out.println("La letra de la unidad se encuentra repetida, intenta nuevamente.");
                    } else{
                        filesystemCreado.addDrive(letterDrive,nameDrive,capacityDrive);
                        System.out.println(filesystemCreado);
                    }
                    break;

                case 2:
                    //Scanner opcionCase2 = new Scanner(System.in);
                    final int MENU_EXIT_OPTION_CASE_2 = 0;
                    int numeroIngreso2;
                    do {
                        printMenuCase2();
                        numeroIngreso2 = input.nextInt();
                        switch (numeroIngreso2) {
                            case 1:
                                System.out.println("Ingrese el nombre del usuario y luego presione ENTER:");
                                String nameUser= input.next();
                                List<User_17325089_LizamaNunez> listaUsuarios = filesystemCreado.getUsers();
                                boolean banderaUsers = filesystemCreado.existeUser(listaUsuarios, nameUser);
                                if(banderaUsers == true){
                                    System.out.println("El nombre de usuario ya se encuentra registrado, intenta con uno nuevo.");
                                }else{
                                    filesystemCreado.register(nameUser);
                                    System.out.println(filesystemCreado);
                                }
                                break;
                            case 2:
                                System.out.println("---Logueando un usuario en el sistema---");
                                System.out.println("Ingrese el nombre del usuario a loguear y luego presione ENTER:");
                                String nameUserLog= input.next();

                                List<User_17325089_LizamaNunez> listaUsuariosIngresados = filesystemCreado.getUsers();
                                boolean Userbandera = filesystemCreado.existeUser(listaUsuariosIngresados, nameUserLog);
                                if(Userbandera == true){
                                    filesystemCreado.login(nameUserLog);
                                    System.out.println(filesystemCreado);
                                } else{
                                    System.out.println("El nombre del usuario no existe, intenta con un usuario existente.");
                                }

                                break;
                            case 3:
                                System.out.println("---Cerrando la sesion del usuario actual en el sistema---");
                                filesystemCreado.logout();
                                System.out.println("--Sesión cerrada.");
                                break;

                            default:
                                System.out.println(numeroIngreso2 + " Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso2 != MENU_EXIT_OPTION_CASE_2);

                    break;

                case 3:
                    //Scanner opcionCase3 = new Scanner(System.in);
                    final int MENU_EXIT_OPTION_CASE_3 = 0;
                    int numeroIngreso3;
                    do {
                        printMenuCase3();
                        numeroIngreso3 = input.nextInt();
                        switch (numeroIngreso3) {
                            case 1:
                                //switchdrive
                                System.out.println("Ingrese la direccion y luego presione ENTER:");
                                String direccionFija= input.next();
                                System.out.println("---Ingresando a dirección---");

                                if(filesystemCreado.existUserLog()){
                                    filesystemCreado.switchDrive(direccionFija);
                                } else {
                                    System.out.println("No existe usuario logueado.");
                                }
                                System.out.println("--Dirección fijada--");
                                break;

                            case 2:
                                System.out.println("Ingresa simbolo o nueva ruta y luego presione ENTER");
                                String path = input.next();
                                filesystemCreado.cd(path);
                                System.out.println(filesystemCreado);
                                break;

                            default:
                                System.out.println(" Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso3 != MENU_EXIT_OPTION_CASE_3);

                    break;

                case 4:
                    //Scanner opcionCase5 = new Scanner(System.in);
                    final int MENU_EXIT_OPTION_CASE_4 = 0;
                    int numeroIngreso4;
                    do {
                        printMenuCase4();
                        numeroIngreso4 = input.nextInt();
                        switch (numeroIngreso4) {
                            case 1:
                                //mkdir
                                System.out.println("Ingrese el nombre de la nueva carpeta, y luego presione ENTER");
                                String newDirectory= input.next();
                                System.out.println("---Carpeta creada---");
                                String pruebaUser = "NoUser";
                                String nameUserAc = filesystemCreado.nameUserLog();
                                if(pruebaUser.equals(nameUserAc)){
                                    System.out.println("No existe usuario Logueado.");
                                } else {
                                    filesystemCreado.mkdir(newDirectory);
                                    System.out.println(filesystemCreado);
                                }
                                break;
                            case 2:
                                System.out.println("Ingresa el nombre del nuevo archivo.extension y luego presione ENTER");
                                String nameFile = input.next();
                                filesystemCreado.addFile(nameFile);
                                System.out.println(filesystemCreado);
                                break;
                            default:
                                System.out.println(" Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso4 != MENU_EXIT_OPTION_CASE_4);

                    break;

                case 5:
                    final int MENU_EXIT_OPTION_CASE_5 = 0;
                    int numeroIngreso5;
                    do {
                        printMenuCase5();
                        numeroIngreso5 = input.nextInt();
                        switch (numeroIngreso5) {
                            case 1:
                                System.out.println("Ingresa el nombre del archivo a eliminar y luego presione ENTER");
                                String nameFileDeleted = input.next();
                                filesystemCreado.del(nameFileDeleted);
                                System.out.println(filesystemCreado);
                                break;
                            case 2:
                                //copy
                                System.out.println("Ingresa el nombre del archivo a copiar y luego presione ENTER");
                                String nameFileCopy = input.next();
                                System.out.println("Ingresa la ruta de destino y luego presione ENTER");
                                String nameRutaFileCopy = input.next();
                                filesystemCreado.copy(nameFileCopy,nameRutaFileCopy);
                                System.out.println(filesystemCreado);
                                break;
                            case 3:
                                //move
                                System.out.println("Ingresa el nombre del archivo que quieres mover y luego presione ENTER");
                                String nameFileMove = input.next();
                                System.out.println("Ingresa la ruta de destino y luego presione ENTER");
                                String nameRutaFileMove = input.next();
                                filesystemCreado.move(nameFileMove,nameRutaFileMove);
                                System.out.println(filesystemCreado);
                                break;
                            case 4:
                                System.out.println("Ingresa el nombre del archivo que quieres renombrar y luego presione ENTER");
                                String nameFileOriginal = input.next();
                                System.out.println("Ingresa el nuevo nombre y luego presione ENTER");
                                String nameFileNew = input.next();
                                filesystemCreado.ren(nameFileOriginal,nameFileNew);
                                System.out.println(filesystemCreado);
                                break;
                            case 5:
                                System.out.println("Ingresa la palabra que quieres buscar y luego presione ENTER");
                                String pattern = input.next();
                                System.out.println("Ingresa el nombre del archivo donde quieres buscar y luego presione ENTER");
                                String pathFileName = input.next();
                                filesystemCreado.grep(pattern,pathFileName);
                                break;
                            case 6:
                                System.out.println("Ingresa el nombre del archivo/carpeta que deseas restaurar desde la papelera y luego presione ENTER");
                                String patternTrash = input.next();
                                filesystemCreado.restore(patternTrash);
                                System.out.println(filesystemCreado);

                            default:
                                System.out.println("Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso5 != MENU_EXIT_OPTION_CASE_5);

                    break;

                case 6:
                    Scanner listar = new Scanner(System.in);
                    System.out.println("Para listar contenido ingresa el parametro correspondiente y luego presione ENTER");
                    String params = listar.nextLine();
                    String palabraVacia = "\"\"";
                    // Parametros validos
                    List<String> dirActuySub = new ArrayList<>();
                    dirActuySub.add("/s");
                    dirActuySub.add("/a");

                    List<String> dirActuOculto = new ArrayList<>();
                    dirActuOculto.add("/a");

                    List<String> dirActu = new ArrayList<>();
                    dirActu.add("/s");

                    List<String> dirActuAlfaAs = new ArrayList<>();
                    dirActuAlfaAs.add("/o N");

                    List<String> dirFechaAsc = new ArrayList<>();
                    dirFechaAsc.add("/o D");

                    List<String> dirFechaDes = new ArrayList<>();
                    dirFechaDes.add("/o-D");

                    List<String> pregunta = new ArrayList<>();
                    pregunta.add("/?");


                    List<String> realParams = new ArrayList<>();

                    if (params.equals(palabraVacia)){
                        filesystemCreado.dir(realParams);
                        break;
                    }
                    if (params.contains(",")){
                        int largoParams = params.length();
                        String dosParams = params.substring(1,(largoParams-1));
                        int ubicacionComa = dosParams.indexOf(",");
                        int largoDosParams = dosParams.length();
                        String param1 = dosParams.substring(1,(ubicacionComa-1));
                        String param2 = dosParams.substring((ubicacionComa+2),(largoDosParams-1));
                        realParams.add(param1);
                        realParams.add(param2);
                        if (realParams.equals(dirActuySub)){
                            filesystemCreado.dir(dirActuySub);
                            break;
                        }
                        else {
                            System.out.println("Ingresa un parámetro correcto.");
                        }
                    }
                    if (params.contains("/")) {
                        int largoParams = params.length();
                        String paramToList = params.substring(2, (largoParams - 2));
                        realParams.add(paramToList);
                        if (realParams.equals(dirActuOculto)){
                            //System.out.println("Contiene A");
                            filesystemCreado.dir(dirActuOculto);
                            break;
                        }
                        if (realParams.equals(dirActu)){
                            //System.out.println("Contiene S");
                            filesystemCreado.dir(dirActu);
                            break;
                        }
                        if (realParams.equals(dirActuAlfaAs)){
                            //System.out.println("Contiene N");
                            filesystemCreado.dir(dirActuAlfaAs);
                            break;
                        }
                        if (realParams.equals(dirFechaAsc)){
                            filesystemCreado.dir(dirFechaAsc);
                            break;
                        }
                        if (realParams.equals(dirFechaDes)){
                            filesystemCreado.dir(dirFechaDes);
                            break;
                        }
                        if (realParams.equals(pregunta)){
                            filesystemCreado.dir(pregunta);
                            break;
                        }
                        else {
                            System.out.println("Ingresa un parametro correcto.");
                        }

                    }
                    else {
                        System.out.println("Ingresa un parametro correcto.");
                    }
                    break;
                case 7:
                    System.out.println("Listando contenido en Papelera: ");
                    filesystemCreado.viewTrash();
                    break;
                case 8:
                    System.out.println("Ingresa la letra del disco a formatear y luego presione ENTER");
                    String letterFormat = input.next();
                    System.out.println("Ingresa el nuevo nombre para el disco y luego presione ENTER");
                    String newNameDrive = input.next();
                    System.out.println(filesystemCreado);
                    filesystemCreado.format(letterFormat,newNameDrive);
                    System.out.println(filesystemCreado);

                    break;
                case 9:
                    final int MENU_EXIT_OPTION_CASE_9 = 0;
                    int numeroIngreso9;
                    do {
                        printMenuCase9();
                        numeroIngreso9 = input.nextInt();
                        switch (numeroIngreso9) {
                            case 1:
                                System.out.println("Ingresa la clave de encriptacion (DEBE CONTENER LETRAS Y NUMEROS) y luego presione ENTER");
                                String password = input.next();
                                System.out.println("Ingresa el nombre del archivo/carpeta a encriptar y luego presione ENTER");
                                String folderName = input.next();
                                int largoPassword = password.length();
                                if (largoPassword >= 6){
                                    System.out.println(filesystemCreado);
                                    filesystemCreado.encrypt(password,folderName);
                                    System.out.println(filesystemCreado);
                                    break;
                                }else{
                                    System.out.println("La contraseña DEBE contener minimo 6 caracteres.");
                                }
                                break;
                            case 2:
                                System.out.println("Ingresa la clave de desencriptacion (DEBE CONTENER LETRAS Y NUMEROS) y luego presione ENTER");
                                String passwordDes = input.next();
                                System.out.println("Ingresa el nombre del archivo/carpeta a desencriptar y luego presione ENTER");
                                String originalFolderName = input.next();
                                boolean banderaPassword = filesystemCreado.existePassword(passwordDes,originalFolderName);
                                if (banderaPassword == true){
                                    System.out.println(filesystemCreado);
                                    filesystemCreado.decrypt(passwordDes,originalFolderName);
                                    System.out.println(filesystemCreado);
                                }
                                if (banderaPassword == false){
                                    System.out.println("CONTRASEÑA INCORRECTA.");
                                }

                                break;
                            default:
                                System.out.println(" Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso9 != MENU_EXIT_OPTION_CASE_9);

                    break;
                case 0:
                    System.out.println("Bye.. Que la Fuerza te acompañe");
                    System.exit(0);
                    break;
                default:
                    System.out.println(choice + " is not a valid option! Please select correct option.");

            }
        } while (choice != MENU_EXIT_OPTION);
    }

    private static void printMenu() {
        System.out.println("----MENU SISTEMA----\n");
        System.out.print("1. Agregar una nueva unidad al sistema. \n");
        System.out.print("2. Registrar, iniciar o cerrar sesión de usuario. \n");
        System.out.print("3. Fijar y cambiar ruta.\n");
        System.out.print("4. Crear archivos o carpetas en el sistema.\n");
        System.out.print("5. Modificar, mover, eliminar o restaurar archivos/carpetas.\n");
        System.out.print("6. Listar contenido.\n");
        System.out.print("7. Listar contenido en Papelera. \n");
        System.out.print("8. Formatear una unidad. \n");
        System.out.print("9. Encriptar y desencriptar archivos/carpetas.\n");
        System.out.print("0. Exit.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase2() {
        System.out.println("----MENU USUARIOS----\n");
        System.out.print("1. Registrar un nuevo usuario. \n");
        System.out.print("2. Iniciar sesión con un usuario en el sistema.\n");
        System.out.print("3. Cerrar la sesión de un usuario en el sistema.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase3() {
        System.out.println("----MENU RUTA----\n");
        System.out.print("1. Fijar unidad en el sistema. \n");
        System.out.print("2. Cambiar directorio Actual fijado.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase4() {
        System.out.println("----MENU CREACIÓN ARCHIVOS/CARPETAS----\n");
        System.out.print("1. Crea una nueva carpeta. \n");
        System.out.print("2. Crear un nuevo archivo.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase5() {
        System.out.println("----MENU MODIFICAR ARCHIVOS/CARPETAS----\n");
        System.out.print("1. Eliminar un archivo o carpeta del sistema. \n");
        System.out.print("2. Copiar un archivo o carpeta del sistema.\n");
        System.out.print("3. Mover un archivo o carpeta del sistema.\n");
        System.out.print("4. Renombrar un archivo o carpeta.\n");
        System.out.print("5. Buscar una palabra dentro del contenido de un archivo.\n");
        System.out.print("5. Restaurar archivos de la papelera.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase9() {
        System.out.println("----MENU MODIFICAR ARCHIVOS/CARPETAS----\n");
        System.out.print("1. Encriptar archivo o carpeta. \n");
        System.out.print("2. Desencriptar archivo o carpeta.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }

}
