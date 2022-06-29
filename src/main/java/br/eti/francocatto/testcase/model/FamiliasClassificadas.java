package br.eti.francocatto.testcase.model;

import br.eti.francocatto.testcase.model.pontuacao.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamiliasClassificadas  {

    private List<Familia> familiasClassificadas;

    public FamiliasClassificadas(List<Familia> familias) {

        this.familiasClassificadas = familias;

        CriterioPontuacao cadeiaDeCriteriosDePontuacao = new PontuarComRendaAte900();
        cadeiaDeCriteriosDePontuacao.sucessor(new PontuarComRendaEntre900e1500()).
                sucessor(new PontuarCom1Ou2Dependentes()).
                sucessor(new PontuarComMaisDe3Dependentes());

        for (Familia familia : this.familiasClassificadas) {
            cadeiaDeCriteriosDePontuacao.confrontarCriterioEAtualizarPontuacao(familia);
        }
        Collections.sort(familiasClassificadas);
        Collections.reverse(familiasClassificadas);
    }

    public Familia get(int i) {
        return this.familiasClassificadas.get(i);
    }

    public int size(){
        return familiasClassificadas.size();
    }


}
