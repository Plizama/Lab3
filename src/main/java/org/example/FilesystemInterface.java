package org.example;

public interface FilesystemInterface {

    void addDrive (String letter, String nameDrive, int capacity);
    // Ir agregando métodos
    void register (String nameUser);

    void login (String nameUser);
    void logout();
    void switchDrive(String letterDriveFijo);
    void mkdir(String nameDirectory);
}
