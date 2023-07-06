package org.example;

public class Drive_17325089_LizamaNunez {
    private String letter;
    private String nameDrive;
    private int capacity;


    /**
     * TDA Constructor clase Drive.
     * @param letter : corresponde a letra asociada al Drive.
     * @param nameDrive : corresponde al nombre asociado al Drive.
     * @param capacity : indica la capacidad del Drive.
     */
    public Drive_17325089_LizamaNunez(String letter, String nameDrive, int capacity) {
        this.letter = letter;
        this.nameDrive = nameDrive;
        this.capacity = capacity;
    }

    /**
     * TDA Selector letter Drive
     * @return : letter clase Drive.
     */
    public String getLetter() {
        return letter;
    }

    /**
     * TDA selector capacidad Drive.
     * @return: capacidad Drive.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Metodo imprime datos guardados en formato String.
     * @return : Datos Drive en String.
     */
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", nameDrive='" + nameDrive + '\'' +
                ", capacity=" + capacity +
                '}';
    }



}
