package com.example.bloodbond;

public class Instituicao extends Cadastro {
    private String nome, endereco;

    public static final int Ap = 0;
    public static final int An = 1;
    public static final int Bp = 2;
    public static final int Bn = 3;
    public static final int ABp = 4;
    public static final int ABn = 5;
    public static final int Op = 6;
    public static final int On = 7;

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
