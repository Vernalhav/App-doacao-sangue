package com.example.bloodbond;

import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Class that represents a blood donation.
 */
public class Doacao implements Serializable {

    /**
     * Amount of blood from the donation (mL)
     */
    private double qtDoacao;

    /**
     * Name of the donator.
     */
    private String emailIdInst;

    /**
     * Blood type, macros defined in com.example.firebasetest.Instituicao.java
     */
    private int tipoSanguineo;

    /**
     * Name of the donator.
     */
    private String emailIdDoador;

    /**
     * Date of the donation.
     */
    private Date data;

    public Doacao() {}

    /**
     * Class constructor.
     * @param qtDoacao Amount of blood donated.
     * @param tipoSanguineo Blood type.
     * @param emailDoador Name of the donator.
     * @param emailInstituicao Target institution.
     * @param data Date of the donation.
     */
    public Doacao(double qtDoacao, int tipoSanguineo, String emailDoador, String emailInstituicao, Date data) {

        this.qtDoacao = qtDoacao;
        this.emailIdDoador = DatabaseManager.EmailToKey(emailDoador);
        this.emailIdInst = DatabaseManager.EmailToKey(emailInstituicao);
        this.tipoSanguineo = tipoSanguineo;
        this.data = data;
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

    public String getEmailIdInst() {
        return emailIdInst;
    }

    public void setEmailIdInst(String emailIdInst) {
        this.emailIdInst = emailIdInst;
    }

    public String getEmailIdDoador() {
        return emailIdDoador;
    }

    public void setEmailIdDoador(String emailIdDoador) {
        this.emailIdDoador = emailIdDoador;
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

    /**
     * Altera o horário da
     * doação para os parametros
     * especificados
     * @param hora
     * @param minuto
     */
    public void alteraHorario(int hora, int minuto){
        Log.d("DEBUG", "alteraHorario: HORARIO ANTIGO " + data.getTime());
        data.setTime( data.getTime() + 60000*minuto + 3600000*hora );
        Log.d("DEBUG", "alteraHorario: HORARIO NOVO " + data.getTime());
    }
    @Override
    public String toString() {
        String s;
        s ="\n" + data + "\n";
        s += "\nDoou ";
        s += qtDoacao + "ml";
        s += " para\n";
        s += emailIdInst + "\n";
        return s;
    }
}