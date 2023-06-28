package org.example;
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
        Filesystem filesystemCreado = new Filesystem(nameSystem);
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

                    List<Drive> listaDrives = filesystemCreado.getDrives();
                    boolean bandera = filesystemCreado.existeLEtter(listaDrives,letterDrive);
                    if(bandera == true){
                        System.out.println("La letra de la unidad se encuentra repetida, intenta nuevamente.");
                    } else{
                        filesystemCreado.addDrive(letterDrive,nameDrive,capacityDrive);
                        System.out.println(filesystemCreado);
                    }
                    break;

                case 2:
                    System.out.println("---Ingresando un nuevo usuario al sistema---");
                    System.out.println("Ingrese el nombre del usuario y luego presione ENTER:");
                    String nameUser= input.next();

                    List<User> listaUsuarios = filesystemCreado.getUsers();
                    boolean banderaUsers = filesystemCreado.existeUser(listaUsuarios, nameUser);
                    if(banderaUsers == true){
                        System.out.println("El nombre de usuario ya se encuentra registrado, intenta con uno nuevo.");
                    } else{
                        filesystemCreado.register(nameUser);
                        System.out.println(filesystemCreado);
                    }

                    break;

                case 3:
                    System.out.println("---Logueando un usuario en el sistema---");
                    System.out.println("Ingrese el nombre del usuario a loguear y luego presione ENTER:");
                    String nameUserLog= input.next();

                    List<User> listaUsuariosIngresados = filesystemCreado.getUsers();
                    boolean Userbandera = filesystemCreado.existeUser(listaUsuariosIngresados, nameUserLog);
                    if(Userbandera == true){
                        filesystemCreado.login(nameUserLog);
                        System.out.println(filesystemCreado);
                    } else{
                        System.out.println("El nombre del usuario no existe, intenta con un usuario existente.");
                    }

                    break;

                case 4:
                    System.out.println("---Cerrando la sesion del usuario actual en el sistema---");
                    filesystemCreado.logout();
                    System.out.println("--Sesión cerrada.");

                    break;

                case 5:
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
                case 6:
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

                case 7:
                    System.out.println("Ingresa simbolo o nueva ruta y luego presione ENTER");
                    String path = input.next();
                    filesystemCreado.cd(path);
                    System.out.println(filesystemCreado);



                    //char caracter= input.next().charAt(0);

                    break;
                case 8:
                    //
                    break;
                case 9:
                    //
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
        System.out.print("2. Registrar un nuevo usuario en el sistema. \n");
        System.out.print("3. Iniciar sesión con un usuario en el sistema.\n");
        System.out.print("4. Cerrar la sesión de un usuario en el sistema\n");
        System.out.print("5. Ingresar una dirección para fijar\n");
        System.out.print("6. Crea una nueva carpeta\n");
        System.out.print("7. Cambiar directorio Actual \n");
        System.out.print("0. Exit\n");
        System.out.print("\nIngresa tu opcion ");
    }

}
