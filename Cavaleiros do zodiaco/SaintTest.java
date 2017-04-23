

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.security.InvalidParameterException;

public class SaintTest
{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida()throws Exception {
       //AAA
       // 1. Arrange - Montagem dos dados do teste       
       Saint dohko = new GoldSaint("Dohko", "Libra");
       // 2. Act - Invocar a ação a ser testada
       dohko.vestirArmadura();
       // 3. Assert - Verificação dos resultados do teste
       boolean resultado = dohko.getArmaduraVestida();
       assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception {        
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception{        
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo()throws Exception{        
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        assertEquals(Status.VIVO,shun.getStatus());
    }
    
    @Test
    public void deveSerPossivelTrocarGenero()throws Exception{        
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        shun.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, shun.getGenero());
    }
    
    @Test
    public void aoCriarSaintVidaECem()throws Exception{
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        assertEquals(100., shun.getVida(), 0.01);
    }
    
    @Test
    public void perder10DeVida()throws Exception{
        //Arrange
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        //act
        shun.perderVida(10);
        //assert
        assertEquals(90, shun.getVida(), 0.01);
    }
    
    @Test
    public void perder100DeVida()throws Exception{
        //Arrange
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        //act
        shun.perderVida(100);
        //assert
        assertEquals(0, shun.getVida(), 0.01);
        assertEquals(Status.MORTO, shun.getStatus());
    }
    
    @Test
    public void perder1000DeVida()throws Exception{
        //Arrange
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        //act
        shun.perderVida(1000);
        //assert
        assertEquals(0, shun.getVida(), 0.01);
        assertEquals(Status.MORTO, shun.getStatus());
    }
    
    @Test (expected=InvalidParameterException.class)
    public void perderMenos1000DeVida()throws Exception{
        //Arrange
        Saint shun = new BronzeSaint("Shun", "Andromeda");
        //act
        shun.perderVida(-1000);        
    }

	@Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {        
        BronzeSaint seiya = new BronzeSaint("Seiya", "Pégaso");
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {        
        SilverSaint marin = new SilverSaint("Marin", "Águia");
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {        
        GoldSaint afrodite = new GoldSaint("Afrodite", "Peixes");
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {        
        new GoldSaint("Bernardo", "Café");
    }
    
    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));        
        assertEquals(outraDimensao, saga.getGolpes().get(0));        
        // TODO: assert null
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);        
        assertEquals(outraDimensao, saga.getGolpes().get(0));
        assertEquals(explosaoGalatica, saga.getGolpes().get(1));        
    }

    @Test
    public void aprenderTresGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
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
    public void aprenderQuatroGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
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
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
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
        Saint saga = new GoldSaint("Saga", "Gêmeos");
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
    
    @Test
    public void getCSVComArmaduraVestida() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String esperado = "Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());
    }

    @Test
    public void getCSVSemArmaduraVestida() throws Exception {
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
    
    @Test
    public void getCSVComNomeNulo() throws Exception {
        Saint june = new BronzeSaint(null, "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
    
    @Test(expected=Exception.class)
    public void aoCriarSaintDeOuroSemConstelaçãoDarErro() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "");
    }
    
    @Test
    public void getProximoMovimentoDois() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint orfeu = new SilverSaint("Orfeu", "Lira");       
        dohko.adicionarMovimento (new VestirArmadura (dohko));
        dohko.adicionarMovimento (new Golpear (dohko, orfeu));    
        assertEquals(true, dohko.getProximoMovimento() instanceof VestirArmadura);
        assertEquals(true, dohko.getProximoMovimento() instanceof Golpear);        
    }
}
