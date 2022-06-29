package br.eti.francocatto.testcase.model.pontuacao;

import br.eti.francocatto.testcase.model.Familia;
import br.eti.francocatto.testcase.model.Pessoa;

import java.util.List;

public class PontuarCom1Ou2Dependentes extends CriterioPontuacao{

    @Override
    public void confrontarCriterioEAtualizarPontuacao(Familia familia) {
        List<Pessoa> dependentes = familia.getDependentes();
        if (dependentes!= null && !dependentes.isEmpty() && (dependentes.size() >= 1 || dependentes.size() <= 2)) {
            familia.acumularPontos(2);
        }
        if(sucessor !=null)
            sucessor.confrontarCriterioEAtualizarPontuacao(familia);
    }
}
