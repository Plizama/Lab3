package org.example;

import java.util.ArrayList;
import java.util.List;

public class Trash_17325089_LizamaNunez {
    private List<Drive_17325089_LizamaNunez> drives;
    private List<Folder_17325089_LizamaNunez> folders;
    private List<FileAbs_17325089_LizamaNunez> files;

    /**
     * TDA constructor trash
     */
    public Trash_17325089_LizamaNunez() {
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    /**
     * Metodo agregar drive al arrayList de drive en trash
     * @param driveDeleted : drive a agregar
     */
    public void addDrivesTrash(Drive_17325089_LizamaNunez driveDeleted){

        drives.add(driveDeleted);
    }

    /**
     * Metodo agregar folder al arrayList de folder en trash
     * @param folderDeleted : Folder a agregar
     */
    public void addFolderTrash(Folder_17325089_LizamaNunez folderDeleted){

        folders.add(folderDeleted);
    }

    /**
     * Metodo agregar File al arrayList de File en trash
     * @param fileDeleted : File a agregar
     */
    public void addFileTrash(FileAbs_17325089_LizamaNunez fileDeleted){
        files.add(fileDeleted);
    }

    /**
     * TDA selector ArrayList Folder
     * @return : ArrayList Folder
     */
    public List<Folder_17325089_LizamaNunez> getFolders() {
        return folders;
    }

    /**
     * TDA selector ArrayList Files
     * @return: ArrayList Files
     */
    public List<FileAbs_17325089_LizamaNunez> getFiles() {
        return files;
    }

    /**
     * TDA modificador de Files
     * @param newList : agrega nuevo ArrayList de File
     */
    public void setFiles(List<FileAbs_17325089_LizamaNunez> newList){
        this.files = newList;
    }

    /**
     * TDA modificador de Folder
     * @param newFolders : agrega nuevo ArrayList de Folder
     */
    public void setFolders(List<Folder_17325089_LizamaNunez> newFolders){
        this.folders = newFolders;
    }
    /**
     * Metodo imprime datos guardados en formato String.
     * @return : String datos Trash
     */
    @Override
    public String toString() {
        return "Trash{" +
                "drives=" + drives +
                ", folders=" + folders +
                ", files=" + files +
                '}';
    }


}
