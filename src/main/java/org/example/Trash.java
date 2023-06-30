package org.example;

import java.util.ArrayList;
import java.util.List;

public class Trash  {
    private List<Drive> drives;
    private List<Folder> folders;
    private List<FileAbs> files;

    public Trash() {
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }


    public void addDrivesTrash(Drive driveDeleted){
        drives.add(driveDeleted);
    }
    public void addFolderTrash(Folder folderDeleted){
        folders.add(folderDeleted);
    }

    public void addFileTrash(FileAbs fileDeleted){
        files.add(fileDeleted);
    }


    @Override
    public String toString() {
        return "Trash{" +
                "drives=" + drives +
                ", folders=" + folders +
                ", files=" + files +
                '}';
    }
}
