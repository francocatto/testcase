package br.eti.francocatto.testcase.model;

import br.eti.francocatto.testcase.model.auxiliar.CPF;

public class Pessoa {
    private Double renda;
    private final Vinculo vinculo;
    private final Integer idade;
    private final String nome;

    private final br.eti.francocatto.testcase.model.auxiliar.CPF CPF;

    public Pessoa(String nome, Integer idade, Double renda, Vinculo vinculo, CPF CPF) {
        this.nome = nome;
        this.idade = idade;
        this.renda = renda;
        this.vinculo = vinculo;
        this.CPF = CPF;
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
        if (((!isMaiorDeIdade() && isFilho()) || isConjuge()) && !hasRenda())
            return true;
        return false;
    }

    private boolean hasRenda() {
        return getRenda() > 0.0 ? true : false;
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
    @Override
    public int hashCode() {
        return this.CPF.hashCode();
    }
    public CPF getCPF() {
        return this.CPF;
    }
}
