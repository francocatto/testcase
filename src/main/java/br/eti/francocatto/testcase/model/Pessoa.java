package br.eti.francocatto.testcase.model;

public class Pessoa {
    private Double renda;
    private final Vinculo vinculo;
    private final Integer idade;
    private final String nome;

    public Pessoa(String nome, Integer idade, Double renda, Vinculo vinculo) {
        this.nome = nome;
        this.idade = idade;
        this.renda = renda;
        this.vinculo = vinculo;
    }

    public void atualizarRenda(Double novaRenda) {
        this.renda = novaRenda;
    }

    public double getRenda() {
        return this.renda;
    }

    public boolean isPretendente() {
        return this.vinculo.equals(Vinculo.PRETENDENTE);
    }

    public boolean isDependente() {
        if (!isMaiorDeIdade() && isFilho() && !hasRenda())
            return true;
        return false;
    }

    private boolean hasRenda() {
        return getRenda() > 0 ? true : false;
    }

    private boolean isFilho() {
        return this.vinculo.equals(Vinculo.FILHO);
    }

    private boolean isMaiorDeIdade() {
        return this.idade >= 18;
    }

    public boolean isConjuge() {
        return this.vinculo.equals(Vinculo.CONJUGE);
    }

    public String getNome() {
        return this.nome;
    }
}
