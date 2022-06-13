package br.eti.francocatto.testcase.model.pontuacao;

import br.eti.francocatto.testcase.model.Familia;
import br.eti.francocatto.testcase.model.Pessoa;

import java.util.List;

public class PontuarComMaisDe3Dependentes extends CriterioPontuacao {
    @Override
    public void confrontarCriterioEAtualizarPontuacao(Familia familia) {
        List<Pessoa> dependentes = familia.getDependentes();
        if (!dependentes.isEmpty() && dependentes.size() >= 3)
            familia.acumularPontos(3);
        if(sucessor !=null)
            sucessor.confrontarCriterioEAtualizarPontuacao(familia);
    }
}
