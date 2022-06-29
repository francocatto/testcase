package br.eti.francocatto.testcase.model;

import br.eti.francocatto.testcase.model.pontuacao.CriterioPontuacao;

import java.util.ArrayList;
import java.util.List;

public class Familia implements Comparable<Familia> {

    private List<Pessoa> membros = new ArrayList<Pessoa>();

    private Integer pontuacao = 0;

    public void adicionar(Pessoa pessoa){
        if (pessoa != null)
            membros.add(pessoa);
    }

    public double getRendaTotal() {
        return membros.stream().filter(pessoa -> pessoa.isPretendente() || pessoa.isConjuge()).mapToDouble(p -> p.getRenda()).sum();
    }

    public Pessoa getPretendente() {
        return membros.stream().filter(pessoa -> pessoa.isPretendente()).findFirst().get();
    }

    public List<Pessoa> getDependentes() {
        return membros.stream().filter(pessoa -> pessoa.isDependente()).toList();
    }

    public void acumularPontos(Integer pontos) {
        this.pontuacao += pontos;
    }

    @Override
    public int compareTo(Familia outraFamilia) {
        return pontuacao.compareTo(outraFamilia.pontuacao);
    }
}
