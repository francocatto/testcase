package br.eti.francocatto.testcase.tests;

import br.eti.francocatto.testcase.model.auxiliar.CPF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeradorCPFTest {

    @Test
    public void gerarNumeroDe9DigitosAleatorioTest(){
        CPF cpf = GeradorCPF.novo();
        Assertions.assertEquals(cpf.semDV().length(), 9);
    }

    @Test
    public void calcularPrimeiroDV(){
        CPF cpf = new CPF("005451831");
        Assertions.assertEquals('8', cpf.toString().charAt(9));
    }

    @Test
    public void calcularSegundoDV(){
        CPF cpf = new CPF("005451831");
        Assertions.assertEquals('9', cpf.toString().charAt(10));
    }

}
