package com.example.bloodbond;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cadastro implements Serializable {

    // 0 = Pessoa, 1 = Intituicao
    private int registerType;
    private String email;
    private String password;

    public Cadastro(){}

    public Cadastro(int registerType, String email, String password){
        this.registerType = registerType;
        this.email = email;
        this.password = DatabaseManager.getMd5(password);
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

    @Override
    public String toString() {

        return  "Cadastros: " + "email: " + this.email;

    }

}
