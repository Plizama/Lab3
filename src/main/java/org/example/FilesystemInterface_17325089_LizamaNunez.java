package org.example;

import java.util.List;

public interface FilesystemInterface_17325089_LizamaNunez {

    /**
     * RF4 AddDrive: metodo abstracto permite añadir una unidad al sistema.
     * @param letter : String letra Unidad
     * @param nameDrive : String nombre unidad
     * @param capacity : int capacidad unidad
     */
    void addDrive (String letter, String nameDrive, int capacity);

    /**
     * RF5 register: Metodo abstracto permite registra un nuevo usuario al sistema.
     * @param nameUser : String nombre del usuario.
     */
    void register (String nameUser);

    /**
     * RF6 login: Metodo abstracto permite iniciar sesion con un usuario.
     * @param nameUser : String nombre usuario
     */
    void login (String nameUser);

    /**
     * RF7 logout: Metodo abstracto permite cerrar la sesion de un usuario.
     */
    void logout();

    /**
     * RF8 switchDrive: Metodo abstracto permite fijar unidad para realizar acciones.
     * @param letterDriveFijo : String letra unidad fijada.
     */
    void switchDrive(String letterDriveFijo);

    /**
     * RF9 mkdir: Metodo abstracto permite crear un directorio.
     * @param nameDirectory : String nombre directorio
     */
    void mkdir(String nameDirectory);

    /**
     * RF10 cd: Metodo abstracto permite cambiar la ruta actual.
     * @param path : String ruta o comodin especial.
     */
    void cd(String path);

    /**
     * RF11 addFile: Metodo abstracto que permite añadir un archivo.
     * @param nameFile : String nombre del archivo creado.
     */
    void addFile(String nameFile);

    /**
     * RF12 del: Metodo abstracto que permite eliminar un archivo.
     * @param fileName : String nombre de archivo o comodin especial.
     */
    void del(String fileName);

    /**
     * RF13 copy: Metodo abstracto para copiar un archivo o carpeta.
     * @param nameFile : String nombre archivo.
     * @param targetPath : String ruta destino copia archivo.
     */
    void copy(String nameFile, String targetPath);

    /**
     * RF14 move: Metodo abstracto para mover un archivo o carpeta.
     * @param nameFile : String nombr archivo.
     * @param targetPath : String ruta destino archivo.
     */
    void move(String nameFile, String targetPath);

    /**
     * RF15 ren: Metodo abstracto para renombrar una carpeta o archivo
     * @param currentName : String nombre original.
     * @param newName : String nuevo nombre.
     */
    void ren(String currentName, String newName);

    /**
     * RF16 dir: Metodo abstracto para listar el contenido de un directorio.
     * @param params : ArrayList String parametros.
     */
    void dir(List<String> params);

    /**
     * RF17 format: Metodo abstracto para formatear una unidad.
     * @param letter : String letra unidad.
     * @param newName : String nuevo nombre unidad.
     */
    void format(String letter, String newName);

    /**
     * RF18 encrypt: Metodo abstracto para encriptar un archivo o carpeta.
     * @param password : String Password
     * @param folderName : String nombre archivo a encriptar.
     */
    void encrypt(String password, String folderName);

    /**
     * RF19 decrypt: Metodo abstracto para desencriptar un archivo o carpeta.
     * @param password : String Password
     * @param folderName : String nombre archivo a desencriptar.
     */
    void decrypt(String password, String folderName);

    /**
     * RF20 grep: Metodo abstracto que permite buscar una palabra dentro de un contenido de archivos.
     * @param pattern : String palabra buscada.
     * @param path : String archivo donde buscar o comodin.
     */
    void grep(String pattern, String path);

    /**
     * RF21 viewTrash: Metodo abstracto para listar el contenido de la papelera de reciclaje.
     */
    void viewTrash();

    /**
     * RF22 restore: Metodo abstracto para restaurar archivos desde la papelera.
     * @param pattern : String nombre de archio o comodin.
     */
    void restore(String pattern);



}
