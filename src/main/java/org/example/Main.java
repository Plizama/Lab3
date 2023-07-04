package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Filesystem newsystem = new Filesystem("La prueba");
        //System.out.println(newsystem);

        //newsystem.addDrive("C","Hola", 200);
        //System.out.println(newsystem);
        //newsystem.addDrive("D","chao", 600);
        //System.out.println(newsystem);
        //newsystem.addDrive("C","cruzodedos", 200);
        //System.out.println(newsystem);
        //List<Drive> drivesprueba = newsystem.getDrives();
        //System.out.println(drivesprueba);
        //System.out.println(drivesprueba.size());
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 0;

        int choice;

        System.out.println("---------PARA INICIAR CREA UN NUEVO SISTEMA----------");
        System.out.println("Ingrese el nombre del nuevo sistema y luego presione ENTER:");
        String nameSystem = input.next();
        Filesystem_17325089_LizamaNunez filesystemCreado = new Filesystem_17325089_LizamaNunez(nameSystem);
        //System.out.println(filesystemCreado);

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

                case 4:
                    System.out.println("Ingresa simbolo o nueva ruta y luego presione ENTER");
                    String path = input.next();
                    filesystemCreado.cd(path);
                    System.out.println(filesystemCreado);
                    break;

                case 5:
                    //Scanner opcionCase5 = new Scanner(System.in);
                    final int MENU_EXIT_OPTION_CASE_5 = 0;
                    int numeroIngreso5;
                    do {
                        printMenuCase5();
                        numeroIngreso5 = input.nextInt();
                        switch (numeroIngreso5) {
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
                    } while (numeroIngreso5 != MENU_EXIT_OPTION_CASE_5);

                    break;
                case 6:
                    final int MENU_EXIT_OPTION_CASE_6 = 0;
                    int numeroIngreso6;
                    do {
                        printMenuCase6();
                        numeroIngreso6 = input.nextInt();
                        switch (numeroIngreso6) {
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
                            default:
                                System.out.println("Volviendo a menu anterior.");
                        }
                    } while (numeroIngreso6 != MENU_EXIT_OPTION_CASE_6);

                    break;
                case 7:
                    //ARREGLAR INGRESO DE PARAMETROS
                    System.out.println("Para listar contenido ingresa el parametro correspondiente y luego presione ENTER");
                    System.out.println("En caso de NO conocer el parametro correspondiente ingrese: ");
                    System.out.println("/?");
                    String params = input.next();
                    String transfParam1 = "[]"
                    List<String> realParams = new ArrayList<>();
                    if(params.contains(",")){
                        int largoParams = params.length();
                        String dosParams = params.substring(1,(largoParams-1));
                        int ubicacionComa = dosParams.indexOf(",");
                        int largoDosParams = dosParams.length();
                        String param1 = dosParams.substring(0,ubicacionComa);
                        String param2 = dosParams.substring((ubicacionComa+1),largoDosParams);
                        realParams.add(param1);
                        realParams.add(param2);
                    }else {
                        if(params.contains("/")){
                            int largoParams = params.length();
                            String paramToList = params.substring(2,(largoParams-2));
                            realParams.add(paramToList);
                        }else{
                            String actual = "";
                            realParams.add(actual);
                        }

                    }
                    //System.out.println(realParams);
                    filesystemCreado.dir(realParams);

                    break;
                case 8:
                    //
                    break;
                case 9:
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
        System.out.print("3. Ingresar una dirección para fijar sistema.\n");
        System.out.print("4. Cambiar directorio Actual fijado.\n");
        System.out.print("5. Crear archivos o carpetas en el sistema.\n");
        System.out.print("6. Modificar, mover o eliminar archivos/carpetas.\n");
        System.out.print("7. Listar contenido. \n");
        System.out.print("8. . \n");
        System.out.print("9. Eliminar un archivo del sistema. \n");
        System.out.print("0. Exit.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase2() {
        System.out.println("----MENU USUARIOS----\n");
        System.out.print("1. Registrar un nuevo usuario. \n");
        System.out.print("2. Iniciar sesión con un usuario en el sistema.\n");
        System.out.print("3. Cerrar la sesión de un usuario en el sistema.\n");
        //System.out.print("4. Cerrar la sesión de un usuario en el sistema.\n");
        //System.out.print("5. Ingresar una dirección para fijar.\n");
        //System.out.print("6. Crea una nueva carpeta.\n");
        //System.out.print("7. Cambiar directorio Actual. \n");
        //System.out.print("8. Agregar un nuevo archivo. \n");
        //System.out.print("9. Eliminar un archivo del sistema. \n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase5() {
        System.out.println("----MENU CREACIÓN ARCHIVOS/CARPETAS----\n");
        System.out.print("1. Crea una nueva carpeta. \n");
        System.out.print("2. Crear un nuevo archivo.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }
    private static void printMenuCase6() {
        System.out.println("----MENU MODIFICAR ARCHIVOS/CARPETAS----\n");
        System.out.print("1. Eliminar un archivo o carpeta del sistema. \n");
        System.out.print("2. Copiar un archivo o carpeta del sistema.\n");
        System.out.print("3. Mover un archivo o carpeta del sistema.\n");
        System.out.print("4. Renombrar un archivo o carpeta.\n");
        //System.out.print("5. grep.\n");
        //System.out.print("5. restore.\n");
        System.out.print("0. Regresar a menu principal.\n");
        System.out.print("\nIngresa tu opcion : ");
    }

}
