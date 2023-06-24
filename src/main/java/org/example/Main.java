package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 5;

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
                    System.out.println("Ingresando una nueva unidad al sistema");
                    System.out.println("Ingrese la letra de la nueva unidad y luego presione ENTER:");
                    String letterDrive= input.next();
                    System.out.println("Ingrese el nombre de la nueva unidad y luego presione ENTER:");
                    String nameDrive= input.next();
                    System.out.println("Ingrese la capacidad de la nueva unidad y luego presione ENTER:");
                    var capacityDrive= input.nextInt();
                    filesystemCreado.addDrive(letterDrive,nameDrive,capacityDrive);
                    System.out.println(filesystemCreado);
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("Sum 2 numbers");
                    System.out.println("Ingrese un número int y luego presione ENTER:");
                    var n1 = input.nextInt();
                    System.out.println("Ingrese otro número int y luego presione ENTER:");
                    var n2 = input.nextInt();
                    int sum = n1 + n2;
                    System.out.println("La suma es: " + sum);
                    break;

                case 4:
                    //do something
                    break;

                case 5:
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
        System.out.print("2. \n");
        System.out.print("3. Sum 2 numbers.\n");
        System.out.print("4. Some option.\n");
        System.out.print("5. Exit\n");
        System.out.print("\nIngresa tu opcion ");

    }
}