import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest
{
    @Test
    public void adicionarUmGolpe() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(new Golpe("Outra dimensão", 10));        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));        
    }

    @Test
    public void adicionarDoisGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));        
    }

    @Test
    public void adicionarTresGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));
        assertEquals(sataImperial, gemeos.getGolpes().get(2));
    }

    @Test
    public void adicionarQuatroGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        gemeos.adicionarGolpe(new Golpe("Cólera do café intenso", 80));
    }
}