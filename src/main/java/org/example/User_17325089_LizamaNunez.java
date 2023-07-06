package org.example;

public class User_17325089_LizamaNunez {
    private String nameUser;
    private boolean login;

    /**
     * TDA constructor de User
     * @param nameUser : String nombre de user
     */
    public User_17325089_LizamaNunez(String nameUser) {
        this.nameUser = nameUser;
        this.login = false;
    }

    /**
     * TDA selector nombre de user
     * @return : String nombre de user
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * TDA modificador de login
     * @param login : boolean cambia estado de boolean en user
     */
    public void setLogin(boolean login) {
        this.login = login;
    }

    /**
     * TDA selector estado login user
     * @return : boolean estado
     */
    public boolean isLogin() {
        return login;
    }
    /**
     * Metodo imprime datos guardados en formato String.
     * @return : String datos User
     */
    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", login=" + login +
                '}';
    }


}
