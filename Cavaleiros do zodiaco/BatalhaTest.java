import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void batalhaPrimeiroCategoriaMaisAlta()throws Exception{
        Constelacao virgem = new Constelacao("Virgem");
        Constelacao lira = new Constelacao("Lira");
        Saint saint1 = new Saint("Shaka", new Armadura(virgem, Categoria.OURO));
        Saint saint2 = new Saint("Orfeu", new Armadura(lira, Categoria.PRATA));
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
        assertEquals(100, saint1.getVida(),0);
    }
    
    @Test
    public void batalhaSegundoCategoriaMaisAlta()throws Exception{
        Constelacao lira = new Constelacao("Lira");
        Constelacao virgem = new Constelacao("Virgem");
        Saint saint1 = new Saint("Orfeu", new Armadura(lira, Categoria.PRATA));
        Saint saint2 = new Saint("Shaka", new Armadura(virgem, Categoria.OURO));
        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint1.getVida(),0);
        assertEquals(100, saint2.getVida(),0);
    }
    
    @Test
    public void batalhaMesmaCategoria()throws Exception{
        Constelacao dragao = new Constelacao("Dragão");
        Constelacao pegasus = new Constelacao("Pegasus");
        Saint saint1 = new Saint("Shiryu", new Armadura(dragao, Categoria.BRONZE));
        Saint saint2 = new Saint("Seiya", new Armadura(pegasus, Categoria.BRONZE));
        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
		assertEquals(100, saint1.getVida(),0);
        
    }
}
