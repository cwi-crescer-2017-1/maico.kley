

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest
{
    @Test
    public void adicionarUmGolpe(){
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra Dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
    }
    
    @Test
    public void adicionarDoisGolpes(){
        
    }
    
    @Test 
    public void adicionarTresGolpes(){
        
    }
    
    @Test void adicionarQuatroGolpes(){
        
    }
}