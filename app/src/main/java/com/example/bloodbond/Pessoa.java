package com.example.bloodbond;

import java.util.ArrayList;

public class Pessoa extends Cadastro {

    private String nome;
    private int tipoSanguineo, idade;    // "macros" de tipoSanguineo definidos em com.example.firebasetest.Instituicao.java
    private double peso, altura;

    private ArrayList<Doacao> doacoesAgendadas;
    private ArrayList<Doacao> doacoesPrevias;

    public Pessoa(){}

    public Pessoa(String email, String password, String nome, int tipoSanguineo, double peso, double altura, int idade){

        super(0, email, password);
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.altura = altura;
        this.doacoesAgendadas = new ArrayList<>();
        this.doacoesPrevias = new ArrayList<>();

    }

    @Override
    public String toString() {

        return  "Pessoa: " + "nome: " + this.nome + " " + this.doacoesAgendadas.toString();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
