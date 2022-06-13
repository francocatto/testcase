package br.eti.francocatto.testcase.model.pontuacao;

import br.eti.francocatto.testcase.model.Familia;

public class PontuarComRendaAte900 extends CriterioPontuacao{
    @Override
    public void confrontarCriterioEAtualizarPontuacao(Familia familia) {
        if (familia.getRendaTotal() <= 900)
            familia.acumularPontos(5);
        if(sucessor !=null)
        sucessor.confrontarCriterioEAtualizarPontuacao(familia);
    }
}
