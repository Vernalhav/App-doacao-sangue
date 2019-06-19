package com.example.bloodbond;

import java.io.Serializable;

/**
 * Abstract class for basic account functionality.
 */
public abstract class Cadastro implements Serializable {

    /**
     * Type of the account. 0 = Pessoa, 1 = Intituicao
      */
    private int registerType;
    /**
     * Email for the account.
     */
    private String email;
    /**
     * Password of the account registered as MD5.
     */
    private String password;

    /**
     * Name of the account.
     */
    private String name;

    /**
     * Empty constructor.
     */
    public Cadastro(){}

    /**
     * Constructor for the class.
     * @param registerType Type of the account. 0 = Pessoa, 1 = Intituicao
     * @param email Email for the account.
     * @param password Password for the account, passed as plain-text stored as MD5.
     * @param name Name for the account.
     */
    public Cadastro(int registerType, String email, String password, String name){
        this.registerType = registerType;
        this.email = email;
        this.password = DatabaseManager.getMd5(password);
        this.name = name;
    }

    public int getRegisterType() {
        return registerType;
    }
    public void SetRegisterType(int registerType) {
        this.registerType = registerType;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return  "Cadastros: " + "email: " + this.email;

    }

}
