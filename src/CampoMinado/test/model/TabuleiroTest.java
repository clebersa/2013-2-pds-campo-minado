/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samuel
 */
public class TabuleiroTest {

    Tabuleiro tabuleiro_test;

    public TabuleiroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of distribuirMinas method, of class Tabuleiro.
     */
    @Test
    public void testDistribuirMinas() {
        System.out.println("distribuirMinas");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        instance.distribuirMinas(new DistribuiAleatorio());
        assertEquals(instance.getMinas(), 10);

        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        instance.distribuirMinas(new DistribuiAleatorio());
        assertEquals(instance.getMinas(), 40);

        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        instance.distribuirMinas(new DistribuiAleatorio());
        assertEquals(instance.getMinas(), 99);

        instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        instance.distribuirMinas(new DistribuiPorArquivo());
        assertEquals(instance.getMinas(), 10);

        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        instance.distribuirMinas(new DistribuiPorArquivo());
        assertEquals(instance.getMinas(), 40);

        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        instance.distribuirMinas(new DistribuiPorArquivo());
        assertEquals(instance.getMinas(), 99);

    }

    /**
     * Test of executarJogada method, of class Tabuleiro.
     */
    @Test
    public void testExecutarJogada() {
        System.out.println("executarJogada");

        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        instance.distribuirMinas(new DistribuiAleatorio());

        Jogada jogada = new Jogada(5, 5, TipoJogada.ABRIR);

        ResultadoJogada result = instance.executarJogada(jogada);
        boolean jogadaValida = false;
        if (result == ResultadoJogada.CONTINUA || result == ResultadoJogada.DERROTA || result == ResultadoJogada.VITORIA) {
            jogadaValida = true;
        }
        assertTrue(jogadaValida);
    }

    /**
     * Test of getLinhas method, of class Tabuleiro.
     */
    @Test
    public void testGetLinhas() {
        System.out.println("getLinhas");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        int expResult = 9;
        int result = instance.getLinhas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        expResult = 16;
        result = instance.getLinhas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        expResult = 20;
        result = instance.getLinhas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColunas method, of class Tabuleiro.
     */
    @Test
    public void testGetColunas() {
        System.out.println("getColunas");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        int expResult = 9;
        int result = instance.getColunas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        expResult = 16;
        result = instance.getColunas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        expResult = 24;
        result = instance.getColunas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinas method, of class Tabuleiro.
     */
    @Test
    public void testGetMinas() {
        System.out.println("getMinas");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        int expResult = 10;
        int result = instance.getMinas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        expResult = 40;
        result = instance.getMinas();
        assertEquals(expResult, result);

        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        expResult = 99;
        result = instance.getMinas();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarMina method, of class Tabuleiro.
     */
    @Test
    public void testAdicionarMina() {
        System.out.println("adicionarMina");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);

        int linha = 5;
        int coluna = 5;

        boolean result;

        result = instance.adicionarMina(linha, coluna);
        assertTrue(result);

        result = instance.adicionarMina(linha, coluna);
        assertFalse(result);
    }

    /**
     * Test of createBandeirasIterator method, of class Tabuleiro.
     */
    @Test
    public void testCreateBandeirasIterator() {
        System.out.println("createBandeirasIterator");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        BandeirasIterator result = instance.createBandeirasIterator();
        assertTrue(result instanceof BandeirasIterator);
    }

    /**
     * Test of createVizinhosIterator method, of class Tabuleiro.
     */
    @Test
    public void testCreateVizinhosIterator() {
        System.out.println("createVizinhosIterator");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        VizinhosIterator result = instance.createVizinhosIterator(new Quadrado(0, 0));
        assertTrue(result instanceof VizinhosIterator);
    }

    /**
     * Test of createMinasIterator method, of class Tabuleiro.
     */
    @Test
    public void testCreateMinasIterator() {
        System.out.println("createMinasIterator");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        MinasIterator result = instance.createMinasIterator();
        assertTrue(result instanceof MinasIterator);
    }

    /**
     * Test of createTabuleiroIterator method, of class Tabuleiro.
     */
    @Test
    public void testCreateTabuleiroIterator() {
        System.out.println("createTabuleiroIterator");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        TabuleiroIterator result = instance.createTabuleiroIterator();
        assertTrue(result instanceof TabuleiroIterator);
    }

    /**
     * Test of exibir method, of class Tabuleiro.
     */
    @Test
    public void testExibir() {
        System.out.println("exibir");
        System.out.println("Esperado:.\n"
                + "0  1  2  3  4  5  6  7  8 \n"
                + " 0 [#][#][#][#][#][#][#][#][#]\n"
                + " 1 [#][#][#][#][#][#][#][#][#]\n"
                + " 2 [#][#][#][#][#][#][#][#][#]\n"
                + " 3 [#][#][#][#][#][#][#][#][#]\n"
                + " 4 [#][#][#][#][#][#][#][#][#]\n"
                + " 5 [#][#][#][#][#][#][#][#][#]\n"
                + " 6 [#][#][#][#][#][#][#][#][#]\n"
                + " 7 [#][#][#][#][#][#][#][#][#]\n"
                + " 8 [#][#][#][#][#][#][#][#][#]\n"
                + "Bandeiras: 0/10");
        Tabuleiro instance = new Tabuleiro(TipoTabuleiro.INICIANTE);
        System.out.println("Obtido:.");
        instance.exibir();

        System.out.println("Esperado:.\n"
                + "    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 \n"
                + " 0 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 1 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 2 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 3 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 4 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 5 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 6 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 7 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 8 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 9 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "10 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "11 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "12 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "13 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "14 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "15 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "Bandeiras: 0/40");
        instance = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        System.out.println("Obtido:.");
        instance.exibir();

        System.out.println("Esperado:.\n"
                + "    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 \n"
                + " 0 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 1 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 2 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 3 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 4 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 5 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 6 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 7 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 8 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + " 9 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "10 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "11 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "12 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "13 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "14 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "15 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "16 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "17 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "18 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "19 [#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#][#]\n"
                + "Bandeiras: 0/99");
        instance = new Tabuleiro(TipoTabuleiro.AVANCADO);
        System.out.println("Obtido:.");
        instance.exibir();

    }

}
