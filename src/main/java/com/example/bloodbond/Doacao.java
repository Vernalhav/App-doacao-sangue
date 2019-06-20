package com.example.bloodbond;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Doacao implements Serializable {

    private double qtDoacao;    // em mL
    private Instituicao instDestino;
    private Pessoa doador;
    private int tipoSanguineo;  // "macros" definidos em com.example.firebasetest.Instituicao.java
    private Date data;

    public Doacao(){}

    public Doacao(double qtDoacao, int tipoSanguineo, Pessoa doador, Instituicao inst, Date data) {
        this.qtDoacao = qtDoacao;
        this.doador = doador;
        this.instDestino = inst;
        this.tipoSanguineo = tipoSanguineo;
        this.data = data;
    }

    public Pessoa getDoador() {
        return doador;
    }

    public void setDoador(Pessoa doador) {
        this.doador = doador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    /**
     * Funcao que determina se
     * a doacao já foi realizada
     * no tempo presente
     * @return se a dooacao foi realizada
     */
    public boolean jaFoi(){
        return data.compareTo(Calendar.getInstance().getTime()) <= 0;
    }
}
