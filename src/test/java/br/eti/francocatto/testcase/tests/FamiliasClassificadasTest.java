package br.eti.francocatto.testcase.tests;

import br.eti.francocatto.testcase.model.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class FamiliasClassificadasTest {

    private List<Familia> familias = new ArrayList<Familia>();

    private FamiliasClassificadas familiasClassificadas = null;

    @BeforeEach
    public void carregarFamilias(){
        // CASAL RENDA 900 - Index 0
        Familia familiaRendaTotal900 = new Familia();
        familiaRendaTotal900.adicionar(new Pessoa("Franco", 35, 700.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familiaRendaTotal900.adicionar(new Pessoa("Claudia", 34, 200.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        familias.add(familiaRendaTotal900);


        //CASAL RENDA 1500 - Index 1
        Familia casalRendaTotal1500 = new Familia();
        casalRendaTotal1500.adicionar(new Pessoa("Xavier", 35, 500.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        casalRendaTotal1500.adicionar(new Pessoa("Augusta", 34, 1000.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familias.add(casalRendaTotal1500);

        //FAMILIA COM RENDA 900 E 1 FILHO DEPENDENTE E 1 FILHO NÃO DEPENDENTE - Index 2
        Familia familiaRendaTotal900Com1Dependente = new Familia();
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa("João", 35, 700.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa ("Ricardo", 19, 5000.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa ("Carlos", 2, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa("Claudia", 34, 200.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        familias.add(familiaRendaTotal900Com1Dependente);

        //FAMILIA COM RENDA 900 E 3 DEPENDENTES - Index 3
        Familia familiaRendaTotal900Com3Dependentes = new Familia();
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa("Roberto", 35, 700.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Simon", 17, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Ian", 2, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Tales", 10, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa("Cris", 34, 200.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        familias.add(familiaRendaTotal900Com3Dependentes);

        //FAMILIA COM RENDA 1500 E 2 DEPENDENTES - Index 4
        Familia familiaRendaTotal1500Com2Dependentes = new Familia();
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa("Rafael", 35, 1500.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa ("Francys", 14, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa("Carla", 34, 0.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        familias.add(familiaRendaTotal1500Com2Dependentes);

        //FAMILIA COM RENDA 1500 E 3 DEPENDENTES - Index 5
        Familia familiaRendaTotal1500Com3Dependentes = new Familia();
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa("Dybala", 35, 1000.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Ronaldo", 17, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Alex", 2, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Djalminha", 10, 0.0, Vinculo.FILHO, GeradorCPF.novo()));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa("Renata", 34, 500.0, Vinculo.CONJUGE, GeradorCPF.novo()));
        familias.add(familiaRendaTotal1500Com3Dependentes);

    }

    @AfterEach
    public void limparAlteracoes(){
        this.familias = new ArrayList<>();
    }

    @Test
    public void calcularRendaTotalCasal900(){
        Familia familiaRendaTotal900 = familias.get(0);
        Assertions.assertEquals(900, familiaRendaTotal900.getRendaTotal());
    }
    @Test
    public void ignorarRendaDeNaoDependenteEmFamilia(){
        Familia familiaRendaTotal900Com1Dependente = familias.get(2);
        Assertions.assertEquals(900, familiaRendaTotal900Com1Dependente.getRendaTotal());
    }

    @Test
    public void calculoRendaTotalAposAtualizacaoSalarial(){
        Familia familiaRendaTotal900 = familias.get(0);
        familiaRendaTotal900.getPretendente().atualizarRenda(800.0);
        Assertions.assertEquals(1000, familiaRendaTotal900.getRendaTotal());
    }

    @Test
    public void primeiroLugar3DependentesMenorFaixaRenda() {
        Familia familiaClassificada = this.familias.stream().filter(familia -> familia.getPretendente().getNome().equals("Roberto")).findFirst().get();
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals(familiaClassificada, familiasClassificadas.get(0));
    }

    @Test
    public void filhoMaiorDeIdadeNaoEhDependente() {
        Familia familiaClassificada = this.familias.stream().filter(familia -> familia.getPretendente().getNome().equals("João")).findFirst().get();
        Assertions.assertEquals(1, familiaClassificada.getDependentes().size());
    }

    @Test
    public void conjugeSemRendaEhDependente(){
        Familia familiaClassificada = this.familias.stream().filter(familia -> familia.getPretendente().getNome().equals("Rafael")).findFirst().get();
        Assertions.assertEquals(2, familiaClassificada.getDependentes().size());
    }

    @Test
    public void ultimoLugarCasalSemDependentesMaiorFaixaDeRenda() {
        Familia familiaClassificada = this.familias.stream().filter(familia -> familia.getPretendente().getNome().equals("Augusta")).findFirst().get();
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals(familiaClassificada.getPretendente().getNome(), familiasClassificadas.get(familiasClassificadas.size()-1).getPretendente().getNome());
    }

    @Test
    public void naoDaErroParaListaVaziaOuUmaUnicaPessoaCadastrada() {
        this.familias.clear();
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals(0, familiasClassificadas.size());
        Familia pessoaSolteiraSemFilhos = new Familia();
        pessoaSolteiraSemFilhos.adicionar(new Pessoa("Franco", 35, 700.0, Vinculo.PRETENDENTE, GeradorCPF.novo()));
        familias.add(pessoaSolteiraSemFilhos);
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals(pessoaSolteiraSemFilhos, familiasClassificadas.get(0));

    }
}