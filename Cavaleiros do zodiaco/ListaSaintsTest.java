import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
   @Test 
   public void buscarSaintExistentePorNome()throws Exception{
       ListaSaints lista = new ListaSaints();       
       Constelacao libra = new Constelacao("Libra");       
       Armadura libraA = new Armadura(libra, Categoria.OURO);
       Saint dohko = new Saint("Dohko", libraA);       
       lista.adicionar(dohko);
       assertEquals(dohko, lista.buscarPorNome("Dohko"));       
    }
    
    @Test
    public void buscarSaintExistenteComRepeticaoDeNomes()throws Exception{
       ListaSaints lista = new ListaSaints();       
       Constelacao libra = new Constelacao("Libra");       
       Armadura libraA = new Armadura(libra, Categoria.OURO);
       Saint dohko = new Saint("Dohko", libraA);   
       Constelacao libra2 = new Constelacao("Libra Menor");       
       Armadura libraA2 = new Armadura(libra2, Categoria.PRATA);
       Saint dohko2 = new Saint("Dohko", libraA2); 
       lista.adicionar(dohko2);
       lista.adicionar(dohko);
       assertEquals(dohko2, lista.buscarPorNome("Dohko"));  
    }
    
    @Test
    public void buscarSaintsInexistente()throws Exception{
       ListaSaints lista = new ListaSaints();       
       Constelacao libra = new Constelacao("Libra");       
       Armadura libraA = new Armadura(libra, Categoria.OURO);
       Saint dohko = new Saint("Dohko", libraA);   
       Constelacao libra2 = new Constelacao("Libra Menor");       
       Armadura libraA2 = new Armadura(libra2, Categoria.PRATA);
       Saint dohko2 = new Saint("Dohko", libraA2); 
       lista.adicionar(dohko2);
       lista.adicionar(dohko);
       assertNull(lista.buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarSaintComListaVazia(){
        assertNull(new ListaSaints().buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
}
