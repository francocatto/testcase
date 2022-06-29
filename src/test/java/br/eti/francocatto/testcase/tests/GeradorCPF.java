package br.eti.francocatto.testcase.tests;

import br.eti.francocatto.testcase.model.auxiliar.CPF;

import java.util.Random;

public class GeradorCPF {
    public static CPF novo() {
        Integer cpfNumerosAleatorios = new Random().nextInt(999999999);
        String numerosSemDV = String.format("%09d", cpfNumerosAleatorios);
        CPF cpf = new CPF(numerosSemDV);
        return cpf;
    }
}
