import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
   @Test public void buscarSaintExistentePorNome() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        lista.adicionar(june);
        assertEquals(june, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint june2 = new SilverSaint("June", "Camaleão 2");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertEquals(june2, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintInexistente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint june2 = new SilverSaint("June", "Camaleão 2");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertNull(lista.buscarPorNome("San Junipero"));
    }

    @Test public void buscarSaintComListaVazia() {
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
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        misty.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorStatus(Status.VIVO);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(100);
        june.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscaPorStatus(Status.MORTO);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty","Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }       

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarTipoOrdenacaoDescendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }

    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false" + System.getProperty("line.separator") +"Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, lista.getCSV());
    }
    
    //verificar
    @Test
    public void unirDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
        assertEquals(resultado.get(2), shun);
        assertEquals(resultado.get(3), aldebaran);
    }
    
    @Test
    public void unirDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), shun);
        assertEquals(resultado.get(1), aldebaran);
    }
    
    @Test
    public void unirDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
    }
    
    @Test
    public void diffDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        Saint mu = new GoldSaint ("Mu", "Áries");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista1.adicionar (shun);
        lista1.adicionar (aldebaran);
        lista2.adicionar (seiya);
        lista2.adicionar (mu);
        lista2.adicionar (milo);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(shun, resultado.get(0));
        assertEquals(aldebaran, resultado.get(1));
    }
    
    @Test
    public void diffDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(resultado.todos().size(),0);
    }
    
    @Test
    public void diffDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
    }
    
    @Test
    public void intersecDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        Saint mu = new GoldSaint ("Mu", "Áries");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista1.adicionar (shun);
        lista2.adicionar (mu);
        lista2.adicionar (aldebaran);
        lista2.adicionar (seiya);
        lista2.adicionar (mu);
        lista2.adicionar (milo);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(seiya, resultado.get(0));
        assertEquals(milo, resultado.get(1));
    }
    
    @Test
    public void intersecDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(resultado.todos().size(), 0);
    }
    
    @Test
    public void intersecDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(resultado.todos().size(), 0);
    }
}
