

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest
{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida()throws Exception {
       //AAA
       // 1. Arrange - Montagem dos dados do teste
       Constelacao libra = new Constelacao("Libra");       
       Armadura libraA = new Armadura(libra, Categoria.OURO);
       Saint dohko = new Saint("Dohko", libraA);
       // 2. Act - Invocar a ação a ser testada
       dohko.vestirArmadura();
       // 3. Assert - Verificação dos resultados do teste
       boolean resultado = dohko.getArmaduraVestida();
       assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception {
        Constelacao cisne = new Constelacao("Cisne");
        Saint hyoga = new Saint("Hyoga", new Armadura(cisne, Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception{
        Constelacao virgem = new Constelacao("Virgem");
        Saint shaka = new Saint("Shaka", new Armadura(virgem, Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo()throws Exception{
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        assertEquals(Status.VIVO,shun.getStatus());
    }
    
    @Test
    public void deveSerPossivelTrocarGenero()throws Exception{
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        shun.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, shun.getGenero());
    }
    
    @Test
    public void aoCriarSaintVidaECem()throws Exception{
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        assertEquals(100., shun.getVida(), 0.01);
    }
    
    @Test
    public void perder10DeVida()throws Exception{
        //Arrange
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        //act
        shun.perderVida(10);
        //assert
        assertEquals(90, shun.getVida(), 0.01);
    }
    
    @Test
    public void perder100DeVida()throws Exception{
        //Arrange
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        //act
        shun.perderVida(100);
        //assert
        assertEquals(0, shun.getVida(), 0.01);
        assertEquals(Status.MORTO, shun.getStatus());
    }
    
    @Test
    public void perder1000DeVida()throws Exception{
        //Arrange
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        //act
        shun.perderVida(1000);
        //assert
        assertEquals(0, shun.getVida(), 0.01);
        assertEquals(Status.MORTO, shun.getStatus());
    }
    
    @Test (expected=InvalidParameterException.class)
    public void perderMenos1000DeVida()throws Exception{
        //Arrange
        Constelacao andromeda = new Constelacao("Andromeda");
        Saint shun = new Saint("Shun", new Armadura(andromeda, Categoria.BRONZE));
        //act
        shun.perderVida(-1000);        
    }

	@Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        Constelacao pegaso = new Constelacao("Pégaso");
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(pegaso, Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Constelacao aguia = new Constelacao("Águia");
        SilverSaint marin = new SilverSaint("Marin", new Armadura(aguia, Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Constelacao peixes = new Constelacao("Peixes");
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(peixes, Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        Constelacao cafe = new Constelacao("Café");
        new GoldSaint("Bernardo", new Armadura(cafe, Categoria.OURO));
    }
    
    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));        
        assertEquals(outraDimensao, saga.getGolpes().get(0));        
        // TODO: assert null
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);        
        assertEquals(outraDimensao, saga.getGolpes().get(0));
        assertEquals(explosaoGalatica, saga.getGolpes().get(1));        
    }

    @Test
    public void aprenderTresGolpes() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);        
        assertEquals(outraDimensao, saga.getGolpes().get(0));
        assertEquals(explosaoGalatica, saga.getGolpes().get(1));
        assertEquals(sataImperial,saga.getGolpes().get(2));
    }

    @Test
    public void aprenderQuatroGolpesLancaErro() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        Golpe rasteira = new Golpe("Rasteira", 2);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        saga.aprenderGolpe(rasteira);
    }

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }
}
