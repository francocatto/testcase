package br.eti.francocatto.testcase.model.auxiliar;

import java.util.Objects;

public class CPF {

    private final String numerosSemDV;
    public CPF(String numerosSemDV) {
        this.numerosSemDV = numerosSemDV;
    }

    public String semDV() {
        return numerosSemDV;
    }

    @Override
    public String toString() {
        return comDV();
    }

    private String comDV() {
        return acrescentarDV(acrescentarDV(this.numerosSemDV));
    }

    private static String acrescentarDV(String cadeiaDeNumeros){
        Integer acumulado = 0;
        for (char numero : cadeiaDeNumeros.toCharArray()){
            acumulado += (int) numero;
        }
        Integer mod11 = acumulado % 11;
        return cadeiaDeNumeros+mod11;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(numerosSemDV, cpf.numerosSemDV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerosSemDV);
    }
}
