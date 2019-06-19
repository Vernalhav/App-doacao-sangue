package com.example.bloodbond;

import java.io.Serializable;

/**
 * Class that represents a blood donation.
 */
public class Doacao implements Serializable {

    /**
     * Amount of blood from the donation (mL)
     */
    private double qtDoacao;
    /**
     * Destination of the donation.
     */
    private Instituicao instDestino;
    /**
     * Blood type, macros defined in com.example.firebasetest.Instituicao.java
     */
    private int tipoSanguineo;

    public Doacao() {}

    /**
     * Class constructor.
     * @param qtDoacao Amount of blood donated.
     * @param tipoSanguineo Blood type.
     * @param inst Target institution.
     */
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
