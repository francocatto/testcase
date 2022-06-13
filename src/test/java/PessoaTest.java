import br.eti.francocatto.testcase.model.Pessoa;
import br.eti.francocatto.testcase.model.Vinculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    public void filhoMenorDeIdadeSemRendaEhDependente(){
        Pessoa bebe = new Pessoa("Joaquim", 2, 0.0, Vinculo.FILHO);
        Assertions.assertEquals(bebe.isDependente(), true);
    }

    @Test
    public void filhoMaiorDeIdadeSemRendaNaoEhDependente(){
        Pessoa jovemNemNem = new Pessoa("Joaquim", 19, 0.0, Vinculo.FILHO);
        Assertions.assertEquals(jovemNemNem.isDependente(), false);
    }
}
