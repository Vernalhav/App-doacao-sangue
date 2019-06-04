import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int tipoSanguineo, idade;    // "macros" de tipoSanguineo definidos em Instituicao.java
    private double peso, altura;

    private ArrayList<Doacao> doacoesAgendadas;
    private ArrayList<Doacao> doacoesPrevias;

    public Pessoa(String nome, int tipoSanguineo, double peso, double altura, int idade){
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.altura = altura;
        this.doacoesAgendadas = new ArrayList<>();
        this.doacoesPrevias = new ArrayList<>();
    }
}
