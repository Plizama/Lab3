package org.example;

public class Drive {
    private String letter;
    private String nameDrive;
    private int capacity;


    public Drive(String letter, String nameDrive, int capacity) {
        this.letter = letter;
        this.nameDrive = nameDrive;
        this.capacity = capacity;
    }

    //Revisar si unidad existe
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", nameDrive='" + nameDrive + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
