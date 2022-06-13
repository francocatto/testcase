package br.eti.francocatto.testcase.model.pontuacao;

import br.eti.francocatto.testcase.model.Familia;

public abstract class CriterioPontuacao {

    public abstract void confrontarCriterioEAtualizarPontuacao(Familia familia);

    protected CriterioPontuacao sucessor;

    public CriterioPontuacao sucessor(CriterioPontuacao sucessor) {
        this.sucessor = sucessor;
        return this.sucessor;
    }
}
