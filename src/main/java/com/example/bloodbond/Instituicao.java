package com.example.bloodbond;

import java.util.ArrayList;

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

    private ArrayList<Double> qtSangue;  // array de 8 posicoes indexado pelos tipos sanguineos definidos acima
    //  ex: qtSangue[ABp] = 1002.1 (mL)

    public Instituicao() {}

    public Instituicao(String email, String password, String nome, String endereco){
        super(1, email, password);

        this.nome = nome;
        this.endereco = endereco;

        ArrayList<Double> qtSangue = new ArrayList<Double>();

        this.qtSangue = qtSangue;
    }

    public Instituicao(String email, String password, String nome, String endereco,
                       double Ap, double An, double Bp, double Bn, double ABp, double ABn, double Op, double On){

        super(1, email, password);

        this.nome = nome;
        this.endereco = endereco;

        ArrayList<Double> qrSangue = new ArrayList<Double>();
        qrSangue.add(Ap); qrSangue.add(An);
        qrSangue.add(Bp); qrSangue.add(Bn);
        qrSangue.add(ABp); qrSangue.add(ABn);
        qrSangue.add(Op); qrSangue.add(On);

        this.qtSangue = qrSangue;
    }

    /**
     * Inicializa o vetor de sangue
     * com as quantidades passadas
     * por parametro
     * @param Ap
     * @param An
     * @param Bp
     * @param Bn
     * @param ABp
     * @param ABn
     * @param Op
     * @param On
     */
    public void insereQtSangue(double Ap, double An, double Bp, double Bn, double ABp, double ABn, double Op, double On){
        qtSangue.add(Ap); qtSangue.add(An);
        qtSangue.add(Bp); qtSangue.add(Bn);
        qtSangue.add(ABp); qtSangue.add(ABn);
        qtSangue.add(Op); qtSangue.add(On);
    }

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

    public ArrayList<Double> getQtSangue() {
        return qtSangue;
    }

    public void setQtSangue(ArrayList<Double> qtSangue) {
        this.qtSangue = qtSangue;
    }
}
