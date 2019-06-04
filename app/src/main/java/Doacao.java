

public class Doacao {

    private double qtDoacao;    // em mL
    private Instituicao instDestino;
    private int tipoSanguineo;  // "macros" definidos em Instituicao.java

    public Doacao(double qtDoacao, int tipoSanguineo, Instituicao inst) {
        this.qtDoacao = qtDoacao;
        this.instDestino = inst;
        this.tipoSanguineo = tipoSanguineo;
    }
}
