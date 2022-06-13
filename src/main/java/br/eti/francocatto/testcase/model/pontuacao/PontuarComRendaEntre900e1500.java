package br.eti.francocatto.testcase.model.pontuacao;

import br.eti.francocatto.testcase.model.Familia;

public class PontuarComRendaEntre900e1500 extends CriterioPontuacao{
    @Override
    public void confrontarCriterioEAtualizarPontuacao(Familia familia) {
            double rendaTotal = familia.getRendaTotal();
            if (rendaTotal > 900 && rendaTotal <= 1500)
                familia.acumularPontos(3);
        if(sucessor !=null)
            sucessor.confrontarCriterioEAtualizarPontuacao(familia);
    }
}
