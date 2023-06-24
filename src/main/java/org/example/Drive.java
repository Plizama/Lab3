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
    public String getLetter() {
        return letter;
    }

    //Revisar si unidad existe
    //public boolean existeLetter ()
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", nameDrive='" + nameDrive + '\'' +
                ", capacity=" + capacity +
                '}';
    }


}
