import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void batalhaPrimeiroCategoriaMaisAlta()throws Exception{        
        Saint saint1 = new GoldSaint("Shaka", "Virgem");
        Saint saint2 = new SilverSaint("Orfeu", "Lira");
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
        assertEquals(100, saint1.getVida(),0);
    }
    
    @Test
    public void batalhaSegundoCategoriaMaisAlta()throws Exception{        
        Saint saint1 = new SilverSaint("Orfeu", "Lira");
        Saint saint2 = new GoldSaint("Shaka", "Virgem");        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint1.getVida(),0);
        assertEquals(100, saint2.getVida(),0);
    }
    
    @Test
    public void batalhaMesmaCategoria()throws Exception{        
        Saint saint1 = new BronzeSaint("Shiryu", "Dragão");
        Saint saint2 = new BronzeSaint("Seiya", "Pegasus");        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
		assertEquals(100, saint1.getVida(),0);
        
    }
}
