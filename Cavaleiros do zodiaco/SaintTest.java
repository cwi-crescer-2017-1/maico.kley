

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest
{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida()throws Exception {
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
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception{
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo()throws Exception{
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        assertEquals(Status.VIVO,shun.getStatus());
    }
    
    @Test
    public void deveSerPossivelTrocarGenero()throws Exception{
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        shun.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, shun.getGenero());
    }
    
    @Test
    public void aoCriarSaintVidaECem()throws Exception{
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        assertEquals(100., shun.getVida(), 0.01);
    }
    
    @Test
    public void perder10DeVida()throws Exception{
        //Arrange
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        //act
        shun.perderVida(10);
        //assert
        assertEquals(90, shun.getVida(), 0.01);
    }
    
    @Test
    public void perder100DeVida()throws Exception{
        //Arrange
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        //act
        shun.perderVida(100);
        //assert
        assertEquals(0, shun.getVida(), 0.01);
    }
    
    @Test
    public void perder1000DeVida()throws Exception{
        //Arrange
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        //act
        shun.perderVida(1000);
        //assert
        assertEquals(-900, shun.getVida(), 0.01);
    }
    
    @Test
    public void perderMenos1000DeVida()throws Exception{
        //Arrange
        Saint shun = new Saint("Shun", new Armadura("Andromeda", Categoria.BRONZE));
        //act
        shun.perderVida(-1000);
        //assert
        assertEquals(1100, shun.getVida(), 0.01);
    }

	@Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura("Águia", Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura("Peixes", Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura("Café", Categoria.OURO));
    }
}
