package org.example;

import java.util.List;

public interface FilesystemInterface_17325089_LizamaNunez {

    void addDrive (String letter, String nameDrive, int capacity);
    // Ir agregando métodos
    void register (String nameUser);

    void login (String nameUser);
    void logout();
    void switchDrive(String letterDriveFijo);
    void mkdir(String nameDirectory);
    void cd(String path);
    void addFile(String nameFile);
    void del(String fileName);
    void copy(String nameFile, String targetPath);
    void move(String nameFile, String targetPath);
    void ren(String currentName, String newName);
    void dir(List<String> params);
    void format(String letter, String newName);

}
