package org.example;

import java.util.ArrayList;
import java.util.List;

public class Trash_17325089_LizamaNunez {
    private List<Drive_17325089_LizamaNunez> drives;
    private List<Folder_17325089_LizamaNunez> folders;
    private List<FileAbs_17325089_LizamaNunez> files;

    public Trash_17325089_LizamaNunez() {
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }


    public void addDrivesTrash(Drive_17325089_LizamaNunez driveDeleted){
        drives.add(driveDeleted);
    }
    public void addFolderTrash(Folder_17325089_LizamaNunez folderDeleted){
        folders.add(folderDeleted);
    }

    public void addFileTrash(FileAbs_17325089_LizamaNunez fileDeleted){
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
