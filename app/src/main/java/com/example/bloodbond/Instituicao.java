package com.example.bloodbond;

import android.os.Debug;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that represents an institution.
 */
public class Instituicao extends Cadastro implements Serializable {

    /**
     * Adress of the institution.
     */
    private String endereco;

    /**
     * Macro for blood type A+
     */
    public static final int Ap = 0;
    /**
     * Macro for blood type A-.
     */
    public static final int An = 1;
    /**
     * Macro for blood type B-.
     */
    public static final int Bp = 2;
    /**
     * Macro for blood type B-.
     */
    public static final int Bn = 3;
    /**
     * Macro for blood type AB+.
     */
    public static final int ABp = 4;
    /**
     * Macro for blood type AB-.
     */
    public static final int ABn = 5;
    /**
     * Macro for blood type 0+.
     */
    public static final int Op = 6;
    /**
     * Macro for blood type O-.
     */
    public static final int On = 7;

    private ArrayList<Double> qtSangue;  // array de 8 posicoes indexado pelos tipos sanguineos definidos acima
    //  ex: qtSangue.get(ABp) = 1002.1 (mL)

    /**
     * Empty constructor.
     */
    public Instituicao() {}

    public double getQtSangue(int tipo){
        return qtSangue.get(tipo);
    }

    /**
     * Class constructor.
     * @param email Email used to register the institution.
     * @param password Password of the institution, passed as plain-text will be stored as MD5.
     * @param nome Name of the institution.
     * @param endereco Address of the institution.
     * @param Ap Amount of A+ blood the institution needs.
     * @param An Amount of A- blood the institution needs.
     * @param Bp Amount of B+ blood the institution needs.
     * @param Bn Amount of B- blood the institution needs.
     * @param ABp Amount of AB+ blood the institution needs.
     * @param ABn Amount of AB- blood the institution needs.
     * @param Op Amount of O+ blood the institution needs.
     * @param On Amount of O- blood the institution needs.
     */
    public Instituicao(String email, String password, String nome, String endereco,
                       double Ap, double An, double Bp, double Bn, double ABp, double ABn, double Op, double On){

        super(1, email, password, nome);
        this.endereco = endereco;

        ArrayList<Double> qtSangue = new ArrayList<Double>();
        qtSangue.add(Ap); qtSangue.add(An);
        qtSangue.add(Bp); qtSangue.add(Bn);
        qtSangue.add(ABp); qtSangue.add(ABn);
        qtSangue.add(Op); qtSangue.add(On);

        this.qtSangue = qtSangue;

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

    public void UpdateStock(int bloodType, double increment) {

        double newQt = qtSangue.get(bloodType) + increment;
        qtSangue.set(bloodType, newQt);

        Log.d("qt", "qt: " + qtSangue.toString());

        DatabaseManager.getInstance().UpdateInstitution(this);
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
        qtSangue.add(this.Ap, Ap); qtSangue.add(this.An, An);
        qtSangue.add(this.Bp, Bp); qtSangue.add(this.Bn, Bn);
        qtSangue.add(this.ABp, ABp); qtSangue.add(this.ABn, ABn);
        qtSangue.add(this.Op, Op); qtSangue.add(this.On, On);
    }


}

