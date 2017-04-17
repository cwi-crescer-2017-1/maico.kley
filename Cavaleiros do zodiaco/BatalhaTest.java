import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void batalhaPrimeiroCategoriaMaisAlta(){
        Saint saint1 = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        Saint saint2 = new Saint("Orfeu", new Armadura("Lira", Categoria.PRATA));
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
        
    }
    
    @Test
    public void batalhaSegundoCategoriaMaisAlta(){
        Saint saint1 = new Saint("Orfeu", new Armadura("Lira", Categoria.PRATA));
        Saint saint2 = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint1.getVida(),0);
        
    }
    
    @Test
    public void batalhaMesmaCategoria(){
        Saint saint1 = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        Saint saint2 = new Saint("Seiya", new Armadura("Pegasus", Categoria.BRONZE));
        
        
        Batalha batalha = new Batalha(saint1, saint2);
        
        batalha.iniciar();
        
        assertEquals(90.0f, saint2.getVida(),0);
        
    }
}
