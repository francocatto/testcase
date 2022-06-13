import br.eti.francocatto.testcase.model.Familia;
import br.eti.francocatto.testcase.model.FamiliasClassificadas;
import br.eti.francocatto.testcase.model.Pessoa;
import br.eti.francocatto.testcase.model.Vinculo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class FamiliasClassificadasTest {

    private List<Familia> familias = new ArrayList<Familia>();

    private FamiliasClassificadas familiasClassificadas = null;

    @BeforeEach
    public void carregarFamilias(){
        // CASAL RENDA 900
        Familia familiaRendaTotal900 = new Familia();
        familiaRendaTotal900.adicionar(new Pessoa("Franco", 35, 700.0, Vinculo.PRETENDENTE));
        familiaRendaTotal900.adicionar(new Pessoa("Claudia", 34, 200.0, Vinculo.CONJUGE));
        familias.add(familiaRendaTotal900);


        //CASAL RENDA 1500
        Familia casalRendaTotal1500 = new Familia();
        casalRendaTotal1500.adicionar(new Pessoa("Xavier", 35, 500.0, Vinculo.CONJUGE));
        casalRendaTotal1500.adicionar(new Pessoa("Augusta", 34, 1000.0, Vinculo.PRETENDENTE));
        familias.add(casalRendaTotal1500);

        //FAMILIA COM RENDA 900 E 1 FILHO DEPENDENTE E 1 FILHO NÃO DEPENDENTE
        Familia familiaRendaTotal900Com1Dependente = new Familia();
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa("João", 35, 700.0, Vinculo.PRETENDENTE));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa ("Ricardo", 18, 5000.0, Vinculo.FILHO));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa ("Carlos", 2, 0.0, Vinculo.FILHO));
        familiaRendaTotal900Com1Dependente.adicionar(new Pessoa("Claudia", 34, 200.0, Vinculo.CONJUGE));
        familias.add(familiaRendaTotal900Com1Dependente);

        //FAMILIA COM RENDA 900 E 3 DEPENDENTES
        Familia familiaRendaTotal900Com3Dependentes = new Familia();
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa("Roberto", 35, 700.0, Vinculo.PRETENDENTE));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Simon", 17, 0.0, Vinculo.FILHO));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Ian", 2, 0.0, Vinculo.FILHO));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa ("Tales", 10, 0.0, Vinculo.FILHO));
        familiaRendaTotal900Com3Dependentes.adicionar(new Pessoa("Cris", 34, 200.0, Vinculo.CONJUGE));
        familias.add(familiaRendaTotal900Com3Dependentes);

        //FAMILIA COM RENDA 1500 E 2 DEPENDENTES
        Familia familiaRendaTotal1500Com2Dependentes = new Familia();
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa("Rafael", 35, 1000.0, Vinculo.PRETENDENTE));
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa ("Francys", 14, 0.0, Vinculo.FILHO));
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa ("Cristiano", 2, 0.0, Vinculo.FILHO));
        familiaRendaTotal1500Com2Dependentes.adicionar(new Pessoa("Carla", 34, 500.0, Vinculo.CONJUGE));
        familias.add(familiaRendaTotal1500Com2Dependentes);

        //FAMILIA COM RENDA 1500 E 3 DEPENDENTES
        Familia familiaRendaTotal1500Com3Dependentes = new Familia();
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa("Dybala", 35, 1000.0, Vinculo.PRETENDENTE));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Ronaldo", 17, 0.0, Vinculo.FILHO));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Alex", 2, 0.0, Vinculo.FILHO));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa ("Djalminha", 10, 0.0, Vinculo.FILHO));
        familiaRendaTotal1500Com3Dependentes.adicionar(new Pessoa("Renata", 34, 500.0, Vinculo.CONJUGE));
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
    public void calculoRendaTotalAposAtualizacaoSalarial(){
        Familia familiaRendaTotal900 = familias.get(0);
        familiaRendaTotal900.getPretendente().atualizarRenda(800.0);
        Assertions.assertEquals(1000, familiaRendaTotal900.getRendaTotal());
    }

    @Test
    public void classificarFamiliaMenorRendaTresDependentes() {
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals("Roberto", familiasClassificadas.get(0).getPretendente().getNome());
    }

    @Test
    public void repetirClassificacao(){
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals("Roberto", familiasClassificadas.get(0).getPretendente().getNome());
        this.familiasClassificadas = new FamiliasClassificadas(familias);
        Assertions.assertEquals("Roberto", familiasClassificadas.get(0).getPretendente().getNome());
    }
}