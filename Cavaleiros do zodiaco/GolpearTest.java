import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest
{
    @Test
    public void armaduraNaoVestidaMultiplicadorUmOuro() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe coleraDosCemDragoes = new Golpe("Cólera dos Cem Dragões", 10);
        dohko.aprenderGolpe(coleraDosCemDragoes);
        Golpear treta = new Golpear(dohko, shiryu);
        treta.executar();
        assertEquals(90, shiryu.getVida(), 0.01);
    }
    
    @Test
    public void armaduraNaoVestidaMultiplicadorUmPrata() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint orfeu = new SilverSaint("Orfeu", "Lira");
        Golpe acordeNoturno = new Golpe("Acorde Noturno", 10);
        orfeu.aprenderGolpe(acordeNoturno);        
        Golpear treta = new Golpear(orfeu, dohko);
        treta.executar();
        assertEquals(90, dohko.getVida(), 0.01);
    }
    
    @Test
    public void armaduraNaoVestidaMultiplicadorUmBronze() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe coleraDoDragao = new Golpe("Cólera do Dragão", 10);
        shiryu.aprenderGolpe(coleraDoDragao);
        Golpear treta = new Golpear(shiryu, dohko);
        treta.executar();
        assertEquals(90, dohko.getVida(), 0.01);
    }
    
    @Test
    public void armaduraVestidaMultiplicadorDois() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe coleraDoDragao = new Golpe("Cólera do Dragão", 10);
        shiryu.aprenderGolpe(coleraDoDragao);
        VestirArmadura prontoPraTreta = new VestirArmadura(shiryu);
        prontoPraTreta.executar();
        Golpear treta = new Golpear(shiryu, dohko);
        treta.executar();
        assertEquals(80, dohko.getVida(), 0.01);
    }
    
    @Test
    public void armaduraVestidaMultiplicadorTres() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint orfeu = new SilverSaint("Orfeu", "Lira");
        Golpe acordeNoturno = new Golpe("Acorde Noturno", 10);
        orfeu.aprenderGolpe(acordeNoturno);
        VestirArmadura prontoPraTreta = new VestirArmadura(orfeu);
        prontoPraTreta.executar();
        Golpear treta = new Golpear(orfeu, dohko);
        treta.executar();
        assertEquals(70, dohko.getVida(), 0.01);
    }
    
    @Test
    public void armaduraVestidaMultiplicadorQuatro() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint orfeu = new SilverSaint("Orfeu", "Lira");
        Golpe coleraDosCemDragoes = new Golpe("Cólera dos Cem Dragões", 10);
        dohko.aprenderGolpe(coleraDosCemDragoes);
        VestirArmadura prontoPraTreta = new VestirArmadura(dohko);
        prontoPraTreta.executar();
        Golpear treta = new Golpear(dohko, orfeu);
        treta.executar();
        assertEquals(60, orfeu.getVida(), 0.01);
    }
    
    @Test (expected=ArithmeticException.class)
    public void semGolpe() throws Exception{
        Saint dohko = new GoldSaint("Dohko", "Libra");
        Saint orfeu = new SilverSaint("Orfeu", "Lira");        
        Golpear treta = new Golpear(dohko, orfeu);
        treta.executar();
    }
}
