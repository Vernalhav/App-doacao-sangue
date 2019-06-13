package com.example.bloodbond;

import java.io.Serializable;
import java.util.ArrayList;

public class Cadastro implements Serializable {

    // 0 = Pessoa, 1 = Intituicao
    private int registerType;
    private String email;

    public Cadastro(){}

    public Cadastro(int registerType, String email){
        this.registerType = registerType;
        this.email = email;
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

    @Override
    public String toString() {

        return  "Cadastros: " + "email: " + this.email;

    }

}
