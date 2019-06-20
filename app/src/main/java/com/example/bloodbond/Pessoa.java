package com.example.bloodbond;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class that represents a regular user.
 */
public class Pessoa extends Cadastro {

    /**
     * Blood type of the user. Uses macros from com.example.firebasetest.Instituicao.java.
     */
    private int tipoSanguineo;
    /**
     * Age of the user.
     */
    private int idade;
    /**
     * Weight of the user (kg).
     */
    private double peso;
    /**
     * Height of the user (cm).
     */
    private double altura;

    private ArrayList<Doacao> doacoesAgendadas;
    private ArrayList<Doacao> doacoesPrevias;

    /**
     * Empty constructor.
     */
    public Pessoa(){}

    /**
     * Class constructor.
     * @param email Email used to register the institution.
     * @param password Password of the institution, passed as plain-text will be stored as MD5.
     * @param nome Name of the institution.
     * @param tipoSanguineo Blood type of the user.
     * @param peso Weight of the user (kg).
     * @param altura Height of the user (cm).
     * @param idade Age of the user.
     */
    public Pessoa(String email, String password, String nome, int tipoSanguineo, double peso, double altura, int idade){

        super(0, email, password, nome);
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.altura = altura;
        this.doacoesAgendadas = new ArrayList<>();

        Doacao d1 = new Doacao(100,0,"a","insta", new Date(100000));
        Doacao d2 = new Doacao(150,0,"a","instb", new Date(200000));
        Doacao d3 = new Doacao(200,2,"b","instc", new Date(700000));
        Doacao d4 = new Doacao(350,3,"d","instd", new Date(300000));
        Doacao d5 = new Doacao(50,4,"c","inste", new Date(400000));

        doacoesAgendadas.add(d1);
        doacoesAgendadas.add(d2);
        doacoesAgendadas.add(d3);
        doacoesAgendadas.add(d4);
        doacoesAgendadas.add(d5);

        this.doacoesPrevias = new ArrayList<>();

    }

    public String getTipoSanguineoString(){
        String[] tipos = new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "0-"};
        return tipos[tipoSanguineo];
    }

    @Override
    public String toString() {

        return  "Pessoa: " + "nome: " + this.getName() + " " + this.doacoesAgendadas.toString();

    }

    public int getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(int tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public ArrayList<Doacao> getDoacoesAgendadas() {
        return doacoesAgendadas;
    }

    public void setDoacoesAgendadas(ArrayList<Doacao> doacoesAgendadas) {
        this.doacoesAgendadas = doacoesAgendadas;
    }

    public ArrayList<Doacao> getDoacoesPrevias() {
        return doacoesPrevias;
    }

    public void setDoacoesPrevias(ArrayList<Doacao> doacoesPrevias) {
        this.doacoesPrevias = doacoesPrevias;
    }

    public void BookDonation(Doacao doacao) {
        doacoesAgendadas.add(doacao);
        DatabaseManager.getInstance().UpdateUser(this);
    }

    public void AddPreviousDonation(Doacao doacao) {

        doacoesPrevias.add(doacao);
        // TODO: update on database.

    }

}