

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest
{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida() {
       //AAA
       // 1. Arrange - Montagem dos dados do teste
       Armadura libra = new Armadura("Libra", Categoria.OURO);
       Saint dohko = new Saint("Dohko", libra);
       // 2. Act - Invocar a ação a ser testada
       dohko.vestirArmadura();
       // 3. Assert - Verificação dos resultados do teste
       boolean resultado = dohko.getArmaduraVestida();
       assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }
}
