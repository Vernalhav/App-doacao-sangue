package com.example.bloodbond;

import java.io.Serializable;

public class Doacao implements Serializable {

    private double qtDoacao;    // em mL
    private Instituicao instDestino;
    private int tipoSanguineo;  // "macros" definidos em com.example.firebasetest.Instituicao.java

    public Doacao(){}

    public Doacao(double qtDoacao, int tipoSanguineo, Instituicao inst) {
        this.qtDoacao = qtDoacao;
        this.instDestino = inst;
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getQtDoacao() {
        return qtDoacao;
    }

    public void setQtDoacao(double qtDoacao) {
        this.qtDoacao = qtDoacao;
    }

    public Instituicao getInstDestino() {
        return instDestino;
    }

    public void setInstDestino(Instituicao instDestino) {
        this.instDestino = instDestino;
    }

    public int getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(int tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}
