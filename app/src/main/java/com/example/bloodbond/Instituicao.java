package com.example.bloodbond;

import java.io.Serializable;

public class Instituicao implements Serializable {
    private String nome, endereco;

    private static final int Ap = 0;
    private static final int An = 1;
    private static final int Bp = 2;
    private static final int Bn = 3;
    private static final int ABp = 4;
    private static final int ABn = 5;
    private static final int Op = 6;
    private static final int On = 7;

    private double[] qrSangue;  // array de 8 posicoes indexado pelos tipos sanguineos definidos acima
    //  ex: qtSangue[ABp] = 1002.1 (mL)

    public Instituicao() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static int getAp() {
        return Ap;
    }

    public static int getAn() {
        return An;
    }

    public static int getBp() {
        return Bp;
    }

    public static int getBn() {
        return Bn;
    }

    public static int getABp() {
        return ABp;
    }

    public static int getABn() {
        return ABn;
    }

    public static int getOp() {
        return Op;
    }

    public static int getOn() {
        return On;
    }

    public double[] getQrSangue() {
        return qrSangue;
    }

    public void setQrSangue(double[] qrSangue) {
        this.qrSangue = qrSangue;
    }
}
